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
               modelAttribute="carCreate" cssClass="form-horizontal">

        <div class="form-group" >
            <form:label path="manufacturer" cssClass="col-sm-2 control-label"><fmt:message key="cars.manufacturer"/></form:label>
            <div class="col-sm-4">
                <jsp:setProperty name="text" property="text" value="${car.manufacturer}" />
                <form:input type="text" path="manufacturer" id="text" value=""/>
            </div>
        </div>
          
        <div class="form-group" >
            <form:label path="model" cssClass="col-sm-2 control-label"><fmt:message key="cars.model"/></form:label>
            <div class="col-sm-4">
                <jsp:setProperty name="text" property="text" value="${car.manufacturer}" />
                <form:input type="text" path="model" id="text" value=""/>
            </div>
        </div>  
                    
      <div class="form-group">
          <form:label path="carId" cssClass="col-sm-2 control-label"><fmt:message key="general.car"/></form:label>
            <div class="col-sm-4">
                <form:select path="Fuel" cssClass="form-control">
                    <form:option value="GASOLINE">Gasoline</form:option>
                    <form:option value="DIESEL">Diesel</form:option>
                </form:select>
                <p class="help-block"><form:errors path="carId" cssClass="help-block"/></p>
            </div> 
        </div>
           
            <div class="form-group">  
                <div class="col-sm-2"></div>
                <div class="col-sm-4">
                    <button class="btn btn-primary" type="submit"><fmt:message key="intervals.create"/></button>
                </div>
            </div>
 
    </form:form>
</jsp:attribute>
</my:pagetemplate>
