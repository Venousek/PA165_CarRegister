<%-- 
    Document   : create
    Created on : Dec 16, 2016, 11:01:04 PM
    Author     : ferko
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<s:message code="drives.new" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/drives/create"
               modelAttribute="driveCreate" cssClass="form-horizontal">
        
        <div class="form-group">
            <form:label path="userId" cssClass="col-sm-2 control-label"><fmt:message key="general.user"/></form:label>
            <div class="col-sm-4">
                <form:select path="userId" cssClass="form-control">
                    <c:forEach items="${users}" var="u">
                        <form:option value="${u.id}">${u.firstname} - ${u.lastname}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="userId" cssClass="error"/></p>
            </div>
        </div>
        <div class="form-group">
          <form:label path="carId" cssClass="col-sm-2 control-label"><fmt:message key="general.car"/></form:label>
            <div class="col-sm-4">
                <form:select path="carId" cssClass="form-control">
                    <c:forEach items="${cars}" var="c">
                        <form:option value="${c.id}">${c.manufacturer} - ${c.model}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="carId" cssClass="help-block"/></p>
            </div> 
        </div>
        <div class="form-group ${begin_error?'has-error':''}" >
            <form:label path="beginDate" cssClass="col-sm-2 control-label"><fmt:message key="general.begin"/></form:label>
            <div class="col-sm-4">
                <form:input type="text" path="beginStringDate" id="timepicker" cssClass="form-control"/>
                <form:errors path="beginDate" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${end_error?'has-error':''}" >
            <form:label path="endDate" cssClass="col-sm-2 control-label"><fmt:message key="general.end"/></form:label>
            <div class="col-sm-4">
                <form:input type="text" path="endStringDate" id="timepicker2" cssClass="form-control"/>
                <form:errors path="endDate" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${distance_error?'has-error':''}">
            <form:label path="distance" cssClass="col-sm-2 control-label"><fmt:message key="general.distance"/></form:label>
            <div class="col-sm-4">
                <form:input path="distance" cssClass="form-control"/>
                <form:errors path="distance" cssClass="help-block"/>
            </div>
        </div>
       
        
        
        <div class="form-group">  
                <div class="col-sm-2"></div>  <div class="col-sm-4">
                       <button class="btn btn-primary" type="submit"><fmt:message key="drives.create"/></button>
                       </div>
                </div>
 
    </form:form>
            <script type="text/javascript">
            $('#timepicker').datepicker({ dateFormat: 'dd/mm/yy' });
            $('#timepicker2').datepicker({ dateFormat: 'dd/mm/yy' });
             
        </script>
</jsp:attribute>
</my:pagetemplate>

