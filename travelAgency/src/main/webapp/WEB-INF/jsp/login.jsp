<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<font color="red">${errorMessage}</font>
	<form action="login" method="post">
		Username : <input type="text" name="emailId" /> Password : <input
			type="password" name="password" /> <input type="submit" />
		<a href="/forgotpassword">Forgot your password?</a>
		

		
	</form>
</body>
</html>