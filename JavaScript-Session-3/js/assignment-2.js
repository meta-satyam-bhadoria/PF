var first = "";
var second = "";

/* adding onclick event to the radio button with name first */
js( "input[name='first']" ).on ('click', function () {
	first = this.value;
	show();
});

/* adding onclick event to the radio button with name second */
js( "input[name='second']" ).on ('click', function () {
	second = this.value;
	show ();
});

/*function to show the different messages in each combination*/
var show = function () {
	alert(first + " " + second);
};