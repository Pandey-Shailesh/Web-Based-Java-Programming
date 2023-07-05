<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveCategory" modelAttribute="objCategory">
	
	Name : <form:input path="categoryName"/><br/>
	Description : <form:input path="categoryDescription"/>
	Image : <form:input path="categoryImageUrl"/>
	<form:button>Add Category</form:button>
	
	</form:form>
</body>
</html>