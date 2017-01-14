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
    <form:form method="post" action="${pageContext.request.contextPath}/cars/edited"
               modelAttribute="car" cssClass="form-horizontal">
        
        <form:input type="hidden" path="id" />
          
        <div class="form-group" >
            <form:label path="manufacturer" cssClass="col-sm-2 control-label"><fmt:message key="cars.manufacturer"/></form:label>
            <div class="col-sm-4">
                <form:input path="manufacturer" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="model" cssClass="col-sm-2 control-label"><fmt:message key="cars.model"/></form:label>
            <div class="col-sm-4">
                <form:input path="model" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="year" cssClass="col-sm-2 control-label"><fmt:message key="cars.year"/></form:label>
            <div class="col-sm-4">
                <form:input path="year" cssClass="form-control"/>
            </div>
          </div>
                
          <div class="form-group">
            <form:label path="fuel" cssClass="col-sm-2 control-label"><fmt:message key="cars.fuel"/></form:label>
            <div class="col-sm-4">
                <form:select path="fuel" cssClass="form-control">
                    <c:forEach items="${fuels}" var="f">
                        <form:option value="${f}">${f.description}</form:option>
                    </c:forEach>
                </form:select>
                <p class="help-block"><form:errors path="fuel" cssClass="error"/></p>
            </div> 
          </div>
            
          <div class="form-group" >
            <form:label path="mileage" cssClass="col-sm-2 control-label"><fmt:message key="cars.mileage"/></form:label>
            <div class="col-sm-4">
                <form:input path="mileage" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="register_number" cssClass="col-sm-2 control-label"><fmt:message key="cars.register_number"/></form:label>
            <div class="col-sm-4">
                <form:input path="register_number" cssClass="form-control"/>
            </div>
          </div>
            
          <div class="form-group" >
            <form:label path="vin" cssClass="col-sm-2 control-label"><fmt:message key="cars.vin"/></form:label>
            <div class="col-sm-4">
                <form:input path="vin" cssClass="form-control"/>
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
