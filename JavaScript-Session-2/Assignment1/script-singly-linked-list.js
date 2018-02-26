class Node {
	
	constructor (data, link) {
		this.data = data
		this.next = link;
	}
	
	getNext () {
		return this.next;
	}
	
	setNext (link) {
		this.next = link;
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
	
	insertAtStart (val){
        var newLink = new Node (val, null);    
        this.size++ ;  
		
        if (this.start == null) {
            this.start = newLink;
            this.end = this.start;
			
        } else {
            newLink.setNext (this.start);
            this.start = newLink;
        }
    }
	
	insertAtEnd (val) {
        var newLink = new Node (val,null);    
        this.size++ ;    
        
		if (this.start == null) {
            this.start = newLink;
            this.end = this.start;
        } else {
            this.end.setNext (newLink);
            this.end = newLink;
        }
    }
	
	append (val){
		this.insertAtEnd (val);
	}
	
	insertAtPosition (val, pos) {
		if (pos == 1) {
			this.insertAtStart(val);
			return;
			
		} else if (pos == this.size + 1) {
			this.insertAtEnd(val);
			return;
		}
        var newLink = new Node (val, null);                
        var ptr = this.start;
        pos = pos - 1 ;
        
		for (var i = 1; i < this.size; i++) {
            
			if (i == pos) {
                var tmp = ptr.getNext () ;
                ptr.setNext (newLink);
                newLink.setNext (tmp);
                break;
            }
            ptr = ptr.getNext ();
        }
        this.size++ ;
    }
	
	deleteAtPosition (pos) {        
        
		if (pos == 1) {
            this.start = this.start.getNext();
			
        } else if (pos == this.size) {
            var s = this.start;
            var t = this.start;
            
			while (s != this.end) {
                t = s;
                s = s.getNext ();
            }
            this.end = t;
            this.end.setNext (null);
			
        } else {
			var ptr = this.start;
			pos = pos - 1 ;
			
			for (var i = 1; i < this.size - 1; i++) {
				
				if (i == pos) {
					var tmp = ptr.getNext ();
					tmp = tmp.getNext ();
					ptr.setNext (tmp);
					break;
				}
				ptr = ptr.getNext ();
			}
		}
        this.size-- ;
    }
	
	display () {
		var ptr = this.start;
		while (ptr != null) {
			console.log ( ptr.getData() );
			ptr = ptr.getNext ();
		}
	}
	
	getList () {
		var ptr = this.start;
		var arr = [];
		var i = 0;
		while (ptr != null) {
			arr.push ( ptr.getData() );
			ptr = ptr.getNext ();
		}
		return arr;
	}
}