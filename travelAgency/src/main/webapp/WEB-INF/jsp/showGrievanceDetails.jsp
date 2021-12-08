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
     
	
	<table border="1" cellpadding="5" style="width:100%">
            <caption><h2>GrievanceFiled</h2></caption>
            <tr>
                
                <th>complaint</th>
                
            </tr>
            
            <c:forEach items="${listofGrievance}" var="user">   
                <tr>
                     <td><c:out value="${user.complaint}" /></td>
                </tr>
            </c:forEach>
        </table>
         <br>
        
</body>
</html>