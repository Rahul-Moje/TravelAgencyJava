<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Search Results</title>
</head>
<body>
<table border="1" cellpadding="5" style="width:100%">
    <caption><h2>Search Results</h2></caption>
    <tr>
        <th>Departing Flight Code</th>
        <th>Departing Airline</th>
        <th>Departing Source</th>
        <th>Departing Destination</th>
        <th>Departing Departure</th>
        <th>Departing Arrival</th>
        <th>Departing TotalHours</th>
        <th>Arriving Flight Code</th>
        <th>Arriving Airline</th>
        <th>Arriving Source</th>
        <th>Arriving Destination</th>
        <th>Arriving Departure</th>
        <th>Arriving Arrival</th>
        <th>Arriving TotalHours</th>
        <th>Total Ticket Price</th>
        <th></th>
    </tr>

    <c:forEach items="${flights}" var="flight">
        <tr>
            <td><c:out value="${flight.fromFlightCode}" /></td>
            <td><c:out value="${flight.fromAirLine}" /></td>
            <td><c:out value="${flight.fromSource}" /></td>
            <td><c:out value="${flight.fromDestination}" /></td>
            <td><c:out value="${flight.fromDepartureTime}" /></td>
            <td><c:out value="${flight.fromArrivalTime}" /></td>
            <td><c:out value="${flight.fromTotalHours}" /></td>
            <td><c:out value="${flight.toFlightCode}" /></td>
            <td><c:out value="${flight.toAirLine}" /></td>
            <td><c:out value="${flight.toSource}" /></td>
            <td><c:out value="${flight.toDestination}" /></td>
            <td><c:out value="${flight.toDepartureTime}" /></td>
            <td><c:out value="${flight.toArrivalTime}" /></td>
            <td><c:out value="${flight.toTotalHours}" /></td>
            <td><c:out value="${flight.totalTicketPrice}" /></td>
            <td>
                <form action="bookFlight" method="get">
                    <input type="hidden" id="fromFlightScheduleId" name="fromFlightScheduleId" value="${flight.fromFlightScheduleId}">
                    <input type="hidden" id="toFlightScheduleId" name="toFlightScheduleId" value="${flight.toFlightScheduleId}">
                    <input type="hidden" id="flightCost" name="flightCost" value="${flight.totalTicketPrice}">
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