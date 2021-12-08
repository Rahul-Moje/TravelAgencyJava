<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Profile</title>
</head>
<body>
<a href="/searchFlights">Back to Search Flights</a>
<br>
<table border="1" cellpadding="5" style="width:100%">
    <caption><h2>User Profile</h2></caption>
    <tr>
        <th>User Name</th>
        <th>User Email</th>
        <th>Is Pro Member</th>
        <th>Pro Member Plan Name</th>
        <th>Pro Member Plan Subscription Date</th>
    </tr>
    <tr>
        <td><c:out value="${user.userName}" /></td>
        <td><c:out value="${user.userEmail}" /></td>
        <td>
            <c:choose>
                <c:when test="${user.proMember==true}">Yes</c:when>
                <c:otherwise>No</c:otherwise>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${user.proMember==true}">${user.planName}</c:when>
                <c:otherwise>-</c:otherwise>
            </c:choose>
        </td>
        <td>
            <c:choose>
                <c:when test="${user.proMember==true}">${user.dateOfPurchase}</c:when>
                <c:otherwise>-</c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>
<br>
<br>
<table border="1" cellpadding="5" style="width:100%">
    <caption><h2>User Bookings</h2></caption>
    <tr>
        <th>Booking Id</th>
        <th>Booking Date</th>
        <th>Booking Status</th>
        <th>Source</th>
        <th>Destination</th>
        <th>Journey Type</th>
        <th>From Airline Code</th>
        <th>From Departure Date</th>
        <th>To Airline Code</th>
        <th>To Departure Date</th>
        <th>Final Cost</th>
        <th></th>
    </tr>
    <c:forEach items="${userBookings}" var="userBooking">
        <tr>
            <td><c:out value="${userBooking.bookingId}" /></td>
            <td><c:out value="${userBooking.bookingDate}" /></td>
            <td><c:out value="${userBooking.userBookingStatus}" /></td>
            <td><c:out value="${userBooking.source}" /></td>
            <td><c:out value="${userBooking.destination}" /></td>
            <td><c:out value="${userBooking.journeyType}" /></td>
            <td><c:out value="${userBooking.fromFlightCode}" /></td>
            <td><c:out value="${userBooking.fromDate}" /></td>
            <c:choose>
                <c:when test="${userBooking.journeyType=='RETURN'}">
                    <td><c:out value="${userBooking.toFlightCode}" /></td>
                    <td><c:out value="${userBooking.toDate}" /></td>
                </c:when>
                <c:otherwise>
                    <td>-</td>
                    <td>-</td>
                </c:otherwise>
            </c:choose>
            <td><c:out value="${userBooking.finalCost}" /></td>
            <c:choose>
                <c:when test="${userBooking.userBookingStatus=='UPCOMING'}">
                    <td>
                        <form action="cancelBooking" method="post">
                            <input type="hidden" id="bookingId" name="bookingId" value="${userBooking.bookingId}">
                            <input type="submit" value="CANCEL"/>
                        </form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>-</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>
</body>
</html>