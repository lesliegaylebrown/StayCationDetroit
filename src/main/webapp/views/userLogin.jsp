
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>    <style>
    div.container {
        width: 50%;
        background-color:rgba(0, 0, 0, 0.7);
        color: white;
    }
</style>
</head>
<body>
<link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
<div class="container">
<form action="/checklogin" method="post">
    ID: <input name="userId" type="text" /><br />
    Password: <input name="password" type="password" /><br />
    <input type="submit" value="Login" />
</form></div>
</body>
</html>