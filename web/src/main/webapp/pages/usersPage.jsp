<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<h2>This page is for displaying users</h2>

<h3>List of users:</h3>

<p>
    <table border="1">
        <tr>
            <th>Email</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Phone number</th>
            <th>Password</th>
        </tr>

        <c:forEach var="num" items="${users}">
            <tr>
                <td>${num.getEmail()}</td>
                <td>${num.getFirstName()}</td>
                <td>${num.getLastName()}</td>
                <td>${num.getPhoneNumber()}</td>
                <td>${num.getPassword()}</td>
            </tr>
        </c:forEach>
    </table>
</p>

<form method="post" action="/web/users" >
    <table>
        <tr>
            <td> Email </td>
            <td> <input type="text" name="email"/> </td>
        </tr>
        <tr>
            <td> FirstName </td>
            <td> <input type="text" name="firstName"/> </td>
        </tr>
        <tr>
            <td> LastName </td>
            <td> <input type="text" name="lastName"/> </td>
        </tr>
        <tr>
            <td> Phone number </td>
            <td><input type="text" name="phoneNumber"/> </td>
        </tr>
        <tr>
            <td> Password </td>
            <td><input type="text" name="password"/> </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="addButton" value="Add" />
            </td>
        </tr>
    </table>
</form>

<form method="post" action="/web/users" >
    <table>
        <tr>
            <td> Email </td>
            <td> <input type="text" name="email"/> </td>
        </tr>
        <tr>
            <td> FirstName </td>
            <td> <input type="text" name="firstName"/> </td>
        </tr>
        <tr>
            <td> LastName </td>
            <td> <input type="text" name="lastName"/> </td>
        </tr>
        <tr>
            <td> Phone number </td>
            <td><input type="text" name="phoneNumber"/> </td>
        </tr>
        <tr>
            <td> Password </td>
            <td><input type="text" name="password"/> </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="updateButton" value="Update" />
            </td>
        </tr>
    </table>
</form>

<form method="post" action="/web/users">
    <table>
        <tr>
            <td> Email </td>
            <td> <input type="text" name="email"/> </td>
        </tr>

        <tr>
            <td>
                <input type="submit" name="deleteButton" value="Delete"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
