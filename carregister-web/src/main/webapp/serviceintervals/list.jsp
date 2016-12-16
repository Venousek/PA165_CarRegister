<%-- 
    Document   : list
    Created on : Dec 14, 2016, 2:14:04 PM
    Author     : robha
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="dateObject" class="java.util.Date" />

<s:message code="general.intervals" var="title"/>
<my:pagetemplate title="${title}">
<jsp:attribute name="body">
    <my:a href="/serviceintervals/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        <fmt:message key="intervals.new"/>
    </my:a>
    <table class="table">
        <thead>
        <tr>
            <th><fmt:message key="general.id"/></th>
            <th><fmt:message key="general.car"/></th>
            <th><fmt:message key="general.begin"/></th>
            <th><fmt:message key="general.end"/></th>
            <th><fmt:message key="general.visited"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${intervals}" var="interval">
            <tr>
                <td>${interval.id}</td>
                <td><c:out value="${interval.car}"/></td>
                <td><fmt:formatDate value="${interval.beginDate}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${interval.endDate}" pattern="dd/MM/yyyy"/></td>
                <td><fmt:formatDate value="${interval.visitedDate}" pattern="dd/MM/yyyy"/></td>
                <td><my:a href="/serviceintervals/view/${interval.id}"><fmt:message key="general.detail"/></my:a> | 
                    <my:a href="/serviceintervals/edit/${interval.id}" class=""><fmt:message key="general.edit"/></my:a> | 
                    <my:a href="/serviceintervals/delete/${interval.id}" class=""><fmt:message key="general.delete"/></my:a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>