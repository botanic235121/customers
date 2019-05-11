<!DOCTYPE html>
<html lang="en">
<head>
    <title>List orders</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/list_Clients_form.css">
    <link rel="shortcut icon" href="../assets/favicon.ico">
</head>
<body>

<table>
    <h3>Orders for <span>${client.firstName} ${client.lastName} </span></h3>
    <thead>
    <tr>
        <th>Order Id</th>
        <th>Name</th>
        <th colspan="2">Option</th>
    </tr>
    </thead>
    <tbody>
    <#list orders as order>
        <tr>
            <td>${order.id}</td>
            <td>${order.name}</td>
            <td><a href="orders?option=updateOrder&id_order=${order.id}&id_client=${client.id}">Update order</a></td>
            <td><a href="orders?option=deleteOrder&id_order=${order.id}&id_client=${client.id}">Delete order</a></td>
        </tr>
    </#list>
    </tbody>
</table>
<a href="orders?option=addOrder&id_client=${client.id}" id="add_link">Add new order</a>
<a href="information?action=listClients" id="add_link">List all clients</a>
</body>
</html>