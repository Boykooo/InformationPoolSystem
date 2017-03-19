<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>This page is for displaying pools</h2>

<h3>List of pools:</h3>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Area</th>
        <th>Depth</th>
        <th>Type</th>
    </tr>

    <c:forEach var="pool" items="${pools}">
        <tr>
            <td>${pool.getPoolId()}</td>
            <td>${pool.getPoolArea()}</td>
            <td>${pool.getPoolDepth()}</td>
            <%--TODO: ДОБАВИТЬ ТИП--%>
            <td></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
