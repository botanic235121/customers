<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h1>
    scriptlet
</h1>
    a: <%= request.getAttribute("a")%>
    b: <%= request.getAttribute("b")%>

name: ${client.firstName}
<%--Name: <%
Clients client = (Clients) request.getAttribute("client");
out.println(client.getFirstName());

%>--%>


</body>
</html>
