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
     
	 <form action="registerMemberShipDetails" method="get">
	<table border="1" cellpadding="5" style="width:100%">
            <caption><h2>ProMemberShipDetails</h2></caption>
            <tr>
                <th>Plan Name</th>
                <th>Plan Validity in years</th>
                <th>Plan Cost</th>
                <th>Plan Discount percentage</th>
            </tr>
            
            <c:forEach items="${list}" var="user">   
                <tr>
                    <td><c:out value="${user.plan_name}" /></td>
                    <td><c:out value="${user.plan_validity_in_years}" /></td>
                    <td><c:out value="${user.plan_cost}" /></td>
                    <td><c:out value="${user.plan_discount_in_percentage}" /></td>
                </tr>
            </c:forEach>
        </table>
        <button id="btn"> Register</button>
        </form>
         <br>
        
</body>
</html>