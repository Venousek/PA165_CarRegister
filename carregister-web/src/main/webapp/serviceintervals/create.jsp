<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<s:message code="intervals.new" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/serviceintervals/create"
               modelAttribute="intervalCreate" cssClass="form-horizontal">
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
        <div class="form-group ${beginLong_error?'has-error':''}" >
            <form:label path="beginLong" cssClass="col-sm-2 control-label"><fmt:message key="general.begin"/></form:label>
            <div class="col-sm-4">
                <form:input path="beginLong" id="timepicker1" cssClass="form-control"/>
                <form:errors path="beginLong" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${endLong_error?'has-error':''}" >
            <form:label path="endLong" cssClass="col-sm-2 control-label"><fmt:message key="general.end"/></form:label>
            <div class="col-sm-4">
                <form:input path="endLong" cssClass="form-control"/>
                <form:errors path="endLong" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${visitedLong_error?'has-error':''}" >
            <form:label path="visitedLong" cssClass="col-sm-2 control-label"><fmt:message key="general.visited"/></form:label>
            <div class="col-sm-4">
                <form:input path="visitedLong" cssClass="form-control"/>
                <form:errors path="visitedLong" cssClass="help-block"/>
            </div>
        </div>
            <div class="form-group">  
                <div class="col-sm-2"></div>  <div class="col-sm-4">
                       <button class="btn btn-primary" type="submit"><fmt:message key="intervals.create"/></button>
                       </div>
                </div>
 
    </form:form>
        <script type="text/javascript">
            $('#timepicker1').timepicker();
        </script>
</jsp:attribute>
</my:pagetemplate>
