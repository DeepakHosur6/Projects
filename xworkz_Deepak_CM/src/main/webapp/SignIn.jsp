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
			</ul>	
			</div>		
		</nav>
			<div align="center"> 
		<h4 style="color: #ff3300;">${match}</h4>
		<h5 style="color: red;">${msg}</h5>
		<h5 style="color: red;">${msgs}</h5>
		
<!-- 		<div class="col-md-4 col-lg-6 col-xl-5">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
          class="img-fluid" alt="Sample image">
      </div> -->
		
		
		<form action="signin" method="post"  class="container col-30 col-sm-30 col-md-5 shadow-lg p-5 mb-5 bg-white mx-auto d-block border border -primary rounded-lg m-5 pb-5 bg-i nfo  ">
			<table>
				<tr>
					<td>User ID </td>
					
					<td><input type="text" name="userId" id="userName" onchange="ValidateName()">
							<span id="nameError" style="color: red;"></span>
							<span id="displayUserName" style="color: red;"></span>				
					</td>
					</tr>
					<tr>
					<td>Password </td>
					<td><input type="password" name="password" id="userPassword" onblur="validatePassword()">
						<span id="passwordError" style="color: red;"></span>
						<input type="checkbox" onclick="myFunction()"> Show password
					</td>
					</tr>
			</table>
			<div> <br>
			<button type="submit"  class="btn btn-outline-success"  role="alert" >SignIn</button>
			
		<!-- 	<div class="alert alert-success">
  <h4 class="alert-heading">Successfully done!</h4>
  <p>Congratulations, your Sign-in was successful! Welcome to our community. You now have access to all of our features and resources. We're excited to have you join us and we look forward to seeing you around. Thank you for choosing to be a part of our platform.</p>
  <hr>
  <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
</div> -->
			</div>
		</form>
		<div class="d-flex justify-content-center">
		<ul> <li style="display: inline-block; padding:  5px;">
		<a href="SignUp.jsp" class="btn btn-primary btn-sm">Register as new user</a><br> </li>
		<li style="display: inline-block; padding:  5px;">
		<a href="resetPassword.jsp " class="btn btn-outline-secondary btn-sm">Reset Password</a><br> </li>
		<li style="display: inline-block; padding:  5px;">
		<a href="updatePassword.jsp" class="btn btn-primary btn-sm">Update Password</a><br> </li>
		</ul>
		</div>
		</div>
	<script>
	function ValidateName() {
		var user = document.getElementById('userName');
		var uservalue = user.value;
		console.log(uservalue);
		if(uservalue != null && uservalue !="" && uservalue.length > 3 && uservalue.length < 30)
		{
			console.log('validate name');
			document.getElementById('nameError').innerHTML = '';
		}
		else {
			console.log('invalidate name');
			document.getElementById('nameError').innerHTML = 'Please enter valid name min 4 and max 29 chars';
		}
	}
	
	
	function myFunction() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		</script>
		

		</body>
		</html>
		