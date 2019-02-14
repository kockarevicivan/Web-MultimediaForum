$(document).ready(function() {
	$('#switchToRegistration').on('click', function() {
		switchToRegistration();
	});

	$('#switchToLogin').on('click', function() {
		switchToLogin();
	});
	
	$('#loginForm').on('submit', function(e) {
		if(!validateLogin())
			e.preventDefault();
	});
	
	$('#registerForm').on('submit', function(e) {
		if(!validateRegister())
			e.preventDefault();
	});
});

function switchToRegistration() {
	$('#loginForm').fadeOut(200);
	$('#registerForm').fadeIn(200);
}

function switchToLogin() {
	$('#registerForm').fadeOut(200);
	$('#loginForm').fadeIn(200);
}

function validateLogin() {
	var valid = true;
	var message = "";
	
	if(!$('#usernameLogin').val().length) {
		valid = false;
		message = 'Username is mandatory!';
	}
	else if(!$('#passwordLogin').val().length) {
		valid = false;
		message = 'Password is mandatory!';
	}
	
	if(message.length)
		indicateLoginValidationError(message);
	
	return valid;
}

function validateRegister() {
	var valid = true;
	var message = "";

	if(!$('#firstNameRegister').val().length) {
		valid = false;
		message = 'First name is mandatory!';
	}
	else if(!$('#lastNameRegister').val().length) {
		valid = false;
		message = 'Last name is mandatory!';
	}
	else if(!$('#usernameRegister').val().length) {
		valid = false;
		message = 'Username is mandatory!';
	}
	else if(!$('#emailRegister').val().length) {
		valid = false;
		message = 'Email is mandatory!';
	}
	else if(!$('#passwordRegister').val().length) {
		valid = false;
		message = 'Password is mandatory!';
	}
	else if(!$('#repeatPasswordRegister').val().length) {
		valid = false;
		message = 'Password repeat is mandatory!';
	}
	else if($('#passwordRegister').val() != $('#repeatPasswordRegister').val()) {
		valid = false;
		message = 'Passwords don\'t match!';
	}
	
	if(message.length)
		indicateRegisterValidationError(message);
	
	return valid;
}

function indicateLoginValidationError(message) {
	$('#loginForm .validationSummary').html(message);
}

function indicateRegisterValidationError(message) {
	$('#registerForm .validationSummary').html(message);
}