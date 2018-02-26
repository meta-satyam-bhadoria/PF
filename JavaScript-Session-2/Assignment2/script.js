var string = prompt ("Enter any string");
alert ( remove(string) );

/*method to remove consecutive repeated sub string*/
function remove (string) {
	console.log (string);
	var i = 0;
	
	while ( i < string.length - 1) {
		var c = i + 1;
		
		while ( string[i] == string[c] ) {
			c++;
			if (c == string.length){
				break;
			}
		}
		
		if (c != i + 1){
			return remove ( string.substr(0,i) + string.substr(c) );
		}
		i++;
	}
	return string;
}