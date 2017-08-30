
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Create Account</title>

</head>
<body>

<%--this form takes user input, to be sent to the addUser mapping in the HomeController, then Dbase--%>
<form action="addUser" method="post">

    Enter User ID. (User ID must be at least 3 to 12 characters long)
    <br>
    ID: <input name="userId" type="text" />
    <br /><br />

    First Name: <input name="fName" type="text" />

    <br />
    Last Name: <input name="lName" type="text" />

    <br />
    Email: <input name="email" type="text" />

    <br />
    Cell Phone: <input name="Cphone" type="text" />

    <br /><br>
    <div>

    Password must be at least 8, but less than 60 characters long. Password must include one of each,<br>a capital letter, a lower case letter, a number, and one of these symbols (! @ # $ ?)<br>
        <input name="password" type="password" />
        <%--<div class="fieldWrapper">--%>
        <%--<label for="password1">Password:</label>--%>
         <%--<input name="password1" id="password1" type="password" />--%>
   <%--</div>--%>
            <%--<div class="fieldWrapper">--%>
        <%--<label for="password2">Confirm Password:</label>--%>
     <%--<input name="password2" id ="password2" onekeyup= "checkPass(); return false;" type="password">--%>
                <%--<span id="confirmMessage" class="confirmMessage"></span>--%>
       <%--</div>         --%>


                <%--<div class="tutorialWrapper">--%>
                    <%--<form>--%>
                        <%--<div class="fieldWrapper">--%>
                            <%--<label for="pass1">Password:</label>--%>
                            <%--<input name="pass1" id="pass1" type="password">--%>
                        <%--</div>--%>
                        <%--<div class="fieldWrapper">--%>
                            <%--<label for="pass2">Confirm Password:</label>--%>
                            <%--<input name="pass2" id="pass2" onkeyup="checkPass(); return false;" type="password">--%>
                            <%--<span id="confirmMessage" class="confirmMessage"></span>--%>
                        <%--</div>--%>
    </div>
    <br />
    <br />
    <input type="submit" value="Add User" />


</form>

<a href="/"><button>Go Back To Home Page</button></a>

</body>
</html>
