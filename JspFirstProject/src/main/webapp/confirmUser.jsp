<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm User Page</title>
</head>
<body>

<jsp:useBean id="objUser" class="firstjsp.pojo.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="objUser"/>

Please Review your data:-<br/>
UserName : <jsp:getProperty property="userName" name="objUser"/><br/>
Password : *******<br/>
Name     : <jsp:getProperty property="name" name="objUser"/><br/>
Email    : <jsp:getProperty property="email" name="objUser"/><br/>

<a href='registerUser.jsp'>Confirm</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='register.jsp'>Modify</a>


</body>
</html>