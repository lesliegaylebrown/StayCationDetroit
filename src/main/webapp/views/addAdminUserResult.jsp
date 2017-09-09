
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>Admin User Added</title>
</head>
<body>
    Added User:<br>
    User ID: ${UserId}<br />
    Name: ${FirstName} ${LastName}<br />
    Phone Number: ${CellPhone}<br />
    Email address: ${Email}<br /><br>

<%--Let's user login with the info just entered--%>
    <a href="Adminlogin"><button class="button">Login</button></a>

</body>
</html>