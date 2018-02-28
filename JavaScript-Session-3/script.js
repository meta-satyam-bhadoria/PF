/* Method to bind events to the selectors */
window.js = function(selector,cb) {
	
	var selectors = document.querySelectorAll(selector);
	
	/* method to add events to each selector*/
	function onEvent(event, cb) {
		selectors.forEach(function(selector){
			selector.addEventListener(event, cb);
		});
	};
	
    /* Return our own api that uses the onEvent function to act on our selected list.*/
    return {
		on: function (event, func) {
			onEvent (event, func);
		}
	}
};