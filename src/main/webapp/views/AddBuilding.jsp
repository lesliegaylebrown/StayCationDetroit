<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/StyleOne.css">
    <title>Create Account</title>

</head>
<body>

<%--this form takes user input, to be sent to the addUser mapping in the HomeController, then Dbase--%>
<form action="AddBuilding" method="post">

    buildingId, buildingName, buildingAddress, buildingDescription, buildingImage, qlineStops, longitude, latitude

    <br>
    Building ID: <input name="buildingId" type="text"/>
    <br/><br/>

    Building Name: <input name="buildingName" type="text"/>

    <br/>
    Building Address: <input name="buildingAddress" type="text"/>

    <br/>
    Building Description: <input name="buildingDescription" type="text"/>

    <br/>
    Building Image: <input name="buildingImage" type="text"/>

    <br/><br>

    <br>
    QLine Stops <input name="qlineStops" type="text"/>

    <br>
    Longitude <input name="longitude" type="text"/>

    <br>
    Latitude <input name="latitude" type="text"/>

    <br/>
    <br/>

    <input type="submit" value="Add Building"/>




</form>

<a href="/">
    <button class="button" >Go Back To Home Page</button>
</a>

</body>
</html>
