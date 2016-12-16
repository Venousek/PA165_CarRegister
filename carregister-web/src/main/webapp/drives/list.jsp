<%-- 
    Document   : lsit
    Created on : Dec 15, 2016, 5:30:35 PM
    Author     : cernak
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="dateObject" class="java.util.Date" />

<s:message code="general.drives" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <my:a href="/drives/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        <fmt:message key="drives.new"/>
    </my:a>
    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="general.id"/></th>
            <th><fmt:message key="general.user"/></th>
            <th><fmt:message key="general.car"/></th>
            <th><fmt:message key="general.begin"/></th>
            <th><fmt:message key="general.end"/></th>
            <th><fmt:message key="general.distance"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${drives}" var="drive">
            <tr>
                <td>${drive.id}</td>
                <td><c:out value="${drive.user}"/></td>
                <td><c:out value="${drive.car}"/></td>
                <td><fmt:formatDate value="${drive.beginDate}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${drive.endDate}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${drive.distance}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>
