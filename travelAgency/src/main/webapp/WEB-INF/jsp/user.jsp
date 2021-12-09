<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

		<a href="/showMemberShipDetails">Show ProMembership Options!</a>
		<br>
		<a href="/searchFlights">Search Flights</a>
		<br>
		<a href="/grievance">File a Grievance!!</a>
		<br>
		<a href="/userProfile">My Bookings</a>
		<br>
		<c:if test="${name == 'admin@dal.ca'}">
		<a href="/showGrievanceDetails">View all Grievances Filed</a>
		<br>
		<a href="/commission">View Commissions</a>
		</c:if>
		 
		
		
		
	</form>
	
	
</body>
</html>