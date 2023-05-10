<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"
				class="d-inline-block align-text-top">
				<img alt=""
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				width="80" height="50" class="d-inline-block align-text-top">
			</a>
			<ul>
				<li style="display: inline-block; padding: 20px;">
				<a href="Ornaments"><button type="button"
					class="btn btn-warning btn-lg">
					Register  <span class="glyphicon glyphicon-ok"></span>
				</button></a>
					<a href="index.jsp"><button type="button"
							class="btn btn-warning btn-lg">
							Home <span class="glyphicon glyphicon-ok"></span>
						</button></a>
			</ul>
		</div>
	</nav>
	<h1>Welcome to Image Upload page</h1> <br>
	<h3>
		<!-- <span style="color: red">${message}</span>	 -->
	</h3>
	<form action="upload" method="post" enctype="multipart/form-data">
		Upload : <input type="file" name="chitra" /> 
		<input type="submit" class="btn btn-success" value="Upload"  />
			
	</form>

</body>
</html>