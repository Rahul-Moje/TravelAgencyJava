<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome after login</title>
</head>
<body>
     <font color="red">${errorMessage}</font>
	 <form action="registerMemberShipDetails" method="post">
     Email : <input type="text" name="email" value="<%= session.getAttribute("name") %>" readonly />
     <!--plan name :  <input type="text" name="plan_name" />--> 
     <br>
     <br>
     Choose a plan:<select name="plan_name">
    <c:forEach items="${list}" var="category">
        <option value="${category.plan_name}">${category.plan_name}</option>
    </c:forEach>
</select>
     <br>
     <br>
     date :  <input type="text" name="date" value="<%= session.getAttribute("currentdate") %>" readonly /> 
     <br>
     <br>
     <input type="submit" />
     </form>
</body>
</html>

