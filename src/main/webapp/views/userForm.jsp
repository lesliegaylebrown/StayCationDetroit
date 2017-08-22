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
    <title>Customer Form</title>
</head>
<body>
<form action="addUser" method="post">
    ID: <input name="userId" type="text" maxlength="5" /><br />
   First Name: <input name="fName" type="text" /><br />
    Last Name: <input name="lName" type="text" /><br />
    Email: <input name="email" type="text" /><br />
    Cell Pnone: <input name="Cphone" type="text" /><br />
    Password: <input name="password" type="text" /><br />
    Re-Enter Password: <input name="password2" type="text" /><br />
    <input type="submit" value="Add Customer" />
</form>
</body>
</html>
