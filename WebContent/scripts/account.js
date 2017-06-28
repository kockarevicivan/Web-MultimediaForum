$(document).ready(function() {
	$('#switchToRegistration').on('click', function() {
		switchToRegistration();
	});

	$('#switchToLogin').on('click', function() {
		switchToLogin();
	});
	
	$('#loginForm').on('submit', function(e) {
		if(!validateLogin()){}
			//e.preventDefault();
	});
	
	$('#registerForm').on('submit', function(e) {
		if(!validateRegister()){}
			//e.preventDefault();
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
		message = 'Username polje prazno!';
	}
	else if(!$('#passwordLogin').val().length) {
		valid = false;
		message = 'Lozinka polje prazno!';
	}
	
	if(message.length)
		indicateValidationError(message);
	
	return valid;
}

function validateRegister() {
	var valid = true;
	var message = "";

	if(!$('#firstNameRegister').val().length) {
		valid = false;
		message = 'Ime polje prazno!';
	}
	else if(!$('#lastNameRegister').val().length) {
		valid = false;
		message = 'Prezime polje prazno!';
	}
	else if(!$('#usernameRegister').val().length) {
		valid = false;
		message = 'Username polje prazno!';
	}
	else if(!$('#emailRegister').val().length) {
		valid = false;
		message = 'Email polje prazno!';
	}
	else if(!$('#passwordRegister').val().length) {
		valid = false;
		message = 'Lozinka polje prazno!';
	}
	else if(!$('#repeatPasswordRegister').val().length) {
		valid = false;
		message = 'Ponovi lozinku polje prazno!';
	}
	else if($('#passwordRegister').val() != $('#repeatPasswordRegister').val()) {
		valid = false;
		message = 'Lozinke se ne poklapaju!';
	}
	
	if(message.length)
		indicateValidationError(message);
	
	return valid;
}

function indicateValidationError(message) {
	alert(message);
}
