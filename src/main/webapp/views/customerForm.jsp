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
<form action="addCustomer" method="post">
    ID: <input name="CustomerID" type="text" maxlength="5" /><br />
   Comp Name: <input name="CompanyName" type="text" /><br />
    Contact Name: <input name="ContactName" type="text" /><br />
    Contact Title: <input name="ContactTitle" type="text" /><br />
    <input type="submit" value="Add Customer" />
</form>
</body>
</html>
