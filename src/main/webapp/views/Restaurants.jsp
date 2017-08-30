
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Eateries</title>
</head>
<body>


Restaurants near your selection.


<br><br>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Location</th>
        <th>Cuisine</th>
        <th>Avg Cost For Two</th>
        <th>Web Link</th>

    </tr>
    <c:forEach items = "${rList}" var="restaurant">
        <tr>

            <td>
                    ${restaurant.restName}
            </td>
            <td>
                    ${restaurant.restLoc}
            </td>
            <td>
                    ${restaurant.restCuisines}
            </td>
            <td>
                    ${restaurant.restAvgCost}
            </td>
            <td>

                <a href="${restaurant.restUrl}"target="_blank">View Website</a>

            </td>
        </tr>
    </c:forEach>

</table>
<br><br><br>
<a href="/getAllBuildings"><button>Select another building</button></a><br>
<a href="BackWelcome"><button>Welcome Page</button></a><br>
<a href="/"><button>Home Page</button></a>
</body>
</html>
