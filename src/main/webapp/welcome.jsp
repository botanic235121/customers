<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Домашняя страница Customers</title>
</head>
<body>
<form method="get">
    <h2>Введите id заказчика</h2>
    <input type="text" name="id_client">
    <input type="submit" name="submit_clients">
    <h1>${client}</h1>

</form>
</body>
</html>