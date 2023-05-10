<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
</head>
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
				<nav class="navbar navbar-light bg-light">
					<div class="container">
						<a class="navbar-brand" href="#"> <img
							src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
							alt="" width="88" height="48">
						</a>
					</div>
				</nav>
				</div>
			<div>
				<ul class="navbar-nav">
				<li style="display: inline-block; padding: 5px;">
				<a href="index.jsp"  type="button" class="btn btn-outline-success">Home</a><br>
				</li>  
				<li style="display: inline-block; padding:  5px;">
				<a href="SignUp.jsp"  type="button" class="btn btn-outline-success">SignUp</a><br>
				</li>
				<li style="display: inline-block; padding:  5px;">
				<a href="SignIn.jsp"  type="button" class="btn btn-outline-success">SignIn</a><br>
				</li>
			</ul>
				
			</div>		
		</nav>
			<div align="center"> 
		User Name:${userId}
		</div>
		<br>
	<h1 style="color: green;"></h1>
	<div class="alert alert-success">
  <h4 class="alert-heading">Account Sign in SUCESSFULLY</h4>
  <p>Congratulations, your Sign-in was successful! Welcome to our community. You now have access to all of our features and resources. 
  We're excited to have you join us and we look forward to seeing you around. Thank you for choosing to be a part of our platform.</p>
  <hr>
  <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
</div>
	
</body>
</html>