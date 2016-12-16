<%-- 
    Document   : view
    Created on : Dec 15, 2016, 3:44:50 PM
    Author     : robha
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<s:message code="intervals.edit" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/serviceintervals/editItem"
               modelAttribute="interval" cssClass="form-horizontal">
          <form:input type="hidden" path="id" />
      <div class="form-group">
          <form:label path="car.id" cssClass="col-sm-2 control-label"><fmt:message key="general.car"/></form:label>
            <div class="col-sm-4">
                <form:select path="car.id" cssClass="form-control">
                    <c:forEach items="${cars}" var="c">
                        <form:option value="${c.id}">${c.manufacturer} - ${c.model}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="car.id" cssClass="help-block"/></p>
            </div> 
        </div>
       <div class="form-group ${begin_error?'has-error':''}" >
            <form:label path="beginDate" cssClass="col-sm-2 control-label"><fmt:message key="general.begin"/></form:label>
            <div class="col-sm-4">
                <fmt:formatDate value="${interval.beginDate}" type="date" pattern="dd/MM/yyyy" var="theFormattedDate" />
                <form:input type="text" path="beginDate" id="timepicker"  value="${theFormattedDate}" cssClass="form-control"/>
                <form:errors path="beginDate" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${end_error?'has-error':''}" >
            <form:label path="endDate" cssClass="col-sm-2 control-label"><fmt:message key="general.end"/></form:label>
            <div class="col-sm-4">
                <fmt:formatDate value="${interval.endDate}" type="date" pattern="dd/MM/yyyy" var="theFormattedDate" />
                <form:input type="text" path="endDate" id="timepicker2"  value="${theFormattedDate}" cssClass="form-control"/>
                <form:errors path="endDate" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${visited_error?'has-error':''}" >
            <form:label path="visitedDate" cssClass="col-sm-2 control-label"><fmt:message key="general.visited"/></form:label>
            <div class="col-sm-4">
                <fmt:formatDate value="${interval.visitedDate}" type="date" pattern="dd/MM/yyyy" var="theFormattedDate" />
                <form:input type="text" path="visitedDate" id="timepicker3"  value="${theFormattedDate}" cssClass="form-control"/>
                <form:errors path="visitedDate" cssClass="help-block"/>
            </div>
        </div>
           
            <div class="form-group">  
                <div class="col-sm-2"></div>  <div class="col-sm-4">
                       <button class="btn btn-primary" type="submit"><fmt:message key="general.save"/></button>
                       </div>
                </div>
 
    </form:form>
        <script type="text/javascript">
            $('#timepicker').datepicker({ dateFormat: 'dd/mm/yy' });
            $('#timepicker2').datepicker({ dateFormat: 'dd/mm/yy' });
            $('#timepicker3').datepicker({ dateFormat: 'dd/mm/yy' });
             
        </script>
</jsp:attribute>
</my:pagetemplate>
