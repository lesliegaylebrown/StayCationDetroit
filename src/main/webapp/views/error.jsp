
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>Error Page</title>
    <style>
        div.container {
            width: 50%;
            background-color:rgba(0, 0, 0, 0.7);            color: white;            margin: 8px 8px;
        }
    </style>
</head>
<body><div class= container>
<h1>There was a problem.</h1>
What went wrong: <br />
${errmsg}
<br><br>

<form>
    <input type="button" value="Go back!" onclick="history.back()">
    </input>
</form></div>
<a href="login"><button class="button">Login</button></a>
<a href="CreateAccount"><button class="button"> Register</button></a>
<a href="/"><button class="button">Home Page</button></a>
</body>
</html>