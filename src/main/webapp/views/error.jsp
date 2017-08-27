
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h1>There was a problem.</h1>
What went wrong: <br />
${errmsg}
<br><br>

<a href="login"><button>Login</button></a>
<a href="CreateAccount"><button> Register</button></a>
<a href="/"><button>Home Page</button></a>
</body>
</html>
