<%-- 
    Document   : view
    Created on : Dec 15, 2016, 6:25:02 PM
    Author     : ferko
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="dateObject" class="java.util.Date" />
<s:message code="drives.view" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

         <div class="form-horizontal">
            <div>
                <br />
          <div class="form-group" >
            <form:label path="drive.user" cssClass="col-sm-2 control-label"><fmt:message key="general.user"/></form:label>
            <div class="col-sm-4">
                <form:input path="drive.user" readonly="true" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="drive.car" cssClass="col-sm-2 control-label"><fmt:message key="general.car"/></form:label>
            <div class="col-sm-4">
                <form:input path="drive.car" readonly="true" cssClass="form-control"/>
            </div>
          </div>  
          <div class="form-group" >
            <form:label path="drive.beginDate" cssClass="col-sm-2 control-label"><fmt:message key="general.begin"/></form:label>
            <div class="col-sm-4">
                <fmt:formatDate value="${drive.beginDate}" type="date" pattern="dd/MM/yyyy" var="theFormattedDate" />
                <form:input type="text" path="drive.beginDate"  readonly="true" value="${theFormattedDate}" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="drive.endDate" cssClass="col-sm-2 control-label"><fmt:message key="general.end"/></form:label>
            <div class="col-sm-4">
                <fmt:formatDate value="${drive.endDate}" type="date" pattern="dd/MM/yyyy" var="theFormattedDate" />
                <form:input type="text" path="drive.endDate" readonly="true" value="${theFormattedDate}" cssClass="form-control"/>
            </div>
          </div>
         <div class="form-group" >
            <form:label path="drive.distance" cssClass="col-sm-2 control-label"><fmt:message key="general.distance"/></form:label>
            <div class="col-sm-4">
                <form:input path="drive.distance" readonly="true" cssClass="form-control"/>
            </div>
          </div>
           <div class="form-group" >
            <div class="col-sm-4"></div>
            <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/drives/delete/${drive.id}">
                    <button type="submit" class="btn btn-danger"><fmt:message key="general.delete"/></button>
                </form>
            </div>
             <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/drives/edit/${drive.id}">
                    <button type="submit" class="btn btn-success"><fmt:message key="general.edit"/></button>
                </form>
            </div>
          </div> 
            

                
                      </div>
        </div>
</jsp:attribute>
</my:pagetemplate>
