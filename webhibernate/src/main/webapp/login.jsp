<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
  	<h1>Login Page</h1><br/>
			<form action="Authenticate" method="post">
			User Name : <input type="text" name="userName"/><br/>
			<br/>
			Password : <input type="password" name="password"/><br/>
			<br/>
			<input type="submit" value="Login"/>
			</form>
			<br/>
			<a href="register.jsp"> Register  </a>
</body>
</html>