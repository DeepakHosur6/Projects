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

<link rel="stylesheet" href="/.style.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"
				class="d-inline-block align-text-top"> <img alt=""
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				width="80" height="50" class="d-inline-block align-text-top">
			</a>
			<ul>
				<li style="display: inline-block; padding: 20px;"><a
					href="Ornaments"><button type="button"
							class="btn btn-warning btn-lg">
							Register <span class="glyphicon glyphicon-ok"></span>
						</button></a> <a href="index.jsp"><button type="button"
							class="btn btn-warning btn-lg">
							Home <span class="glyphicon glyphicon-ok"></span>
						</button></a>
			</ul>
		</div>
	</nav>

	<h1 style="color: orange;">Welcome to Name search page</h1>
	<h3>
	<br>
		<span style="color: blue"> ${message}</span>
	</h3>
	<form action="searchbyname " method="get"    style="color: purple  " >
		Search By Name : <input type="text" name="name" placeholder=" Search Name" /> <input class ="btn btn-success" type="submit"
			name="search" /> <br>
	</form>
	<br>
	<div>
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
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  
			
			<c:forEach items="${list }" var="n">
				<tr class="table-success">
					<td>${n.id }</td>
					<td>${n.name }</td>
					<td>${n.functionDay }</td>
					<td>${n.type }</td>
					<td>${n.place }</td>
					<td><a href="update?id=${n.id }">Edit</a></td>
					<td><a href="delete?id=${n.id }">Delete</a></td>

				</tr>
			</c:forEach>
			</tbody> 
		</table>

	</div>
</body>
<script>

		/* function myFunction1() {
			console.log("hi")	
		} */
		const myElement = document.getElementById("getAll");
		console.log("myElement   "+myElement)	
		const xhr = new XMLHttpRequest();					
		xhr.open("GET",
						"http://localhost:8080/xworkz_Deepak_CM/findAll/");
				xhr.send();
				
				xhr.onload = function() {
					console.log(this);
					/* document.getElementById("displayUserName").innerHTML = this.responseText */
				}

</script>
</html>