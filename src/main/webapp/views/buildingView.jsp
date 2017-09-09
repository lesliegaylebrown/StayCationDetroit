<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>Building Selection</title>
    <style>
        div.container {
            width: 50%;
            background-color:rgba(0, 0, 0, 0.7);            color: white;            margin: 8px 8px;
        }
    </style>


</head>
<body>
<img src="resources/buildings/StayCationLogo.png" height="100px>"

<br><br><br><br><br><br>

    <%--<tr>--%>


        <%--<th>Building Image</th><th>Building Name</th><th>Building Address</th><th>Building Description</th><th>QLine Stops</th><th>Eateries Near By</th>--%>
    <%--</tr>--%>
<center><div>
    <c:forEach items="${buildingList}" var="item">
        <%--<tr>--%>
            <%--<td>--%>

        <div class="container">
            <h1>${item.buildingName}  ${item.buildingAddress}</h1>


        </div>
<div class="container">

    <img src="${item.buildingImage}" alt="${item.buildingName}"height = 500px width="500" ><h3>${item.buildingDescription}</h3>
        </div>

            <div
                    class="container">


                      </div>

            <div class="container" >


            </div>

            <div class="container">
                   <h2> QLine Stop: ${item.qLineStops}</h2>
            </div>




                <form action="restaurant" method="post">


                    <input type="hidden" name="BuildingChoice"
                           value="${item.buildingName}">



                    <input type="hidden" name="LatandLon"
                           value="lat=${item.latitude}&lon=${item.longitude}">

                    <button class="button" type="submit" value="Choose"/>Select ${item.buildingName} </button>
                </form><br><br>


    </c:forEach>
</div></center>


<br><br>
<a href="BackWelcome"><button class="button">Welcome Page</button></a><br>
<a href="/"><button class="button">Home Page</button></a>
</body>
</html>