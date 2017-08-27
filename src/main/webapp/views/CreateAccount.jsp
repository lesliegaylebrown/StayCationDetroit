
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<form action="addUser" method="post">

    Enter your choice for your  User ID. (User ID must be at least 6 to 12 characters long)
    <br>
    ID: <input name="userId" type="text" />
    <br /><br />

    First Name: <input name="fName" type="text" />

    <br />
    Last Name: <input name="lName" type="text" />

    <br />
    Email: <input name="email" type="text" />

    <br />
    Cell Phone: <input name="Cphone" type="text" />

    <br /><br>

    Password: <input name="password" type="password" />

    <br />
    Re-Enter Password: <input name="password2" type="password" />

    <br />
    <input type="submit" value="Add User" />
</form>

<a href="/"><button>Go Back To Home Page</button></a>

</body>
</html>
