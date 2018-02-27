var string = prompt ("Enter any string");
alert ( "Resulted String is: " + remove(string, 0) );

/*method to remove consecutive repeated sub string*/
function remove (string, location) {
	console.log (string);
	var i = ( location >= 0 ) ? location : 0;
	
	while ( i < string.length - 1) {
		var c = i + 1;
		
		/*check for repeated string*/
		while ( string[i] == string[c] ) {
			c++;
			if (c == string.length){
				break;
			}
		}
		
		if (c != i + 1){
			return remove ( string.substr(0,i) + string.substr(c) , i - 1);
		}
		i++;
	}
	return string;
}