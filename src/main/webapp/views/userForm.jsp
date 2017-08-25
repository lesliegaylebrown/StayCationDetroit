<%--
  Created by IntelliJ IDEA.
  User: peter
  Date: 8/16/17
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<form action="addUser" method="post">
    ID: <input name="userId" type="text" /><br />
   First Name: <input name="fName" type="text" /><br />
    Last Name: <input name="lName" type="text" /><br />
    Email: <input name="email" type="text" /><br />
    Cell Phone: <input name="Cphone" type="text" /><br />
    Password: <input name="password" type="password" /><br />
    Re-Enter Password: <input name="password2" type="password" /><br />
    <input type="submit" value="Add User" />
</form>
</body>
</html>
