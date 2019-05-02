<!DOCTYPE html>
<html lang="en">
<head>
    <title>List clients</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/list_Clients_form.css">
    <link rel="shortcut icon" href="assets/customer.ico">
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Client Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th colspan="2" class="action">Action</th>
    </tr>
    </thead>
    <tbody>
    <#list clients as client>
    <tr>
        <td>${client.id}</td>
        <td>${client.firstName}</td>
        <td>${client.lastName}</td>
        <td><a href="information?action=updateAction&id_client=${client.id}">Update</a></td>
        <td><a href="information?action=deleteAction&id_client=${client.id}">Delete</a></td>
    </tr>
    </#list>
    </tbody>
</table>
<a href="information?action=addAction" id="add_link">Add new client</a>
</body>
</html>