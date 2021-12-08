<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Commission</title>
</head>
<body>
	<h1>Commission List</h1>
	<table border = "1">
		<tr>
			<th>User ID</th>
			<th>Date and Time</th>
			<th>Ticket Amount</th>
			<th>Commission Amount</th>
		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.userId}</td>
				<td>${e.dateTime}</td>
				<td>${e.ticketAmount}</td>
				<td>${e.commissionAmount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>