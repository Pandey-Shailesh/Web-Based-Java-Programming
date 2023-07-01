      

<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.DriverManager"
	import="java.util.List"
	import="org.hibernate.SessionFactory"
	import="org.hibernate.Session" 
	import="org.hibernate.query.Query"
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	<%
	SessionFactory hibernateFactory = (SessionFactory)getServletContext().getAttribute("hibernateFactory");
	try(Session hibernateSession = hibernateFactory.openSession()){
%>
<h1>Welcome <font color='red'><b><%= session.getAttribute("userName") %></b></font></h1><br/>
	<table border='1'>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Image</th>
		</tr>


		<% Query<Category> authenticateQuery = hibernateSession.getNamedQuery("category");
		authenticateQuery
			while () {	
		%>

		<tr>
			<td>
			<a href='products.jsp?categoryId=<%= result.getInt("categoryId")%>'> <%=result.getString("categoryName")%>
			</a>
			</td>
			<td>
				<%=result.getString("categoryDescription")%>
			</td>
			<td><img src='Images/<%=result.getString("categoryImageUrl")%>' height='60px' width='60px' />
			</td>
		</tr>
	
	<%}catch (HibernateException  e) {
		e.printStackTrace();
	} 
	catch ( NoResultException e) {
		response.sendRedirect("login.jsp");
		e.printStackTrace();
	}
	
	}
		 %>
</table>
</body>
</html>