<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<div>

		<form method="post">
			<input name="userId" hidden=true value="1" /> <label> Amount:
			</label> <input name="displayAmount" /> </br> Enter your Credit Card Number: <input
				type="text" name="creditCardNumber" /> </br> Expiry date: <input
				type="text" name="cardExpiryDate" placeholder="YYYY/MM/DD" /> </br> Enter
			your CVV Number: <input type="password" name="cvv" /> </br> <input
				type="submit" />
		</form>
	</div>
</body>
</html>