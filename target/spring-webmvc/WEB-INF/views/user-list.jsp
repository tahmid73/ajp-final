<%--
  Created by IntelliJ IDEA.
  User: kawsu
  Date: 11/29/2021
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.util.SortUtils" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>User List</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>User List</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <input type="button" value="Add User"
               onclick="window.location.href='user-create-form'; return false;"
               class="add-button">

        <br><br>

        <form:form action="search" method="GET">
            Search user by firstname: <input type="text" name="searchValue" />
            <input type="submit" value="Search" class="add-button" />
        </form:form>

        <c:url var="sortLinkFirstName" value="/user/list">
            <c:param name="sortKey" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
        </c:url>

        <c:url var="sortLinkLastName" value="/user/list">
            <c:param name="sortKey" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
        </c:url>

        <table>
            <tr>
                <th><a href="${sortLinkFirstName}">First Name</a></th>
                <th><a href="${sortLinkLastName}">Last Name</a></th>
                <th>Action</th>
            </tr>

            <c:forEach var="user" items="${users}">

                <c:url var="updateLink" value="/user/user-update-form">
                    <c:param name="userId" value="${user.id}" />
                </c:url>

                <c:url var="deleteLink" value="/user/delete">
                    <c:param name="userId" value="${user.id}" />
                </c:url>

                <tr>
                    <td> ${user.firstName} </td>
                    <td> ${user.lastName} </td>
                    <td>
                        <a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>

</body>
</html>
