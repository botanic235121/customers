<%@ page import="com.sinitcyn.demo.entity.Clients" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Домашняя страница Customers</title>
</head>
<body>
<%--<a href="information.jsp">
    sub
</a>--%>
<form method="get">
    <h2>Введите id заказчика</h2>
    <input type="text" name="id_client">
    <input type="submit" name="submit_clients" value="submit">
    <h1>
        scriptlet
    </h1>
    a: <%= request.getAttribute("a")%><br>
    b: <%= request.getAttribute("b")%><br>

    name: ${client.firstName}<br>
    surname: ${client.lastName}<br>

</form>
</body>
</html>