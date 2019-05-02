<!DOCTYPE html>
<html>
<head>
    <title>Add client</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/addition_updating_form.css">
</head>
<body>

<div class="form-container">
    <form action="information?action=addAction" method="post">
        <h3>Add new client</h3>

        <input id="fname" type="text" name="firstName" placeholder="First name*" required>
        <br>
        <input id="lname" type="text" name="lastName" placeholder="Last name*" required>
        <br>

        <button type="submit" class="btnSubmit">Add</button>
    </form>
    <a href="information?action=listClients">View clients list</a>
</div>


</body>
</html>