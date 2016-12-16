<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Users">
<jsp:attribute name="body">
    <my:a href="/users/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        <fmt:message key="users.new"/>
    </my:a>

    <table class="table">
        <caption>Users</caption>
        <thead>
        <tr>
            <th>id</th>
            <th>login</th>
            <th>name</th>
            <th>lastname</th>
            <th>email</th>
            <th>role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.firstname}"/></td>
                <td><c:out value="${user.lastname}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td><my:a href="/users/view/${user.id}"><fmt:message key="general.detail"/></my:a> | 
                    <my:a href="/users/edit/${user.id}" class=""><fmt:message key="general.edit"/></my:a> | 
                    <my:a href="/users/delete/${user.id}" class=""><fmt:message key="general.delete"/></my:a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>