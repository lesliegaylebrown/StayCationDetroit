<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Building Selection</title>
</head>
<body>

<table border="1">
    <tr>
    <th>Building Image</th>

        <th>Building Name</th><th>Building Address</th><th>Building Description</th><th>Select</th>
    </tr>
    <c:forEach items="${buildingList}" var="item">
        <tr>
            <td>

            <img src="resources/buildings/${item.buildingImage}" alt="${item.buildingName}"height = 150px >

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
                <form action="restaurant" method="post">
                    <input type="hidden" name="BuildingChoice"
                           value="${item.buildingName}">
                    <input type="submit" value="Choose">
                </form>

            </td>
        </tr>
    </c:forEach>

</table>
<br><br>
<a href="/"><button>Home Page</button></a>
</body>
</html>