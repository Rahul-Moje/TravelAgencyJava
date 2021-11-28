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
<table border="1" cellpadding="5" style="width:100%">
    <caption><h2>ProMemberShipDetails</h2></caption>
    <tr>
        <th>Flight Code</th>
        <th>Airline</th>
        <th>Source</th>
        <th>Destination</th>
        <th>Departure</th>
        <th>Arrival</th>
        <th>TotalHours</th>
        <th>TicketPrice</th>
        <th></th>
    </tr>

    <c:forEach items="${flights}" var="flight">
        <tr>
            <td><c:out value="${flight.flightCode}" /></td>
            <td><c:out value="${flight.airLine}" /></td>
            <td><c:out value="${flight.source}" /></td>
            <td><c:out value="${flight.destination}" /></td>
            <td><c:out value="${flight.departureTime}" /></td>
            <td><c:out value="${flight.arrivalTime}" /></td>
            <td><c:out value="${flight.totalHours}" /></td>
            <td><c:out value="${flight.ticketPrice}" /></td>
            <td>
                <form action="bookFlights" method="post">
                <input type="hidden" id="flightScheduleId" name="flightScheduleId" value="${flight.flightScheduleId}">
                <input type="submit" value="Book"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/searchFlights">Back to Search Flights</a>
</body>
</html>