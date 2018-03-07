/*adding onclick event to the radio button*/
js("input[name='radio']").on('click', function () {
	show(this.getAttribute('data-id'));
});

/* method to show or alert the value of select tag with respect to radio button*/
function show(id){
	alert(document.querySelector(id).value);
}