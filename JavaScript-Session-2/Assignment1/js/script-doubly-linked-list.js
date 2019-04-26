/**
 * this class creates the node or link 
 */
class Node {
	
	constructor (data){
		this.item = data
		this.prev = null;
		this.nextLink = null;
	}
	
	/*getter for returning next node*/
	get nextLink () {
		return this.next;
	}
	
	/*getter for returning previous node*/
	get prevLink () {
		return this.prev;
	}
	
	/*setter for setting next link or node*/
	set nextLink (link) {
		this.next = link;
	}
	
	/*setter for setting previous link or node*/
	set prevLink (link) {
		this.prev = link;
	}
	
	/*getter for returning data of particular node*/
	get data () {
		return this.item;
	}
	
	/* setter for inserting data to particular node*/
	set data (data) {
		this.item = data;
	}
}

/**
 * this class creates the doubly linked list and perform function
 * for inserting, deleting, searching an element
 */
class LinkedList {
	
	constructor () {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	/* method to insert an element at starting positionition*/
	insertAtStart (val) {
        var nptr = new Node (val);    
        this.size++ ;  
        
		if (this.start == null) {
            this.start = nptr;
            this.end = this.start;
			
        } else {
            nptr.nextLink = this.start;
			this.start.prevLink = nptr;
            this.start = nptr;
        }
    }
	
	/* method to insert an element at last positionition*/
	insertAtEnd (val) {
        var nptr = new Node (val);    
        this.size++ ;    
        
		if (this.start == null) {
            this.start = nptr;
            this.end = this.start;
			
        } else {
			nptr.prevLink = this.end;
            this.end.nextLink = nptr;
            this.end = nptr;
        }
    }
	
	/*method which appends the element at last*/
	append (val) {
		this.insertAtEnd (val);
	}
	
	/* method to insert an element at specified positionition*/
	insertAtPosition (position, val) {
		
		if (position == 1) {
			this.insertAtStart (val);
			
		} else if ( position == this.size + 1) {
			this.insertAtEnd (val);
			
		} else if (position > this.size + 1) {
			
			while( this.size != position - 1) {
				this.insertAtEnd(0);
			}
			this.insertAtEnd(val);
			this.size--;
			
		} else {
			var nptr = new Node (val);                
			var ptr = this.start;
			position = position - 1 ;
			
			for (var i = 1; i < this.size; i++) {
				if (i == position) {
					var tmp = ptr.nextLink ;
					ptr.nextLink = nptr;
					nptr.prevLink = ptr;
					nptr.nextLink = tmp;
					tmp.prevLink = nptr;
					break;
				}
				ptr = ptr.nextLink;
			}
		}
		this.size++ ;
    }
	
	/* method to delete an element at specified positionition*/
	deleteAtPosition (position) { 
		
		if(position > this.size) {
			alert("cannnot delete as index out of bound");
			return ;
		}
		
        if (this.size > 1) {
			if (position == 1) {
				this.start = this.start.nextLink;
				this.start.prevLink = null;
				
			} else if (position == this.size) {
				this.end = this.end.prevLink;
				this.end.nextLink = null;
				
			} else { 
				var ptr = this.start;
				position = position - 1 ;
				
				for (var i = 1; i < this.size - 1; i++) {
					
					if (i == position) {
						var tmp = ptr.nextLink;
						ptr.nextLink = tmp.nextLink;
						tmp = tmp.nextLink;
						tmp.prevLink = ptr;
						break;
					}
					ptr = ptr.nextLink;        
				}
			}
			
			this.size-- ;
			
		} else {
			this.start = null;
			this.end = null;
			this.size = 0;
		}
    }
	
	/*method which return the list as an array*/
	getList () {
		var ptr = this.start;
		var array = []
		while ( ptr != null) {
			array.push ( ptr.data );
			ptr = ptr.nextLink;
		}
		return array;
	}
	
	/*method which return the list as an array in reverse order*/
	getListInReverseOrder () {
		var ptr = this.end;
		var array = [];
		while (ptr != null) {
			array.push ( ptr.data );
			ptr = ptr.prevLink;
		}
		return  array;
	}
}