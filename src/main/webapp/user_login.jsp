<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="./css/admin_login.css">
</head>
<script src="https://kit.fontawesome.com/4670603c33.js" crossorigin="anonymous"></script>

<body>
	<div id="container">

		<div id="form_container1">
			<form action="userlogin" method="post">

				<h1>Login</h1>
				<br>
				<label for="username">Username :</label>
				<input type="email" id="username1" name="email" autocomplete="off">
				<br>
				<p id="para1">.</p>
				<label for="pass">Password :</label>
				<input type="password" id="pass1" name="password">
				<i class="fa-solid fa-eye fa-xs" id="i1"></i>
				<i class="fa-solid fa-eye-slash fa-sm" id="i2"></i>
				<br>
				<br>
				<br>
				<button id="butt1">Submit</button>
				<p id="error1"></p>
				<%String message1 = (String) request.getAttribute("message"); %>
				<% if(message1 != null){ %>
					<p class="message"><%= message1 %></p>
				<% } %>
				<p class="acc">Create New Account? <a href="#" onclick="fun1()"> Sign-up</a></p>
			
			</form>
		</div>
		
		<div id="form_container2">
			<form action="usersignup" method="post">
			
				<h1>Sign-up</h1>
				<br>
				<label for="name">Name :</label>
				<input type="text" id="name" name="name" autocomplete="off">
				<br>
				<p id="para2">.</p>
				<label for="username">Mail-ID :</label>
				<input type="email" id="username2" name="email" autocomplete="off">
				<br>
				<p id="para3">.</p>
				<label for="new-pass">Create Password :</label>
				<input type="password" id="pass2">
				<i class="fa-solid fa-eye fa-xs" id="i3"></i>
				<i class="fa-solid fa-eye-slash fa-sm" id="i4"></i>
				<br>
				<br>
				<label for="pass">Confirm Password :</label>
				<input type="password" id="confirm_pass" name="password">
				<i class="fa-solid fa-eye fa-xs" id="i5"></i>
				<i class="fa-solid fa-eye-slash fa-sm" id="i6"></i>
				<br>
				<br>
				<button id="butt2">Submit</button>
				<p id="error2"></p>
				<%String message2 = (String) request.getAttribute("message"); %>
				<% if(message2 != null){ %>
					<p class="message"><%= message2 %></p>
				<% } %>
				<p class="acc">Already have an Account? <a href="#" onclick="fun2()"> Log-in</a></p>
			
			</form>
		</div>

	</div>
	<script src="./js/user_login.js"></script>
</body>

</html>