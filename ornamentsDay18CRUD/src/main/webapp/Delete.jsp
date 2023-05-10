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
				class="d-inline-block align-text-top"><img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" height="48" width="80"> </a><ul>
				<li style="display: inline-block;padding: 20px;">
					<a href="index.jsp" class="col-lg-2 col-sm-2">Home Page</a>
					<li style="display: inline-block;">
					<a href="Ornaments" class="col-lg-2 col-sm-2">Ornaments Register</a>
				</ul>
			</div>
	</nav>

	
	<h1 style="color: orange;">Welcome to Delete page</h1>
	<h4>The data is deleted by id </h4>
	<h3>
	<br>
		<span style="color: blue"> ${message}</span>
	</h3>
	<h3>
		<span style="color: red;">${error }</span>
	</h3>
	<!-- 
	<form action="delete " method="get"    style="color: purple  " >
		Search By Id : <input type="text" name="name" placeholder=" ID" /> <input class ="btn btn-success" type="submit"
			name="search" /> <br>
	</form>   -->
	<br>
	<div><h4 style="color: red;">The Data is Deleted  </h4>
		<span>     </span>
		<table border="1" class="table table-striped table-dark" >  <!-- class="table table-dark" -->
																				<!-- https://getbootstrap.com/docs/4.1/content/tables/ -->
		 <thead >
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Function</th>
      <th scope="col">Type</th>
      <th scope="col">Place</th>
   
    </tr>
  </thead>
  <tbody>
  
  	<tr>
	<td>${delete.id}</td>
	<td>${delete.name}</td>
	<td>${delete.functionDay}</td>
	<td>${delete.type}</td>
	<td>${delete.place}</td>
	
	</tr>
		
			<!-- <c:forEach items="${dto }" var="d">
				<tr class="table-success">
					<td>${d.id }</td>
					<td>${d.name }</td>
					<td>${d.functionDay }</td>
					<td>${d.type }</td>
					<td>${d.place }</td>
				</tr>
			</c:forEach>	 -->	
			</tbody>
		</table>
	</div>
</body>
</html>