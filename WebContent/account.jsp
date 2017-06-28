<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%String redirectedFrom = (String)request.getServletContext().getAttribute("RedirectedFrom");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>WebForum | Official page</title>

<link rel="stylesheet" href="css/account.css" />

<script src="scripts/jquery-3.2.1.min.js"></script>
<script src="scripts/account.js"></script>
</head>
<body>

	<form id="loginForm" method="POST" action="/WebProjekat/LoginServlet"
		<% if(redirectedFrom == "REGISTER") {%> style="display: none;" <%}%>>
		<h1>Login</h1>

		<input id="usernameLogin" name="username" type="text"
			placeholder="Usernname..." /> <input id="passwordLogin"
			name="password" type="password" placeholder="Password..." /> <label>
			<input name="rememberMe" type="checkbox" /> Remember me
		</label>

		<button id="firstNameRegister">Log in</button>
		<a id="switchToRegistration" href="javascript:;">Don't have an
			account? - Register</a>
	</form>

	<form id="registerForm" method="POST"
		action="/WebProjekat/RegisterServlet"
		<% if(redirectedFrom == "LOGIN" || redirectedFrom == null) {%> style="display: none;" <%}%>>
		<h1>Register</h1>

		<input id="firstNameRegister" name="firstName" type="text"
			placeholder="First name..." /> <input id="lastNameRegister"
			name="lastName" type="text" placeholder="Last name..." /> <input
			id="usernameRegister" name="username" type="text"
			placeholder="Usernname..." /> <input id="emailRegister" name="email"
			type="text" placeholder="Email..." /> <input id="passwordRegister"
			name="password" type="password" placeholder="Password..." /> <input
			id="repeatPasswordRegister" type="password"
			placeholder="Repeat password..." />

		<button id="registerButton">Register</button>
		<a id="switchToLogin" href="javascript:;">Already have an account?
			- Login</a>
	</form>
</body>
</html>




