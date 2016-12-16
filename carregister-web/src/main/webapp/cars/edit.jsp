<%-- 
    Document   : edit
    Created on : 16.12.2016, 22:40:20
    Author     : Henrich
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<s:message code="cars.edit" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/cars/edit"
               modelAttribute="car" cssClass="form-horizontal">
        
        <form:input type="hidden" path="id" />
          
        <div class="form-group" >
            <form:label path="car.manufacturer" cssClass="col-sm-2 control-label"><fmt:message key="cars.manufacturer"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.manufacturer" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.model" cssClass="col-sm-2 control-label"><fmt:message key="cars.model"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.model" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.year" cssClass="col-sm-2 control-label"><fmt:message key="cars.year"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.year" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.fuel" cssClass="col-sm-2 control-label"><fmt:message key="cars.fuel"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.fuel" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.mileage" cssClass="col-sm-2 control-label"><fmt:message key="cars.mileage"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.mileage" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.register_number" cssClass="col-sm-2 control-label"><fmt:message key="cars.register_number"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.register_number" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.vin" cssClass="col-sm-2 control-label"><fmt:message key="cars.vin"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.vin" cssClass="form-control"/>
            </div>
          </div>
           
            <div class="form-group">  
                <div class="col-sm-2"></div>  <div class="col-sm-4">
                       <button class="btn btn-primary" type="submit"><fmt:message key="general.save"/></button>
                       </div>
                </div>
 
    </form:form>
</jsp:attribute>
</my:pagetemplate>
