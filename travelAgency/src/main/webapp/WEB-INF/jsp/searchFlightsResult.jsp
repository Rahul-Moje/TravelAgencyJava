<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
</head>
<body>
<span style="color: red;">${errorMessage}</span>
<c:if test="${errorMessage.length()==0}">
Displays search results
</c:if>
</body>
</html>