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
	 <form action="forgotpassword" method="post">
     Email :  <input type="text" name="email" /> <input type="submit" />
     
     
     </form>
</body>
</html>