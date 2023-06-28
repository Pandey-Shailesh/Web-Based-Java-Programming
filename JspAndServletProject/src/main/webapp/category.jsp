      
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
	<%
	Connection connection = (Connection)application.getAttribute("globalConnection");
	try(
		PreparedStatement psCategory= connection.prepareStatement("select * from category_0029");){
%>
<h1>Welcome <font color='red'><b><%= session.getAttribute("userName") %></b></font></h1><br/>
	<table border='1'>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Image</th>
		</tr>


		<% try (ResultSet result = psCategory.executeQuery()) {
			while (result.next()) {	
		%>

		<tr>
			<td>
			<a href='products.jsp?categoryId=<%=result.getInt("categoryId")%>'> <%=result.getString("categoryName")%>
			</a>
			</td>
			<td>
				<%=result.getString("categoryDescription")%>
			</td>
			<td><img src='Images/<%=result.getString("categoryImageUrl")%>' height='60px' width='60px' />
			</td>
		</tr>
	
	<% }
			}catch (SQLException e) {
			e.printStackTrace();
			}
		}
		 %>
</table>
</body>
</html>