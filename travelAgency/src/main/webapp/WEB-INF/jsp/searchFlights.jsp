<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>
<span style="color: red; ">${errorMessage}</span>
<form action="searchFlights" method="post">
    Select Source
    <select name="sources" id="sourceId">
        <c:forEach items="${sources}" var="source">
            <option value="${source}">${source}</option>
        </c:forEach>
    </select>
    <br>
    Select Destination
    <select name="destinations" id="destinationId">
        <c:forEach items="${destinations}" var="destination">
            <option value="${destination}">${destination}</option>
        </c:forEach>
    </select>
    <br>
    Select From Date
    <input type="date" id="fromDate" name="fromDate"
           value="2021-11-01"
           min="2021-11-01" max="2023-12-31">
    <br>
    <div id="toDateDiv">
    Select To Date
    <input type="date" id="toDate" name="toDate"
           value="2021-11-01"
           min="2021-11-01" max="2023-12-31">
    <br>
    </div>
    One Way or a Return Flight ?
    <select name="oneWayOrReturn" id="oneWayOrReturn" onchange="myFunction()">
        <option value="OneWay">One Way</option>
        <option value="Return" selected>Return</option>
    </select>
    <br>
    Enter number of passengers
    <input type="text" name="numPassengers" id="numPassengers">
    <input type="submit" />



</form>
<script>
    function myFunction() {
        if(document.getElementById("oneWayOrReturn").value == "Return") {
            document.getElementById("toDateDiv").style.display = "block"
        } else {
            document.getElementById("toDateDiv").style.display = "none"
        }
    }
</script>
</body>
</html>