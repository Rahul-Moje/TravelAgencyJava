<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome after login</title>
</head>
<body>
     <font color="red">${errorMessage}</font>
	 <form action = "grievance" method="post">
     Email :  <input type="text" name="email" value="<%= session.getAttribute("name") %>" readonly/>
     <br>
     <br>
     Complaint : <input type="text" name="complaint" size="70" />
     <br>
     <button id="btn"> Register</button>
</form>
</body>
</html>