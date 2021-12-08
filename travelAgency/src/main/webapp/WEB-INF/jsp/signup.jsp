<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up </title>
</head>
<body>
<form method="post">
		Username : <input type="text" name="username" /> <br><br>
		Password : <input type="password" name="password" /><br><br>
		Email: <input type="text" name="email" /><br><br>
		<label for="questions">Choose a security Question: </label>
        		 <select name="securityQuestionId">
                          <option value="1">What is the colour of your first car?</option>
                          <option value="2">What is your mother maiden name?</option>
                          <option value="3">What is your pet name?</option>
                          <option value="4">How old are you?</option>
                        </select><br><br>

		Security Answer: <input type="text" name="securityAnswer" /><br><br>
			<input type="submit" />
			<a href="/login">Return to login Page</a>
	</form>
</body>
</html>