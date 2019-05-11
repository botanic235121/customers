<!DOCTYPE html>
<html>
<head>
    <title>Add order</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../resources/addition_updating_form.css">
</head>
<body>

<div class="form-container">

    <form action="orders?option=addOrder" method="post">
        <h3>Add new order for <span>${client.firstName} ${client.lastName}</span></h3>

        <input type="hidden" name="id" value="${client.id}">

        <input type="text" name="orderName" placeholder="Order name*" required>
        <br>
        <button type="submit" class="btnSubmit">Add</button>

    </form>

    <a href="orders?option=showOrder&id_client=${client.id}">View orders list for ${client.firstName} ${client.lastName}</a>
</div>
</body>
</html>