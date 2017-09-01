<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged In</title>
   <link rel="stylesheet" href="resources/StyleOne.css">
   <style>
      div.container {
         width: 50%;
         background-color:rgba(0, 0, 0, 0.7);
         color: white;
      }
   </style>
</head>
<body>
<div class="container">
   <h3>Welcome Back! Please make your selection below.</h3>
<br/>
<br/>
</div>   <%--Buttons for links to registration and login--%>
   <a href="/getAllBuildings"><button class="button">Buildings</button></a>
   <a href="AdminRegistration"><button class="button">Admin Creation</button></a>
   <a href="AdminLogin"><button class="button">Admin Login</button></a>
   <%--<a href="/getAllUsers"><button class="button">View/Delete Users</button></a>--%>

</body>
</html>
