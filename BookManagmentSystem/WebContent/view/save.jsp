<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save Book</title>
</head>
<body>
	
	<h1>${param.id ==null?'Add New Book':'Edit Book' }</h1><hr>
	<form action="${pageContext.request.contextPath }/${param.id==null?'save':'update'}" method="POST">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="${param.id!=null?'hidden':'text'}" name="id"  value="${requestScope.book.id }" placeholder="book's id"/></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" value="${requestScope.book.title }" placeholder="book's title"/><br></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" value="${requestScope.book.description }" placeholder="book's description"/></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><input type="text" name="author" value="${requestScope.book.author }" placeholder="book's author"/></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="text" name="image" value="${requestScope.book.image }" placeholder="book's image"/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="button" value="Cancel">
					<input type="submit" value="Save">
				</td>	
			</tr>
		</table>
		 
	</form>
</body>
</html>