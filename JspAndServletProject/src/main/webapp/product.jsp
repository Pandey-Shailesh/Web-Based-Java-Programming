      
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
	<%
	Connection connection = (Connection)application.getAttribute("globalConnection");
	try(
		PreparedStatement psProduct= connection.prepareStatement("select * from product_0029 where categoryId=?");){
		int categoryId =Integer.parseInt(request.getParameter("categoryId"));
		psProduct.setInt(1,categoryId);
%>
<h1>Welcome <font color='red'><b><%= session.getAttribute("userName") %></b></font></h1><br/>
	<table border='1'>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Image</th>
			<th>Add Cart</th>
		</tr>


		<% try (ResultSet result = psProduct.executeQuery()) {
			while (result.next()) {	
		%>

		<tr>
			<td>
				<%=result.getString("productName")%>
			</td>
			<td>
				<%=result.getString("productDescription")%>
			</td>
			<td>
				<%=result.getString("productPrice")%>
			</td>
			<td><img src='Images/<%=result.getString("productImageUrl")%>' height='60px' width='60px' />
			</td>
			<td>
			<a href='AddCart?categoryId=<%=result.getInt("categoryId")%>&productId=<%=result.getInt("productId") %>&price=<%=result.getInt("productPrice") %>'>Add Cart
			</a>
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