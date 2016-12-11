<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <p>${requestScope.message}</p>
	<form action="${pageContext.request.contextPath}/upload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file" />
		<input type="submit" value="Upload"> 
	</form> --%>
	
	
	<form enctype="multipart/form-data">
		<input type="file" name="file" id="file" multiple>
		<input type="submit" value="Upload">
	</form>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		
	<script>
		$(document).ready(function(){
			$('form').submit(function(event){
				event.preventDefault();				
				
				var formData = new FormData();
				var files = $('#file')[0].files;
				//console.log(files);
				formData.append('file', files[0]);
				
				
				$.ajax({
					url: '${pageContext.request.contextPath}/ajax/upload',
					method: 'POST',
					data: formData,
					
					cache: false,
					contentType: false,
					processData: false,
					
					success: function(response){
						console.log(response);
					},
					error: function(response){
						console.log(response);
					}
				});
				
			});
		});
	</script>
</body>
</html>