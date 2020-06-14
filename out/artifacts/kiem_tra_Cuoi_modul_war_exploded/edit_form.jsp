<%--
  Created by IntelliJ IDEA.
  User: VanHuan
  Date: 6/12/2020
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/Product?action=update">
    <table>
        <tr>
            <td>name</td>
            <td><input name="name" value="${requestScope["productEdit"].getName()}"></td>
        </tr>
        <tr>
            <td>price</td>
            <td><input type="number" name="price" value="${requestScope["productEdit"].getPrice()}"></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="number" name="quantity" value="${requestScope["productEdit"].getAmount()}"></td>
        </tr>
        <tr>
            <td>color</td>
            <td><input name="color" value="${requestScope["productEdit"].getColor()}"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input name="description" value="${requestScope["productEdit"].getDescription()}"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input name="category" value="${requestScope["productEdit"].getCategory()}"></td>
        </tr>

    </table>
    <input type="submit" value="Save">
</form>

</body>
</html>
