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
	<form method="post">
		Username : <input type="text" name="username" /> Password : <input
			type="password" name="password" /> <input type="submit" />
		<a href="/@{/forgot-pass-get-email}">Forgot your password?</a>
		<form th:action="@{/forgot-pass-get-email}" method="post" style="max-width: 420px; margin: 0 auto;">
		
	</form>
</body>
</html>