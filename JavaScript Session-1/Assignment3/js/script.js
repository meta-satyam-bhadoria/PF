displayThumbnail ();

var btn = document.querySelector ('.dark');

/*adding onclick function to button*/
btn.onclick = function () {
	if ( btn.getAttribute ('class') == 'dark'){
		btn.setAttribute ('class', 'light');
		btn.textContent = 'Lighten';
		document.querySelector ('.overlay').style.background = 'rgba(0,0,0,.5)';
	} else{
		btn.setAttribute ('class', 'dark');
		btn.textContent = 'Darken';
		document.querySelector ('.overlay').style.background = 'rgba(0,0,0,0)';
	}
}

/*looping for thumb-bar*/
function displayThumbnail () {
	var div = document.querySelector ('#thumb-bar');
	for (var i = 1;i <= 5; i++) {
		var image = document.createElement ("img");
		image.setAttribute ('src', 'images/pic'+i+'.jpg');
		div.append (image);
		image.onclick = function (e) {
			var source = e.target.getAttribute ('src');
			showImage (source);
		}
	}
}

/*displayed image*/
function showImage (source) {
	var x = document.querySelector ('#displayed-img');
	x.setAttribute ('src',source);
}