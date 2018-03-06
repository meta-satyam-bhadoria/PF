/**
 * class to create node
 */
class Node {
	
	constructor (val){
		this.data = val;
		this.next = null;
	}
	
	/* getter to get data*/
	get getData () {
		return this.data;
	}
	
	/* getter to get next node or link*/
	get nextLink () {
		return this.next;
	}
	
	/* setter to set next node or link*/
	set nextLink (link){
		this.next = link;
	}
}

/**
 * class to create queue and perform many operation like
 * enqueue and dequeue
 */
class Queue{
	
	constructor () {
		this.front = null;
		this.rear = null;
		this.size = 20;
		this.length = 0;
	}
	
	isEmpty () {
		return this.front == null;
	}
	
	isFull () {
		return this.length == this.size;
	}
	
	/* getter for returning the queue as an array*/
	get getList () {
		var ptr = this.front;
		var array = [];
		while ( ptr != null ) {
			array.push ( ptr.getData );
			ptr = ptr.nextLink;
		}
		return array;
	}
}

/* method for inserting data at the end of queue*/
Queue.prototype.enqueue = function (val) {
	var link = new Node (val);
	
	if ( this.isEmpty() ) {
		this.front = link;
		this.rear = link;
		this.length++;
		
	} else if (this.isFull() ) {
		alert("queue full");
		
	} else {
		this.rear.nextLink = link;
		this.rear = link;
		this.length++;
	}
}

/*method to remove element from the start of queue*/
Queue.prototype.dequeue = function () {
	if ( this.isEmpty() ) {
		alert("queue empty");
	} else {
		this.front = this.front.nextLink;
		this.length--;
	}
}