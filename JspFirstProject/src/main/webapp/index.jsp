<%@ page import="java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	for(int iTemp = 0; iTemp < 100; iTemp++) {
		out.write("Todays date is :");
	%>
	 <%= new Date()%>
	<br />
		<% for (int jTemp = 0; jTemp < 2; jTemp++) {
			out.write("Hello coder's");
			 %>
			 <br/>
			 <% } %>

    <% } %>
</body>
</html>