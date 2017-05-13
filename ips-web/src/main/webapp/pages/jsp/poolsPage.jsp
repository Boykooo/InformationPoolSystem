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
        <th>Name</th>
        <th>Length</th>
        <th>Width</th>
        <th>Depth</th>
        <th>Type</th>
        <th>isWorking</th>
    </tr>

    <c:forEach var="poolName" items="${pools}">
        <tr>
            <td>${poolName.getId()}</td>
            <td>${poolName.getName()}</td>
            <td>${poolName.getLength()}</td>
            <td>${poolName.getWidth()}</td>
            <td>${poolName.getDepth()}</td>
            <td>${poolName.getType()}</td>
            <td>${poolName.getIsWorking()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
