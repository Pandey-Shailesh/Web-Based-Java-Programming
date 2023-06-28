<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
<h1>Register Page</h1><br/>
    <form action="confirmUser.jsp" method="post">
     Name: <input type="text" name="name"/><br/>
    <br/>
     User Name:<input type="text" name="userName"/><br/>
    <br/>
     Password:<input type="password" name="password"/><br/>
    <br/>
     Email Address: <input type="email" name="email"/><br/>
    <br/>
     <br/>
     <input type="submit" value="Register"/>
    </form>
      <br/>
       <br/>
       <a href="login.jsp"> Login</a>
</body>
</html>