<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="dateObject" class="java.util.Date" />
<s:message code="users.view" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

         <div class="form-horizontal">
            <div>
                <br />
          <div class="form-group" >
            <form:label path="user.id" cssClass="col-sm-2 control-label">ID</form:label>
            <div class="col-sm-4">
                <form:input path="user.id" readonly="true" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="user.login" cssClass="col-sm-2 control-label">Login</form:label>
            <div class="col-sm-4">
                <form:input path="user.login" readonly="true" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="user.firstname" cssClass="col-sm-2 control-label">Firstname</form:label>
            <div class="col-sm-4">
                <form:input path="user.firstname" readonly="true" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="user.lastname" cssClass="col-sm-2 control-label">Lastname</form:label>
            <div class="col-sm-4">
                <form:input path="user.lastname" readonly="true" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="user.email" cssClass="col-sm-2 control-label">Email</form:label>
            <div class="col-sm-4">
                <form:input path="user.email" readonly="true" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="user.role" cssClass="col-sm-2 control-label">Role</form:label>
            <div class="col-sm-4">
                <form:input path="user.role" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
           <div class="form-group" >
            <div class="col-sm-4"></div>
            <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/users/delete/${user.id}">
                    <button type="submit" class="btn btn-danger"><fmt:message key="general.delete"/></button>
                </form>
            </div>
             <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/users/edit/${user.id}">
                    <button type="submit" class="btn btn-success"><fmt:message key="general.edit"/></button>
                </form>
            </div>
          </div> 
            

                
        </div>  
        </div>
</jsp:attribute>
</my:pagetemplate>