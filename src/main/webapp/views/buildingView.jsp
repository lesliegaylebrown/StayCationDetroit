<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Delete User</title>
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
                  ${item.buildingName}
            </td>

            <td>
                  ${item.buildingAddress}
            </td>

            <td>
                  ${item.buildingDescription}
            </td>

            <td>
                  ${item.buildingImage}
            </td>

            <td>
                <form action="deleteUser" method="post">
                    <input type="hidden" name="userId"
                           value="${item.userId}">
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