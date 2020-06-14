<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/12/2020
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/Product?action=add">
    <table>
        <tr>
            <td>name</td>
            <td><input name="name" type="text" ></td>
        </tr>
        <tr>
            <td>price</td>
            <td><input type="number" name="price" ></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="number" name="quantity" ></td>
        </tr>
        <tr>
            <td>color</td>
            <td><input name="color" v></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input name="description"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input name="category" ></td>
        </tr>
        <tr><td><input type="submit"></tr>
    </table>

<form>
</body>
</html>
