
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>

<link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
<form action="/checkAdminlogin" method="post">
    ID: <input name="userId" type="text" /><br />
    Password: <input name="password" type="password" /><br />
    <input type="submit" value="Login as Admin" />
</form>
</body>
</html>