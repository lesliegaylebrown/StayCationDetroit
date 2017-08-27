<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Building Selection</title>
</head>
<body>

<table border="1">
    <tr>
    <th>Building Name</th>

        <th>???</th>
    </tr>
    <c:forEach items="${buildingList}" var="item">
        <tr>
            <td>
                  ${item.buildingImage}
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
                <form action="delUserView" method="post">
                    <input type="hidden" name="userId"
                           value="${item.buildingName}">
                    <input type="submit" value="Delete User">
                </form>

            </td>
        </tr>
    </c:forEach>

</table>
<br><br>
<a href="/"><button>Home Page</button></a>
</body>
</html>