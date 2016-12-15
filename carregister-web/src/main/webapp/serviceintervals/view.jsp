<%-- 
    Document   : view
    Created on : Dec 15, 2016, 3:44:50 PM
    Author     : robha
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="dateObject" class="java.util.Date" />
<s:message code="intervals.view" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">

         <div class="form-horizontal">
            <div>
                <br />
          <div class="form-group" >
            <form:label path="interval.car" cssClass="col-sm-2 control-label"><fmt:message key="general.car"/></form:label>
            <div class="col-sm-4">
                <form:input path="interval.car" readonly="true" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="interval.beginLong" cssClass="col-sm-2 control-label"><fmt:message key="general.begin"/></form:label>
            <div class="col-sm-4">
                <jsp:setProperty name="dateObject" property="time" value="${interval.beginLong}" />
                <fmt:formatDate value="${dateObject}" type="date" pattern="dd-mm-yyyy" var="theFormattedDate" />
                <form:input type="text" path="interval.beginLong"  readonly="true" value="${theFormattedDate}" cssClass="form-control"/>
            </div>
          </div>
          <div class="form-group" >
            <form:label path="interval.endLong" cssClass="col-sm-2 control-label"><fmt:message key="general.end"/></form:label>
            <div class="col-sm-4">
                <jsp:setProperty name="dateObject" property="time" value="${interval.endLong}" />
                <fmt:formatDate value="${dateObject}" type="date" pattern="dd-mm-yyyy" var="theFormattedDate" />
                <form:input type="text" path="interval.endLong" readonly="true" value="${theFormattedDate}" cssClass="form-control"/>
            </div>
          </div>
         <div class="form-group" >
            <form:label path="interval.visitedLong" cssClass="col-sm-2 control-label"><fmt:message key="general.visited"/></form:label>
            <div class="col-sm-4">
                <jsp:setProperty name="dateObject" property="time" value="${interval.visitedLong}" />
                <fmt:formatDate value="${dateObject}" type="date" pattern="dd-mm-yyyy" var="theFormattedDate" />
                <form:input type="text" readonly="true" path="interval.visitedLong" value="${theFormattedDate}" cssClass="form-control"/>
            </div>
          </div> 
           <div class="form-group" >
            <div class="col-sm-4"></div>
            <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/serviceintervals/delete/${interval.id}">
                    <button type="submit" class="btn btn-danger"><fmt:message key="general.delete"/></button>
                </form>
            </div>
             <div class="col-sm-1">
               <form method="get" action="${pageContext.request.contextPath}/serviceintervals/edit/${interval.id}">
                    <button type="submit" class="btn btn-success"><fmt:message key="general.edit"/></button>
                </form>
            </div>
          </div> 
            

                
                      </div>
        </div>
</jsp:attribute>
</my:pagetemplate>