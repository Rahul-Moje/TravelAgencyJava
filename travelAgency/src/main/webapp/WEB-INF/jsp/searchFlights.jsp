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
<form action="searchFlights" method="post">
    From : <input type="text" name="from" />
    To : <input type="text" name="to" />
    <input type="submit" />



</form>
</body>
</html>