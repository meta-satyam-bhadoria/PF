var name = false;
var email = false;
var city = false;
var organization = false;
var contact = false;
function validateSubmit(){
	validateName(document.querySelector('#user-name').value);
	validateEmail(document.querySelector('#user-email').value);
	validateCity(document.querySelector('#user-email').value);
	validateOrganization(document.querySelector('#user-organization').value);
	validateContact(document.querySelector('#user-contact').value);
	//return (name && email && city && orgnization && contact);
	return false;
}

function validateName(value){
	var pattern = /^[a-zA-Z\s]{1,20}$/;
	if(pattern.test(value)){
		name = true;
	}
	else{
		name = false;
		document.getElementById('name').innerHTML = "Enter only characters and should not be more than 20 characters";
	}
}

function validateEmail(value){
	var pattern = /^([a-zA-Z\.-]+)(@)([a-zA-Z]+)([\.])([a-zA-Z\.]+)$/;
	if(pattern.test(value)){
		email = true;
	}
	else{
		email = false;
		document.getElementById('email').innerHTML = "Enter valid email id";
	}
}

function validateCity(value){
	if(value.length > 0){
		city = true;
		document.getElementById('city').innerHTML = "You have selected this city : "+value;
	} else{
		city = false;
		document.getElementById('city').innerHTML = "Select any city";
	}
}

function validateOrganization(value){
	var pattern = /^[a-zA-Z\s]{1,}$/;
	if(pattern.test(value)){
		organization = true;
	}
	else{
		organization = false;
		document.getElementById('organization').innerHTML = "Enter only characters";
	}
}

function validateContact(value){
	var pattern = /^([1-9]{1})([0-9]{9})$/;
	if(pattern.test(value)){
		contact = true;
	}
	else{
		contact = false;
		document.getElementById('contact').innerHTML = "Enter valid 10 digit phone number.";
	}
}

function validateTextarea(value){
	if(value.length > 250) {
		value = value.substring(0,250);
		document.getElementById('textarea').value = value;
	}
}