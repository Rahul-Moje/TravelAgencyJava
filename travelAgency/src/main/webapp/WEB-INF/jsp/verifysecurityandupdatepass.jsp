<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome after login</title>
</head>
<body>
     <font color="red">${errorMessage}</font>
	 <form action="verifysecurityandupdatepass" method="post" name="myform">
     <h1>${securityquestion}</h1>
     <br>
     <input type="text" name="security_question" value ="${securityquestion}" hidden />
     Email : <input type="text" name="email" value ="${email}" readonly />
     SecurityAnswer :  <input type="text" name="security_answer" /> 
     NewPassword :  <input type="text" name="new_password" /> 
     UpdatePassword :  <input type="text" name="update_password" /> 
     <input type="submit" />
     
     </form>
 
</body>
</html>