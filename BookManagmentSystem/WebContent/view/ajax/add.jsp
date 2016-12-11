<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Book's Information</h1>
	<hr>
	<div id="msg" style="color:red"></div>
	<form id="formSave">
		<table>
			
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" id="id" placeholder="id"></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" id="title"
					placeholder="title"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" id="description"
					placeholder="description"></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><input type="text" name="author" id="author"
					placeholder="author"></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><input type="text" name="image" id="image" placeholder="image">
					<input type="file" name="file" id="file" />	
				</td>
			</tr>
			<tr>
				<td><input type="button" value="Cancel"></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {

			$('form#formSave').submit(function(event) {
				event.preventDefault(); //prevent form submit by default (refresh page)
				save();
			});

			$('#file').change(function(){
				upload();
			});
			
			function save() {
				$.ajax({
					url : '${pageContext.request.contextPath}/admin/ajax/save',
					method : 'POST',
					data : {
						book : JSON.stringify({
							id : $('#id').val(),
							title : $('#title').val(),
							description : $('#description').val(),
							author : $('#author').val(),
							image : $('#image').val()
						})
					},
					success : function(data) {
						console.log(data);
						if(data.status){
							location.href = "${pageContext.request.contextPath}/admin/books";
						}else{
							$('#msg').html('<p>' + data.message + '</p>');
						}
					},
					error : function(data) {
						console.log(data);
					}
				});
			}

			function upload(){
				var formData = new FormData();
				var files = $('#file')[0].files;
				formData.append('file', files[0]);
				
				$.ajax({
					url: '${pageContext.request.contextPath}/ajax/upload',
					method: 'POST',
					data: formData,
					
					cache: false,
					contentType: false,
					processData: false,
					
					success: function(data){
						console.log(data);
						$('#image').val(data);
					},
					error: function(error){
						console.log(error);
					}
				});
			}	
			
		});
	</script>
</body>
</html>