class Node {
	
	constructor (data, n){
		this.data = data
		this.prevLink = n;
		this.nextLink = n;
	}
	
	getNextLink () {
		return this.nextLink;
	}
	
	getPrevLink () {
		return this.prevLink;
	}
	
	setNextLink (link) {
		this.nextLink = link;
	}
	
	setPrevLink (link) {
		this.prevLink = link;
	}
	
	getData () {
		return this.data;
	}
	
	setData (data) {
		this.data = data;
	}
}

class LinkedList {
	
	constructor () {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	insertAtStart (val) {
        var nptr = new Node(val, null, null);    
        this.size++ ;  
        
		if (this.start == null) {
            this.start = nptr;
            this.end = this.start;
			
        } else {
            nptr.setNextLink (this.start);
			this.start.setPrevLink (nptr);
            this.start = nptr;
        }
    }
	
	insertAtEnd (val) {
        var nptr = new Node (val, null, null);    
        this.size++ ;    
        
		if (this.start == null) {
            this.start = nptr;
            this.end = this.start;
			
        } else {
			nptr.setPrevLink (this.end);
            this.end.setNextLink (nptr);
            this.end = nptr;
        }
    }
	
	append (val) {
		this.insertAtEnd (val);
	}
	
	insertAtPosition (val, pos) {
		
		if (pos == 1) {
			this.insertAtStart (val);
			return;
			
		} else if ( pos == this.size + 1) {
			this.insertAtEnd (val);
			return;
		}
        var nptr = new Node (val, null, null);                
        var ptr = this.start;
        pos = pos - 1 ;
        for (var i = 1; i < this.size; i++) {
            if (i == pos) {
                var tmp = ptr.getNextLink() ;
                ptr.setNextLink (nptr);
                nptr.setPrevLink (ptr);
                nptr.setNextLink (tmp);
				tmp.setPrevLink (nptr);
                break;
            }
            ptr = ptr.getNextLink();
        }
        this.size++ ;
    }
	
	deleteAtPosition (pos) {        
        
		if (pos == 1) {
            this.start = this.start.getNextLink();
			this.start.setPrevLink (null);
            this.size--; 
            return ;
        }
        
		if (pos == this.size) {
            this.end = this.end.getPrevLink();
			this.end.setNextLink (null);
			this.size--; 
			return;
        }
        var ptr = this.start;
        pos = pos - 1 ;
        
		for (var i = 1; i < this.size - 1; i++) {
            
			if (i == pos) {
                var tmp = ptr.getNextLink ();
				ptr.setNextLink ( tmp.getNextLink() );
				tmp = tmp.getNextLink ();
				tmp.setPrevLink (ptr);
                break;
            }
            ptr = ptr.getNextLink();
        }
        this.size-- ;
    }
	
	display () {
		
		if (this.size != 0) {
			var ptr = this.start;
			
			while ( ptr.getNextLink() != null) {
				alert ( ptr.getData() );
				ptr = ptr.getNextLink ();
			}
			alert ( ptr.getData() + " " + this.size );
		} 
	}
	
	displayReverse () {
		
		if (this.size != 0) {
			var ptr = this.end;
			
			while (ptr.getPrevLink() != null) {
				alert ( ptr.getData() );
				ptr = ptr.getPrevLink ();
			}
			alert ( ptr.getData () + " " + this.size );
		}
	}
}