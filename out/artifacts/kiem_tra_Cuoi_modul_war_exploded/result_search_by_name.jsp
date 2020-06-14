<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/12/2020
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col"> Product id</th>
        <th scope="col">Product name</th>
        <th scope="col">Product price</th>
        <th scope="col">Product amount</th>
        <th scope="col">Product color</th>
        <th scope="col">Product description</th>
        <th scope="col">Product category</th>
    </tr>
    </thead>
    <c:forEach items="${productSearchByName}" var="product">
        <tr>
            <td><c:out value='${product.getId()}'></c:out></td>
            <td><c:out value='${product.getName()}'></c:out></td>
            <td><c:out value='${product.getPrice()}'></c:out></td>
            <td><c:out value='${product.getAmount()}'></c:out></td>
            <td><c:out value='${product.getColor()}'></c:out></td>
            <td><c:out value='${product.getDescription()}'></c:out></td>
            <td><c:out value='${product.getCategory()}'></c:out></td>
        </tr>
    </c:forEach>


    <a href="/Product"> back to list</a>
</table>
</body>
</html>
