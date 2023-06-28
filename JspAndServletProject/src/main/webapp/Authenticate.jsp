<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Connection connection = (Connection) application.getAttribute("globalConnection");
	try (PreparedStatement psSelect = connection
			.prepareStatement("select * from users_0029 where userName =? and password =?");) {

		

		String userName = request.getParameter("userName");

		String password = request.getParameter("password");

		psSelect.setString(1, userName);
		psSelect.setString(2, password);

		try (ResultSet result = psSelect.executeQuery();) {
			if (result.next()) {
		response.sendRedirect("Category.jsp");
	%>
	<font color='green'>You have been authenticated, </font>
	<%=userName%>
	<%
	} else {
	%>
	<font color='red'>Authentication Failure</font>
	<%
	}
	}
	}
	%>
</body>
</html>