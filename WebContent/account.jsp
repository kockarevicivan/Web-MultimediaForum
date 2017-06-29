<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String redirectedFrom = (String)request.getServletContext().getAttribute("RedirectedFrom");
	
	redirectedFrom = redirectedFrom == null ? "" : redirectedFrom;

	String validationMessage = "";
	if(redirectedFrom.equals("LOGIN")) 
		validationMessage = (String)request.getServletContext().getAttribute("LoginValidationMessage");
	else if(redirectedFrom.equals("LOGIN"))
		validationMessage = (String)request.getServletContext().getAttribute("RegisterValidationMessage");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>WebForum | Official page</title>
		
		<link rel="stylesheet" href="css/atom.css" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" href="css/fontLoader.css" />
		
		<link rel="stylesheet" href="css/default.css" />
		<link rel="stylesheet" href="css/account.css" />
		
		<script src="scripts/jquery-3.2.1.min.js"></script>
		<script src="scripts/account.js"></script>
	</head>
	<body>
		<form id="loginForm" class="accountForm fullCenter" method="POST" action="/WebProjekat/LoginServlet"
		<% if(redirectedFrom == "REGISTER") {%> style="display: none;" <%}%>>
			<h1>Log in</h1>
			<input id="usernameLogin" class="boxSizing" name="username" type="text" placeholder="Username..." />
			<input id="passwordLogin" class="boxSizing" name="password" type="password" placeholder="Password..." />
			
			<label>
				<input name="rememberMe" type="checkbox" /> Remember me
			</label>
			
			<div class="validationSummary"><% if(redirectedFrom == "LOGIN") {%> <%= validationMessage %> <%}%></div>
			
			<button id="loginButton" class="btn green boxSizing">Log in</button>
			<a id="switchToRegistration" class="formSwitchLink" href="javascript:;">Don't have an account? - Register</a>
		</form>
		
		<form id="registerForm" class="accountForm fullCenter" method="POST"
		action="/WebProjekat/RegisterServlet"
		<% if(redirectedFrom == "LOGIN" || redirectedFrom == "") {%> style="display: none;" <%}%>>
			<h1>Register</h1>
			<input id="firstNameRegister" class="boxSizing" name="firstName" type="text" placeholder="First name..." /> 
			<input id="lastNameRegister" class="boxSizing" name="lastName" type="text" placeholder="Last name..." />
			<input id="usernameRegister" class="boxSizing" name="username" type="text" placeholder="Usernname..." />
			<input id="emailRegister" class="boxSizing" name="email" type="text" placeholder="Email..." />
			<input id="passwordRegister" class="boxSizing" name="password" type="password" placeholder="Password..." />
			<input id="repeatPasswordRegister" class="boxSizing" type="password" placeholder="Repeat password..." />
			
			<div class="validationSummary"><% if(redirectedFrom == "REGISTER") {%> <%= validationMessage %> <%}%></div>
			
			<button id="registerButton" class="btn green boxSizing">Register</button>
			<a id="switchToLogin" class="formSwitchLink" href="javascript:;">Already have an account? - Log in</a>
		</form>
	</body>
</html>