/**
 * class to create the node or link
 */
class Node {
	
	constructor (data) {
		this.item = data
		this.nextLink = null;
	}
	
	/*getter for returning next node*/
	get next () {
		return this.nextLink;
	}
	
	/*setter for setting next link or node*/
	set next (link) {
		this.nextLink = link;
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
 * this class creates the singly linked list and perform function
 * for inserting, deleting, searching an element
 */
class LinkedList {
	
	constructor () {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	/* method to insert an element at starting position*/
	insertAtStart (val){
        var newLink = new Node (val);    
        this.size++ ;  
		
        if (this.start == null) {
            this.start = newLink;
            this.end = this.start;
			
        } else {
            newLink.next = this.start;
            this.start = newLink;
        }
    }
	
	/* method to insert an element at last position*/
	insertAtEnd (val) {
        var newLink = new Node (val);    
        this.size++ ;    
        
		if (this.start == null) {
            this.start = newLink;
            this.end = this.start;
        } else {
            this.end.next = newLink;
            this.end = newLink;
        }
    }
	
	/*method which appends the element at last*/
	append (val){
		this.insertAtEnd (val);
	}
	
	/* method to insert an element at specified position*/
	insertAtPosition (val, pos) {
		if (pos == 1) {
			this.insertAtStart(val);
			return;
			
		} else if (pos == this.size + 1) {
			this.insertAtEnd(val);
			return;
		}
        var newLink = new Node (val);                
        var ptr = this.start;
        pos = pos - 1 ;
        
		for (var i = 1; i < this.size; i++) {
            
			if (i == pos) {
                var tmp = ptr.next ;
                ptr.next = newLink;
                newLink.next = tmp;
                break;
            }
            ptr = ptr.next;
        }
        this.size++ ;
    }
	
	/* method to delete an element at specified position*/
	deleteAtPosition (pos) {        
        
		if (pos == 1) {
            this.start = this.start.next;
			
        } else if (pos == this.size) {
            var s = this.start;
            var t = this.start;
            
			while (s != this.end) {
                t = s;
                s = s.next;
            }
            this.end = t;
            this.end.next = null;
			
        } else {
			var ptr = this.start;
			pos = pos - 1 ;
			
			for (var i = 1; i < this.size - 1; i++) {
				
				if (i == pos) {
					var tmp = ptr.next;
					tmp = tmp.next;
					ptr.next = tmp;
					break;
				}
				ptr = ptr.next;
			}
		}
        this.size-- ;
    }
	
	/*method which return the list as an array*/
	getList () {
		var ptr = this.start;
		var array = [];
		while (ptr != null) {
			array.push ( ptr.data );
			ptr = ptr.next;
		}
		return array;
	}
}