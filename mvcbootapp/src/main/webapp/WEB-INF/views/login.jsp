<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<form:form action="authenticate" modelAttribute="objUser">
	
	User Name:<form:input path="userName" />
		<br />
	Password:<form:input path="password" />
		<br />
		<form:button>Login</form:button>
		<br />
	</form:form>
</body>
</html>   