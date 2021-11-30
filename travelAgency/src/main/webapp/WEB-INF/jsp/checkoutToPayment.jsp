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
		<form method="post">
			<input name="userEmail" hidden=true value= ${userEmail} /> 
			Name:<input name="name"/> </br> 
			 Address: <input type="text" name="address" /> </br> 
			 Phone Number: <input type="text" name="phoneNumber"/> </br> 
			 Promo Code: <input type="text" name="promoCode" /> </br> 
			 Buy Insurance: <input type="checkbox" name="insurance" /> </br> 
			 Claim additional baggage: <input type="text" name="addOnBaggage" /> </br> 
			 <input type="submit" />
		</form>
	</div>
</body>
</html>