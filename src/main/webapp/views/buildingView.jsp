<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><center hidden>
    .container {
    width: 150px;
    height: 100px;
    background-image: url("http://i.stack.imgur.com/2OrtT.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    background-position: 50% 50%;
    }​
</center>
<head>
    <title>Building Selection</title>

</head>
<body>

<table border="1">
    <tr>


        <th>Building Image</th><th>Building Name</th><th>Building Address</th><th>Building Description</th><th>QLine Stops</th><th>Eateries Near By</th>
    </tr>
    <c:forEach items="${buildingList}" var="item">
        <tr>
            <td>
                <div class="container"></div>​


            <img src="${item.buildingImage}" alt="${item.buildingName}"height = 150px width="150" >

            </td>

            <td>
                  ${item.buildingName}
            </td>

            <td>
                  ${item.buildingAddress}
            </td>

            <td>
                  ${item.buildingDescription}
            </td>

            <td>
                    ${item.qLineStops}
            </td>



            <td>
                <form action="restaurant" method="post">


                    <input type="hidden" name="BuildingChoice"
                           value="${item.buildingName}">

                    <%--<input type="hidden" name="BuildingChoice"--%>
                           <%--value="${item.buildingName}"& >--%>
                    <%--<input type="submit" value="Choose">--%>
                    <%--<input type="hidden" name="Long"--%>
                           <%--value="${item.longitude}">--%>
                    <%--<input type="submit" value="Choose">--%>

                    <input type="hidden" name="LatandLon"
                           value="lat=${item.latitude}&lon=${item.longitude}">

                    <input type="submit" value="Choose">
                </form>

            </td>
        </tr>
    </c:forEach>

</table>

<br><br>
<a href="BackWelcome"><button>Welcome Page</button></a><br>
<a href="/"><button>Home Page</button></a>
</body>
</html>