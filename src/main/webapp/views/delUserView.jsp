<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>Delete User</title>
</head>
<body>

<table border="1">
    <tr>
    <th>User ID</th>

        <th>Delete?</th>
    </tr>
    <c:forEach items="${uList}" var="item">
        <tr>
            <td>
                ${item.userId}
            </td>
            <td>
                 ${item.fName}
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
<a href="/"><button class="button">Home Page</button></a>
</body>
</html>