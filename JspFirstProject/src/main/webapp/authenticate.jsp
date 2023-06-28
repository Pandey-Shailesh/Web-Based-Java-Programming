<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authenticate Page</title>
</head>
<body>
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root","Shailesh@123");
	try(PreparedStatement psSelect = connection.prepareStatement("select * from users_0029 where userName=? and password=?");){
		
		application.setAttribute("globalConnection",connection);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if ((userName == null || userName.length() <= 0) || (password == null || password.length() <= 0)) {
			out.write("Authentication failed");
			return;
		}
		psSelect.setString(1,userName);
		psSelect.setString(2, password);
		
	try(ResultSet result = psSelect.executeQuery();){
		
		if(result.next()){
			if(userName.equals("admin")){
				response.sendRedirect("admin.jsp");
			}else{
			response.sendRedirect("category.jsp");
			}
		}else{
		%>
		<font color='red'>Sorry Please Try Again </font>
		<%
		}
		}
		}%>
		
		
		
		
</body>
</html>