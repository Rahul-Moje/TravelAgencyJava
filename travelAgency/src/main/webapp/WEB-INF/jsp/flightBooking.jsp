<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Flight Booking</title>
</head>
<body>
<form action="bookFlight" method="post">
    Select number of baggages
    <input type="text" name="numBaggages" id="numBaggages"/>
    <br>
    Select meal type
    <select name="mealType" id="mealType">
        <option value="Vegetarian">Vegetarian</option>
        <option value="Non Vegetarian">Non Vegetarian</option>
    </select>
    <input type="submit"/>
</form>
<br>
<a href="/searchFlights">Back to Search Flights</a>
</body>
</html>