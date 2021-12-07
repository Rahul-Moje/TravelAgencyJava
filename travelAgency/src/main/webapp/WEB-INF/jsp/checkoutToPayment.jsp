<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
		<form method="post" action="/checkoutBooking">
			<input name="email" hidden=true value= <%request.getParameter("email");%> /> 
			<input name="initialCost" hidden=true value= ${initialCost} /> 
			 Name:<input name="name"/> </br> 
			 Address: <input type="text" name="address" /> </br> 
			 Phone Number: <input type="text" name="phoneNumber"/> </br> 
			 Promo Code: <input type="text" name="promoCode" /> </br> 
			 Buy Insurance: <input type="checkbox" name="insurance" value=true/> </br> 
			 <input type="submit" />
		</form>
	</div>
</body>
</html>