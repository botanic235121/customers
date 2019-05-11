<!DOCTYPE html>
<html>
<head>
    <title>Update order</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/addition_updating_form.css">
</head>
<body>
<div class="form-container">
    <h3>Update order: <span>${order.name}</span></h3>

    <form action="orders?option=updateOrder" method="post">

        <input type="hidden" name="id_order" value="${order.id}">

        <input type="text" name="name_order" placeholder="Write here new order*" required>
        <br>

        <button type="submit" class="btnSubmit">Update</button>

    </form>
    <a href="orders?option=showOrder&id_client=${client.id}">View orders list for ${client.firstName} ${client.lastName}</a>
</div>
</body>
</html>