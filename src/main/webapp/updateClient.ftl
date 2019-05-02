<!DOCTYPE html>
<html>
<head>
    <title>Update client</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/addition_updating_form.css">
</head>
<body>
<div class="form-container">
    <h3>Update client</h3>

    <form action="information?action=updateAction" method="post">

        <input type="hidden" name="id" value="${client.id}">

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" value="${client.firstName}" required>
        <br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" value="${client.lastName}" required>
        <br>

        <button type="submit" class="btnSubmit">Update</button>

    </form>
    <a href="information?action=listClients">View clients list</a>
</div>
</body>
</html>