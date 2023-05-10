<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	crossorigin="anonymous">
	
</script>
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
			<div>
				 
				<ul class="navbar-nav">
				<li style="display: inline-block; padding:  5px;"> <a class="btn btn-outline-success" href="index.jsp">Home</a><br>
				</li>
    			<li style="display: inline-block; padding:  5px;">
    			  <a class="btn btn-outline-success" href="SignUp.jsp" style="color: white">SignUp</a>
   				 </li>
    			<li style="display: inline-block; padding:  5px;">
    			  <a type="button" class="btn btn-outline-success" href="SignIn.jsp" style="color: white">SignIn</a>
   				 </li>
	    			<!-- <li style="display: inline-block; padding: 20px;">
	    			  <a class="btn btn-outline-success" href="resetPassword.jsp" style="color: white">ResetPassword</a>
	   				 </li>
	    			<li style="display: inline-block; padding: 20px;">
	    			  <a class="btn btn-outline-success" href="updatePassword.jsp" style="color: white">UpdatePassword</a>
	   				 </li> -->
			</ul>

			</div>
		</div>
	</nav>

	<h1>Welcome to Registration Form</h1>
	<div align="center">

		<h6 style="color: red;">${message}</h6>
		<h6 style="color: green;">${signup}
			<br>
			<c:forEach items="${error}" var="e">${e.message}</c:forEach>
		</h6>
		
		
			
		
		<form action="display" method="post"
			class="container col-30 col-sm-30 col-md-5 shadow-lg p-5 mb-5 bg-white mx-auto d-block border border -primary rounded-lg m-5 pb-5 bg-i nfo ">
			<table>
			<h3 style="color: #ff3399">Registration </h3>
				<tr>
					<td>User ID</td>

					<td><input type="text" name="userId" id="userName" placeholder="Enter Name"
						onchange="ValidateName()" value="${dto.userId}"> <span
						id="nameError" style="color: red;"></span> <span
						id="displayUserName" style="color: red;"></span></td>
				</tr>

				<tr>
					<td>Email ID</td>
					<td><input type="email" name="email" id="emailId" placeholder="Enter Email"
						onchange="validateEmail()" value="${dto.email}"> <span
						id="emailError" style="color: red"></span> <span id="display"
						style="color: red"></span></td>
				</tr>

				<tr>
					<td>Mobile</td>
					<td><input type="number" name="mobile" id="userMobile" placeholder="Enter Mobile"
						onchange="validateMobile()" value="${dto.mobile}">
						 <span id="remainingDigits" style="color: red"></span> 
						 <span id="mobileError" style="color: red"></span> 
						 <span id="displayUserMobile" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="password" id="userPassword" placeholder="Password"
						value="${dto.password}"> <span id="passwordError"
						style="color: red;"></span> <input type="checkbox"
						onclick="myFunction1()">Show password</td>
				</tr>

				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirmPassword" placeholder="Confirm Password"
						id="userConfirmPassword" onblur="validatePassword()"
						value="${dto.confirmPassword}"> <span id="passwordCompare"
						style="color: red"></span> <!--  <input type="checkbox" onclick="myFunction2()">Show Confirm Password  -->
					</td>
				</tr>

				<tr>
					<td>Accept Agreement<input type="checkbox"
						name="acceptAgreement" id="agreementConfirm" onclick="onconfirm()">
					</td>
				</tr>
			</table>
			<div>
				<button type="submit" class="btn btn-outline-success"
					disabled="true" id="submitId">SignUp</button>
			</div>

		</form>
		</div>
	

	<h4 style="color: red;">${password}</h4>
	<script>
		function myFunction1() {
			var x = document.getElementById("userPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}

		function myFunction2() {
			var x = document.getElementById("userConfirmPassword");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}

		function onconfirm() {
			var agree = document.getElementById("agreementConfirm");
			console.log(agree.checked);
			if (agree.checked) {
				document.getElementById('submitId').disabled = false;
			} else {
				document.getElementById('submitId').disabled = 'disabled';
			}
		}

		function ValidateName() {
			var user = document.getElementById('userName');
			var uservalue = user.value;		
			console.log(uservalue);
			if (uservalue != null && uservalue != "" && uservalue.length > 3
					&& uservalue.length < 30) {
				console.log('userName is valid');
			//	document.getElementById('userNameValidationMessage').innerHTML = 'Please Provide Valid Name';
				console.log("Running in ajax");
				console.log(user);
				console.log(uservalue);
				const xhr = new XMLHttpRequest();								
				xhr.open("GET",
						"http://localhost:8080/xworkz_Deepak_CM/userName/"
								+ uservalue);
				xhr.send();

				xhr.onload = function() {
					console.log(this);
					document.getElementById("displayUserName").innerHTML = this.responseText
				}
				var agree = document.getElementById("agreementConfirm");
				console.log(agree.checked);
				if (agree.checked) {
					document.getElementById('submitId').disables = false;
				}
				document.getElementById('nameError').innerHTML = '';
			} else {
				console.log('--invalid name--');
				document.getElementById('submitId').disabled = 'disabled';
				document.getElementById('nameError').innerHTML = 'Please Enter Name Character Range from 4 to 30';
			}

		}

		function validateEmail() {
			var userEmail = document.getElementById('emailId');
			var userEmailvalue = userEmail.value;
			console.log(userEmail);
			console.log(userEmailvalue);
			if (userEmailvalue != null && userEmailvalue != "" && userEmailvalue.length > 4 && userEmailvalue.length < 40) {
				console.log('User Email id is Valid');
				const xhttp = new XMLHttpRequest();
				console.log("Running in ajax");
				console.log(userEmailvalue);
				xhttp.open("GET", "http://localhost:8080/xworkz_Deepak_CM/userName/" + userEmailvalue);
				xhttp.send();

				xhttp.onload = function () {
					console.log(this);
					document.getElementById("display").innerHTML = this.responseText

				}


				document.getElementById('emailError').innerHTML = '';
			} else {
				console.log('invalid email');
				document.getElementById('emailError').innerHTML = 'Please Enter Eamil, Character Range from 4 to 40';
			}

		}

		function validateMobile() {
			var userMobile = document.getElementById('userMobile');
			var userMobilevalue = userMobile.value;
			
			console.log(userMobilevalue);
			if (userMobilevalue != null && userMobilevalue != ""
					&& userMobilevalue.length == 10) {
				console.log('valid mobile number');
				const xhr = new XMLHttpRequest();
				console.log("Running in ajax");
				console.log(userMobilevalue);
				// Count the number of digits entered so far
				  var numberOfDigits =userMobilevalue.length;
				// Calculate the remaining number of digits
				  var remainingDigits = 10 - numberOfDigits;
				  // Display the remaining number of digits to the user
				  var remainingDigitsElement = document.getElementById('remainingDigits');
				  //remainingDigitsElement.innerHTML = remainingDigits + ' digits remaining';
				
				  xhr.open("GET",
						"http://localhost:8080/xworkz_Deepak_CM/userName/"
								+ userMobilevalue, true);
				  xhr.onreadystatechange = function() {
					    if (xhr.readyState == 4 && xhr.status == 200) {
					      // Update the remaining digits count element with the response from the server
					      var remainingDigitsElement = document.getElementById('remainingDigits');
					      remainingDigitsElement.innerHTML = xhr.responseText;
					    }
					  };
				  
					// Display a message to the user while waiting for the server response
					  var remainingDigitsElement = document.getElementById('remainingDigits');
					 // remainingDigitsElement.innerHTML = 'Calculating remaining digits...';
				  
				  document.getElementById('remainingDigits').innerHTML = '';
				xhr.send();

				xhr.onload = function() {
					console.log(this);
					document.getElementById("displayUserMobile").innerHTML = this.responseText

				}

				document.getElementById('mobileError').innerHTML = '';
			} else {
				console.log('invalid mobile');
				document.getElementById('mobileError').innerHTML = 'Please Enter Valid Mobile Number must be 10 digits';
			}

		}

		function validatePassword() {
			var userPassword = document.getElementById('userPassword');
			var userConfirmPassword = document
					.getElementById('userConfirmPassword');
			var userPasswordvalue = userPassword.value;
			var userConfirmPasswordvalue = userConfirmPassword.value;
			console.log(userPasswordvalue);
			if (userPasswordvalue != null && userPasswordvalue != ""
					&& userPasswordvalue.length > 4
					&& userPasswordvalue.length < 12) {
				if (userPasswordvalue == userConfirmPasswordvalue) {
					console.log('validate both password are same');
					document.getElementById('passwordCompare').innerHTML = '';
				} else {
					console.log('validate both password are not same');
					document.getElementById('passwordCompare').innerHTML = 'Password and Confirm Password are not same';
				}
				console.log('validate password');
				document.getElementById('passwordError').innerHTML = '';
			} else {
				console.log('invalid  password');
				document.getElementById('passwordError').innerHTML = 'Please enter valid password';
			}
		}
	</script>
</body>
</html>