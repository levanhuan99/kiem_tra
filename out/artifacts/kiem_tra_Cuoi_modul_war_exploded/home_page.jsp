<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/12/2020
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form method="post" action="/Product?action=search">
    <input name="search" type="number">
    <input type="submit">
</form>

    <a href="/Product?action=add" >add product</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Color</th>
            <th scope="col">Category</th>
            <th scope="col">Description</th>
            <th scope="col">edit</th>
            <th scope="col">delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <th scope="row"><c:out value="${product.getId()}"></c:out></th>
                <th scope="row"><c:out value="${product.getName()}"></c:out></th>
                <th scope="row"><c:out value="${product.getPrice()}"></c:out></th>
                <th scope="row"><c:out value="${product.getAmount()}"></c:out></th>
                <th scope="row"><c:out value="${product.getColor()}"></c:out></th>
                <th scope="row"><c:out value="${product.getCategory()}"></c:out></th>
                <th scope="row"><c:out value="${product.getDescription()}"></c:out></th>
                <td><a href="/Product?action=edit&&idEdit=${product.getId()}">edit</a></td>
                <td><a href="/Product?action=delete&&idDelete=${product.getId()}">delete</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


</body>
</html>
