var name = false;
var email = false;
var organization = false;
var contact = false;
var city = false;

/*method for validating form and return true if validations are true else false*/
function validateSubmit(){
	return (name && email && orgnization && contact && city);
}

/* method for validating name*/
function validateName(value){
	var pattern = /^[a-zA-Z\s]{0,20}$/;
	if(pattern.test(value)){
		document.getElementById('name').innerHTML = "";
		name = true;
	}
	else{
		name = false;
		document.getElementById('name').innerHTML = "enter only characters and should not be more than 20 characters";
	}
}

/*method for validating email*/
function validateEmail(value){
	var pattern = /^([a-zA-Z\.-]+)(@)([a-zA-Z]+)([\.])([a-zA-Z\.]+)$/;
	if(pattern.test(value)){
		document.getElementById('email').innerHTML = "";
		email = true;
	}
	else{
		email = false;
		document.getElementById('email').innerHTML = "enter valid email id";
	}
}

/*method for validating dropdown*/
function validateSelect(value){
	if(value.length > 0){
		document.getElementById('city').innerHTML = "you have selected this city : "+value;
		city = true;
	}
}

/*method for validating organization*/
function validateOrganization(value){
	var pattern = /^[a-zA-Z\s]+$/;
	if(pattern.test(value)){
		document.getElementById('organization').innerHTML = "";
		organization = true;
	}
	else{
		organization = false;
		document.getElementById('organization').innerHTML = "enter only characters";
	}
}

/*method for validating contact*/
function validateContact(value){
	var pattern = /^([1-9]{1})([0-9]{9})$/;
	if(pattern.test(value)){
		document.getElementById('contact').innerHTML = "";
		contact = true;
	}
	else{
		contact = false;
		document.getElementById('contact').innerHTML = "enter valid phone number";
	}
}

/*method for validating textarea*/
function validateTextarea(value){
	if(value.length > 250) {
		value = value.substring(0,250);
		document.getElementById('textarea').value = value;
		
	}
}