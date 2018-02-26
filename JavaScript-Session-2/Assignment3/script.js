function Node (val) {
	var data = val;
	var next = null;
	var nextLink = function (link){
		next = link;
		demo();
	}
	function demo(){
		alert(next.getData);
	}
	
	return {
		getNext : next,
		getData : data,
		setNext : function (link) { this.nextLink(link); },
		setData : function (val) { data = val; }
	}
}

function Queue() {
	var front = null,
		rear = null,
		size = 20,
		length = 0;
	
	var enqueue = function (val) {
		var link = Node(val);
		
        if(isEmpty()){
			front = link;
			rear = front;
			length++;
			
		} else if(isFull()){
			alert("queue full");
			return;
			
		} else {
			rear.setNext(link);
			alert(front.getNext+" "+rear.getNext+" "+rear.getData);
			rear = link;
			var ptr = front;
			while(ptr != null) {
				alert ( ptr.getData );
				ptr = ptr.getNext;
			}
			
			length++;
		}
    }
	
	var dequeue = function () {
		if(isEmpty()){
			alert("queue empty");
		} else{
			front = front.getNext;
			length--;
		}
    }
	
	var isEmpty = function (){
		return front == null;
	}
	
	var isFull = function (){
		return length == size;
	}
	
	var getList = function (){
		var ptr = front;
		var array = [];
		while(ptr != null) {
			array.push ( ptr.getData );
			ptr = ptr.getNext;
		}
		return array;
	}
	
	return {
		enqueue : function (val) { enqueue (val); },
		dequeue : function () { dequeue(); },
		getList : function () { return getList(); }
	}
	
}

/*class Queue{
	
	constructor(){
		this.front = null;
		this.rear = null;
		this.size = 20;
		this.length = 0;
	}
	
	enqueue(val) {
		var link = Node(val);
		alert(link.getData);
        if(this.isEmpty()){
			this.front = link;
			this.rear = link;
			this.length++;
			
		} else if(this.isFull()){
			alert("queue full");
			return;
			
		} else {
			this.rear.setNext(link);
			this.rear = link;
			this.length++;
		}
    }
	
	dequeue() {
		if(this.isEmpty()){
			alert("queue empty");
		} else{
			this.front = front.getNext;
			this.length--;
		}
    }
	
	isEmpty(){
		return this.front == null;
	}
	
	isFull(){
		return this.length == this.size;
	}
	
	getList(){
		var ptr = this.front;
		var array = [];
		while(ptr != null) {
			array.push ( ptr.getData );
			ptr = ptr.getNext;
		}
		return array;
	}
}*/