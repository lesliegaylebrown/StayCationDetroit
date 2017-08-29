
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Added</title>
</head>
<body>
    Added User:<br>
    User ID: ${UserId}<br />
    Name: ${FirstName} ${LastName}<br />
    Phone Number: ${CellPhone}<br />
    Email address: ${Email}<br /><br>

<%--Let's user login with the info just entered--%>
    <a href="login"><button>Login</button></a>

</body>
</html>