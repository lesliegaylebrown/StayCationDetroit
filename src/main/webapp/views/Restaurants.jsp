
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>Eateries</title>
    <style>
        div.container {
            width: 50%;
            background-color:rgba(0, 0, 0, 0.7);            color: white;            margin: 8px 8px;
            margin: 8px 8px;
        }
    </style>
</head>
<body>
<img src="resources/buildings/StayCationLogo.png" height="100px>">

<br><br><br><br><br><br>

<div class="container">
    <h2>Restaurants near your selection.</h2>


<br><br>


    <%--<tr>--%>
        <%--<th>Name</th>--%>
        <%--<th>Location</th>--%>
        <%--<th>Cuisine</th>--%>
        <%--<th>Avg Cost For Two</th>--%>
        <%--<th>Web Link</th>--%>

    <%--</tr>--%>
    <c:forEach items = "${rList}" var="restaurant">
<div class=" container">
                <h2>   Name: ${restaurant.restName}  <br> Location: ${restaurant.restLoc}<br>  Cuisine: ${restaurant.restCuisines}<br>  Average: ${restaurant.restAvgCost}<br>
    </h2>




</div>
       <div> <a href="${restaurant.restUrl}"target="_blank" ><h3>View Website</h3>
</div></c:forEach>


</div>
<br><br><br>
<a href="/getAllBuildings"><button class="button">Select another building</button></a><br>
<a href="BackWelcome"><button class="button">Welcome Page</button></a><br>
<a href="/"><button class="button">Home Page</button></a>
</body>
</html>
