<%-- 
    Document   : create
    Created on : 16.12.2016, 12:27:13
    Author     : Henrich
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<s:message code="cars.new" var="title"/>
<my:pagetemplate title="${title}">
    
<jsp:attribute name="body">
    <form:form method="post" action="${pageContext.request.contextPath}/cars/create"
               modelAttribute="car" cssClass="form-horizontal">

        <div class="form-group ${manufacturer_error?'has-error':''}">
            <form:label path="manufacturer" cssClass="col-sm-2 control-label"><fmt:message key="cars.manufacturer"/></form:label>
            <div class="col-sm-4">
                <form:input path="manufacturer" cssClass="form-control"/>
                <form:errors path="manufacturer" cssClass="help-block"/>
            </div>
        </div>
          
        <div class="form-group ${model_error?'has-error':''}">
            <form:label path="model" cssClass="col-sm-2 control-label"><fmt:message key="cars.model"/></form:label>
            <div class="col-sm-4">
                <form:input path="model" cssClass="form-control"/>
                <form:errors path="model" cssClass="help-block"/>
            </div>
        </div>
            
        <div class="form-group ${year_error?'has-error':''}">
            <form:label path="year" cssClass="col-sm-2 control-label"><fmt:message key="cars.year"/></form:label>
            <div class="col-sm-4">
                <form:input path="year" cssClass="form-control"/>
                <form:errors path="year" cssClass="help-block"/>
            </div>
        </div>
                                
      <div class="form-group">
          <form:label path="fuel" cssClass="col-sm-2 control-label"><fmt:message key="cars.fuel"/></form:label>
            <div class="col-sm-4">
                <form:select path="fuel" cssClass="form-control">
                    <c:forEach items="${fuels}" var="fuel">
                        <form:option value="${fuel}">${fuel.description}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="fuel" cssClass="help-block"/></p>
            </div> 
        </div>
            
        <div class="form-group ${mileage_error?'has-error':''}">
            <form:label path="mileage" cssClass="col-sm-2 control-label"><fmt:message key="cars.mileage"/></form:label>
            <div class="col-sm-4">
                <form:input path="mileage" cssClass="form-control"/>
                <form:errors path="mileage" cssClass="help-block"/>
            </div>
        </div>
      
          <div class="form-group ${register_number_error?'has-error':''}" >
            <form:label path="register_number" cssClass="col-sm-2 control-label"><fmt:message key="cars.register_number"/></form:label>
            <div class="col-sm-4">
                <form:input path="register_number" cssClass="form-control"/>
                <form:errors path="register_number" cssClass="help-block"/>
            </div>
          </div>
            
        <div class="form-group ${vin_error?'has-error':''}">
            <form:label path="vin" cssClass="col-sm-2 control-label"><fmt:message key="cars.vin"/></form:label>
            <div class="col-sm-4">
                <form:input path="vin" cssClass="form-control"/>
                <form:errors path="vin" cssClass="help-block"/>
            </div>
        </div>
           
            <div class="form-group">  
                <div class="col-sm-2"></div>
                <div class="col-sm-4">
                    <button class="btn btn-primary" type="submit"><fmt:message key="cars.create"/></button>
                </div>
            </div>
 
    </form:form>
</jsp:attribute>
</my:pagetemplate>
