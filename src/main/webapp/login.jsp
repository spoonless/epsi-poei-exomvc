<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<form method="POST" action="j_security_check">
		<label>Login</label> 
		<input type="text" name="j_username">
		<label>Mot de passe</label> 
		<input type="password" name="j_password">
		<button type="submit">login</button>
	</form>
</body>
</html>