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
    <tr>
        <td><c:out value='${requestScope["productSearch"].getId()}'></c:out></td>
        <td><c:out value='${requestScope["productSearch"].getName()}'></c:out></td>
        <td><c:out value='${requestScope["productSearch"].getPrice()}'></c:out></td>
        <td><c:out value='${requestScope["productSearch"].getAmount()}'></c:out></td>
        <td><c:out value='${requestScope["productSearch"].getColor()}'></c:out></td>
        <td><c:out value='${requestScope["productSearch"].getDescription()}'></c:out></td>
        <td><c:out value='${requestScope["productSearch"].getCategory()}'></c:out></td>
    </tr>
    

</table>
</body>
</html>
