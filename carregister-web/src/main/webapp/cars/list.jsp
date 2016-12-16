<%-- 
    Document   : view
    Created on : 16.12.2016, 11:52:57
    Author     : Henrich
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Cars">
<jsp:attribute name="body">

    <table class="table">
        <caption>Cars</caption>
        <thead>
        <tr>
            <th>Manufacter</th>
            <th>Model</th>
            <th>Year</th>
            <th>Fuel</th>
            <th>Register number</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td><c:out value="${car.manufacturer}"/></td>
                <td><c:out value="${car.model}"/></td>
                <td><c:out value="${car.year}"/></td>
                <td><c:out value="${car.fuel}"/></td>
                <td><c:out value="${car.register_number}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</jsp:attribute>
</my:pagetemplate>
