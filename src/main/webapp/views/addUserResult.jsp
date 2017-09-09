
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>User Added</title>
    <style>
        div.container {
            width: 50%;
            background-color:rgba(0, 0, 0, 0.7);            color: white;            margin: 8px 8px;
        }
    </style>
</head>
<body>
<div class="container">
    Added User:<br>
    User ID: ${UserId}<br />
    Name: ${FirstName} ${LastName}<br />
    Phone Number: ${CellPhone}<br />
    Email address: ${Email}<br /><br>

<%--Let's user login with the info just entered--%>
    <a href="login"><button class="button">Login</button></a>
</div>
</body>
</html>