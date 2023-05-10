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
	<h1>Welcome to Ornaments Update page</h1> <br>
	<c:forEach items="${errors }" var="e">
	<h3>
		<span style="color: red">${e.message}</span>
	</h3>
	</c:forEach>
	<h3>
	<div><span style="color: #85F70C">${message}</span></div></h3>
	
	<form action="update" method="post">
	
	<div class="mb-3">
	<label for="fromFile" class="form-label">Id	</label>
	<input type="text"  class="form-control"  name="id" readonly  value="${dto.id }" />
	</div>
	
	<div class="mb-3">
	<label for="fromFile" class="form-label">Name</label>
	<input type="text"  class="form-control"  name="name" id="formFile"  
	required="required" placeholder="Enter Name" value="${dto.name }" />
	</div>
	
	<div class="mb-3">
	<label for="fromFile" class="form-label">Function Day</label>
	<input type="text"  class="form-control"  name="functionDay" id="formFile"  
	required="required" placeholder="Enter Function Day" value="${dto.functionDay }" />
	</div>
	
	Type : <select class="form-select"  aria-label="Default select example" name="type"  required="required">
	<option selected="selected" value="${dto.type }">${dto.type} </option>  <!-- Giving data as Dynamic i.e, in java code -->
	<c:forEach items="${type }" var="t">
	<option value="${t }">${t }</option>
	</c:forEach>
	</select>
	
	
	Places : <select class="form-select"  aria-label="Default select example" name="place"  required="required">
	<option selected="selected" value="${dto.place }">${dto.place} </option>  <!-- Giving data as Dynamic i.e, in java code -->
	<c:forEach items="${places }" var="p">
	<option value="${p }">${p }</option> 
	</c:forEach>
	</select>
	

	    <input type="submit" value="Update" class="btn btn-success" />	

</form>	

</body>
</html>