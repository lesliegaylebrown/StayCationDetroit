<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
    <th>User ID</th>

        <th>Delete?</th>
    </tr>
    <c:forEach items="${userList}" var="item">
        <tr>
            <td>
                ${item.userId}
            </td>
            <td>
                 ${item.fname}
            </td>

            <td>
                    ${item.userId}
            </td>
            <td>
                    ${item.fname}
            </td>
            <td>
                    ${item.userId}
            </td>
            <td>
                    ${item.fname}
            </td>
            <td>
                <form action="deleteUser" method="post">
                    <input type="hidden" name="userId"
                           value="${item.userId}">
                    <input type="submit" value="Terminate User">
                </form>

            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>