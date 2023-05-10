<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<a class="navbar-brand" href="#"> <img alt=""
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				width="80" height="50" class="d-inline-block align-text-top">
			</a>
			<!-- <a href="index.jsp">Home</a>	 -->

			<ul>
				<li style="display: inline-block; padding: 20px;">
					<!-- 	<a href="Display.jsp" class="col-lg-2 col-sm-2">Display</a>  -->
					<a href="OrnamentsSearch.jsp"><button type="button"
					class="btn btn-warning btn-lg">
					Search  <span class="glyphicon glyphicon-ok"></span>
				</button></a>
					<a href="index.jsp"><button type="button"
							class="btn btn-warning btn-lg">
							Home <span class="glyphicon glyphicon-ok"></span>
						</button></a>
						
				<li style="display: inline-block;">
			</ul>
		</div>
	</nav>
	<h1>Ornaments Registration Page</h1>

	<c:forEach items="${errors}" var="e">
		<br>
		<span style="color: red;">${e.message}</span>
	</c:forEach>

	<form action="Ornaments" method="post">
		<pre>

	<label for="formFile" class="form-label">Name :</label> <input
	type="text" class="form-control" name="name" id="formFile"
	required="required" placeholder="Enter name"  />
				
	<label for="formFile" class="form-label">Function Day :</label> <input
	type="text" class="form-control" name="functionDay" id="formFile"
	required="required" placeholder="Enter Function Day"  />
	Type : <select name="type" class="form-select"
			aria-label="Default select example" required="required">
	<option selected value="">Select Type </option>  <!-- Giving data as Dynamic i.e, in java code -->
	<c:forEach items="${type }" var="t">
	<option value="${t }">${t }</option>
	</c:forEach>
	</select>
	
	Places : <select class="form-select"
	aria-label="Default select example" name="place"
	required="required">
	<option selected value="">Select Places</option>  <!-- Giving data as Dynamic i.e, in java code -->
	<c:forEach items="${places}" var="p">
	<option value="${p}">${p}</option>
	</c:forEach> 
	</select> <br>	
	
	
	    <input type="submit" value="Save" class="btn btn-success" />
		

	</pre>
	</form>

</body>
</html>