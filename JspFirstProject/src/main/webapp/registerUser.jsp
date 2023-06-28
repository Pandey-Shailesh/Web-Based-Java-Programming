<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register User Page</title>
</head>
<body>
<jsp:useBean id="objUser" type="firstjsp.pojo.User" scope="session"/>
<%
		Connection connection = (Connection)application.getAttribute("globalConnection");
		PreparedStatement psRegister= connection.prepareStatement("insert into users_0029 values(?,?,?,?)");
	
		psRegister.setString(1,objUser.getUserName() );
		psRegister.setString(2,objUser.getPassword() );
		psRegister.setString(3,objUser.getName() );
		psRegister.setString(4,objUser.getEmail() );
		psRegister.executeUpdate();

%>
<font color='green'> User Register</font>
</body>
</html>