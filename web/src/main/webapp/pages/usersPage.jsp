
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h2>This page is for displaying users</h2>

<h3>List of users:</h3>

<table border="1">
    <tr>
        <th>Email</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
    </tr>

    <c:forEach var="num" items="${users}">
        <tr>
            <td>${num.getEmail()}</td>
            <td>${num.getFirstName()}</td>
            <td>${num.getLastName()}</td>
            <td>${num.getPhoneNumber()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
