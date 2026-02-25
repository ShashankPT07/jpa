
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h1>Submitted Successfully </h1>

<table border="1">
    <tr>
        <th>food</th>
        <th>rating</th>
        <th>category</th>
        <th>price</th>
        <th>description</th>
    </tr>


    <c:forEach items="${dtos}" var="data">
    <tr>
        <td>${data.food}</td>
        <td>${data.rating}</td>
        <td>${data.category}</td>
        <td>${data.price}</td>
        <td>${data.description}</td>
    </tr>
    </c:forEach>
</table>


</body>
</html>
