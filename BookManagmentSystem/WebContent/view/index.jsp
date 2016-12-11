<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
<title>Insert title here</title>
	<link rel="stylesheet" href="resources/style.css"> 
<style>
	.book{
	}
</style>
</head>
<body>


	<div class="book">
		<h1>Book's Information</h1><hr>
		<a href="add">Add New</a>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Image</th>
				<th>Title</th>
				<th>Description</th>
				<th>Author</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${requestScope.books }" var="book">
				<tr>
					<td>${book.id }</td>
					<td><img src="${pageContext.request.contextPath }/${book.image }" width="50px" height="50px" alt="${book.image }"></td>
					<td>${book.title }</td>
					<td>${book.description }</td>
					<td>${book.author }</td>
					<td>
						<a href="${pageContext.request.contextPath }/book/edit?id=${book.id}">Edit</a>
						<a href="${pageContext.request.contextPath }/book/remove?id=${book.id}">Remove</a>
					</td>
				</tr>			
			</c:forEach>
		</table>
	</div>
	
</body>
</html>