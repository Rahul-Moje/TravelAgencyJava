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
	<label>
	Amount: 
	</label>
	<label name="displayAmount">
	${displayAmount}
	</label>
		<form method="post">
			Enter your Credit Card Number: <input type="text" name="creditCardNumber" />
			</br>
			Expiry date: <input type="text" name="cardExpiryDate" placeholder="DD/MM/YYYY"/>
			</br>
			Enter your CVV Number: <input type="password" name="cvv" /> 
			</br>
			<input type="submit" />
		</form>
	</div>
</body>
</html>