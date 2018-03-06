var list = new LinkedList();
list.insertAtStart (3);
list.append (4);
list.insertAtEnd (8);
list.insertAtStart (5);
list.deleteAtPosition (2);
console.log( list.getList() );