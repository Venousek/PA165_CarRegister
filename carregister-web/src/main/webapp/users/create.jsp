<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="dateObject" class="java.util.Date" />
<s:message code="users.new" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/users/create"
               modelAttribute="user" cssClass="form-horizontal">
        
        <div class="form-group ${login_error?'has-error':''}">
            <form:label path="login" cssClass="col-sm-2 control-label">Login</form:label>
            <div class="col-sm-10">
                <form:input path="login" cssClass="form-control"/>
                <form:errors path="login" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${password_error?'has-error':''}">
            <form:label path="password" cssClass="col-sm-2 control-label">Password</form:label>
            <div class="col-sm-10">
                <form:input path="password" cssClass="form-control"/>
                <form:errors path="password" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${firstname_error?'has-error':''}">
            <form:label path="firstname" cssClass="col-sm-2 control-label">First Name</form:label>
            <div class="col-sm-10">
                <form:input path="firstname" cssClass="form-control"/>
                <form:errors path="firstname" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${lastname_error?'has-error':''}">
            <form:label path="lastname" cssClass="col-sm-2 control-label">Last Name</form:label>
            <div class="col-sm-10">
                <form:input path="lastname" cssClass="form-control"/>
                <form:errors path="lastname" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${email_error?'has-error':''}">
            <form:label path="email" cssClass="col-sm-2 control-label">E-Mail</form:label>
            <div class="col-sm-10">
                <form:input path="email" cssClass="form-control"/>
                <form:errors path="email" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="role" cssClass="col-sm-2 control-label">Role</form:label>
            <div class="col-sm-10">
                <form:select path="role" cssClass="form-control">
                    <c:forEach items="${roles}" var="r">
                        <form:option value="${r}">${r.description}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="role" cssClass="error"/></p>
            </div>
        </div>
        
        
        <div class="form-group">  
            <div class="col-sm-2"></div>  <div class="col-sm-4">
                <button class="btn btn-primary" type="submit"><fmt:message key="users.create"/></button>
            </div>
        </div>
 
    </form:form>
</jsp:attribute>
</my:pagetemplate>
