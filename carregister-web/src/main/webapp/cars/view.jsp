<%-- 
    Document   : view
    Created on : 16.12.2016, 23:23:36
    Author     : Henrich
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<s:message code="cars.view" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <div class="form-horizontal">
            <div>
                <br />
                
          <div class="form-group" >
            <form:label path="car.manufacturer" cssClass="col-sm-2 control-label"><fmt:message key="cars.manufacturer"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.manufacturer" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.model" cssClass="col-sm-2 control-label"><fmt:message key="cars.model"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.model" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.year" cssClass="col-sm-2 control-label"><fmt:message key="cars.year"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.year" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.fuel" cssClass="col-sm-2 control-label"><fmt:message key="cars.fuel"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.fuel" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.mileage" cssClass="col-sm-2 control-label"><fmt:message key="cars.mileage"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.mileage" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.register_number" cssClass="col-sm-2 control-label"><fmt:message key="cars.register_number"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.register_number" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="car.vin" cssClass="col-sm-2 control-label"><fmt:message key="cars.vin"/></form:label>
            <div class="col-sm-4">
                <form:input path="car.vin" readonly="true" cssClass="form-control"/>
            </div>
          </div>
            
           <div class="form-group" >
            <div class="col-sm-4"></div>
            <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/cars/delete/${car.id}">
                    <button type="submit" class="btn btn-danger"><fmt:message key="general.delete"/></button>
                </form>
            </div>
             <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/cars/edit/${car.id}">
                    <button type="submit" class="btn btn-success"><fmt:message key="general.edit"/></button>
                </form>
            </div>
          </div> 
            

                
                      </div>
        </div>
</jsp:attribute>
</my:pagetemplate>