var list = new LinkedList();
list.insertAtStart (3);
list.insertAtEnd (4);
list.insertAtEnd (6);
list.insertAtPosition (5, 5);
console.log ( list.getList() );
list.deleteAtPosition (6);
console.log ( list.getListInReverseOrder() );