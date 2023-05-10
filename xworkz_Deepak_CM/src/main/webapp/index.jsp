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
	
	<style>
	h1 {text-align: center;}
	p {text-align: center;}
	div {text-align: center;}
	
	
	html,body{
  height:5%;
}
body{
  text-align:center;
}
body:before{
  content:'';
  height:50%;
  display:inline-block;
  vertical-align:middle;
}
button{
  background: #99cc00;
  color:#fff;
  border:none;
  position:relative;
  height:50px;
  font-size:1.6em;
  padding:0 2em;
  cursor:pointer;
  transition:800ms ease all;
  outline:none;
}
button:hover{
  background:#fff;
  color:#ff0066;
}
button:before,button:after{
  content:'';
  position:absolute;
  top:0;
  right:0;
  height:2px;
  width:0;
  background: #1AAB8A;
  transition:400ms ease all;
}
button:after{
  right:inherit;
  top:inherit;
  left:0;
  bottom:0;
}
button:hover:before,button:hover:after{
  width:100%;
  transition:800ms ease all;
}
	

</style>
<!-- 	 -->
</head>
<body>
	<!--  -->	
				<nav class="navbar   sticky-top navbar-expand-lg navbar-expand-sm  navbar-light bg-dark">
			<div class="container-fluid">
				<nav class="navbar  navbar-light bg-light">
					<div class="container">
						<a class="navbar-brand" href="#"> <img
							src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
							alt="" width="88" height="48">
						</a>
					</div>				
				</nav>
				</div>
				
			<div>
			<!-- <a href="index.jsp"><button type="button"
							class="btn btn-warning btn-lg">
							Home <span class="glyphicon glyphicon-ok"></span>
						</button></a>
						 -->
				<ul class="navbar-nav">
				
    			<li style="display: inline-block; padding:  5px;">
    			  <a class="btn btn-outline-success" href="SignUp.jsp" style="color: white">SignUp</a>
   				 </li>
    			<li style="display: inline-block; padding:  5px;">
    			  <a type="button" class="btn btn-outline-success" href="SignIn.jsp" style="color: white">SignIn</a>
   				 </li>
    			<!-- <li style="display: inline-block; padding:  5px;">
    			  <a class="btn btn-outline-success" href="resetPassword.jsp" style="color: white">ResetPassword</a>
   				 </li>
    			<li style="display: inline-block; padding:  5px;">
    			  <a class="btn btn-outline-success" href="updatePassword.jsp" style="color: white">UpdatePassword</a>
   				 </li> -->
			</ul>
			</div>	
			
		</nav>

		
	<h1 style=center;>Welcome to index page </h1>
	<marquee><h3>This project contains login page and profiles.</h3></marquee> 		
	  		
	  		<a href="SignUp.jsp" ><button type="button">Register </button></a>
	  		
		<nav class="navbar fixed-bottom navbar-light bg-dark">
  <a class="navbar-brand" href="#" style="color: green">deepak-common-module</a>
</nav>
</body>
</html>