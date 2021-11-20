<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

		<a href="/showMemberShipDetails">Show ProMembership Options!</a>
		<br>
		<br>
		<a href="/grievance">File a Grievance!!</a>
		
		 <input type="text" name="setemail" value="<%= session.getAttribute("name") %>" >
		
	</form>
</body>
</html>