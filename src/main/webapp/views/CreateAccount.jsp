
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>Create Account</title>
    <style>
        div.container {
            width: 50%;
            background-color:rgba(0, 0, 0, 0.7);            color: white;            margin: 8px 8px;
        }
    </style>
</head>
<body>
<div class="container">
<%--this form takes user input, to be sent to the addUser mapping in the HomeController, then Dbase--%>
<form action="addUser" method="post">

    Enter User ID. (User ID must be at least 3 to 12 characters long)
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
    <div>

    Password must be at least 8, but less than 60 characters long. Password must include one of each,<br>a capital letter, a lower case letter, a number, and one of these symbols (! @ # $ ?)<br>
        <input name="password" type="password" /><br>
    Please re-enter password.<br>
        <input name="password2" type="password" />

    </div>
    <br />
    <br />

    <input type="submit" value="Create Account" />Create Account

</form>
</div>
<a href="/"><button class="button">Go Back To Home Page</button></a>

</body>
</html>
