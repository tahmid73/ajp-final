<%--
  Created by IntelliJ IDEA.
  User: Tahmid
  Date: 4/25/2022
  Time: 1:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Status</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Status</h2>
    </div>
</div>

<div id="container">
    <h3>Status view</h3>
    <%--@elvariable id="user" type=""--%>
    <form:form action="create" modelAttribute="status" method="POST">
        <table>
            <tbody>
            <tr>
                <td><label>Status:</label></td>
                <td><form:input path="status"/></td>
            </tr>
<%--            <tr>--%>
<%--                <td><label>Last name:</label></td>--%>
<%--                <td><form:input path="email"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><label>Password:</label></td>--%>
<%--                <td><form:input path="password"/></td>--%>
<%--            </tr>--%>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;"></div>

    <p>
        <a href="${pageContext.request.contextPath}/status/list">Back to List</a>
    </p>

</div>
</body>
</html>
