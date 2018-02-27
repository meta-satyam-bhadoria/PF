/**
 * class used to create stack and performing operation like push and pop
 */
class Stack{
	
	constructor () {
		this.stack = [];
		this.top = 0;
		this.max = 20;
	}
	
	/* getter to return the stack*/
	get getList () {
		return this.stack;
	}
}

/* method to pop the top most element from stack*/
Stack.prototype.pop = function () {
		
		if(this.top < 0){
			alert("stack underflow");
			
		} else{
			this.stack.splice(this.top - 1 , 1);
			this.top--;
		}
	}
	
/* method for push the element onto the stack*/
Stack.prototype.push = function (item) {
	
	if(this.top > this.max){
		alert("stack overflow");
		
	} else{
		this.stack[this.top++] = item;
	}
}