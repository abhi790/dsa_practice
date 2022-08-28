package com.sandeepjain.basic.linkedlist.doubly_linkedlist;

public class DoublyLinkedlist {
    Node head;
    Node tail;
    int size;
    //some private method for utility method
    private boolean isEmpty(){
        return this.head == null;
    }
    private boolean isSingleNode(){
        return this.head == this.tail;
    }

    //adding element
    //addFirst--- two type 1.before head,2.after head
    public Node addBeforeHead(DoublyLinkedlist list, int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            list.head = list.tail = newNode;
        }
        else{
            newNode.next = list.head;
            list.head.pre = newNode;
            list.head = newNode;
        }
        list.size++;
        return list.head;
    }
    public Node addAfterHead(DoublyLinkedlist list, int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            list.head = list.tail = newNode;
        }
        else{
            newNode.next = list.head.next;
            newNode.pre = head;
            list.head.next.pre = newNode;
            list.head.next = newNode;
        }
        list.size++;
        return list.head;
    }
    //addLast--- two type 1.before head,2.after head
    public Node addBeforeTail(DoublyLinkedlist list, int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            list.head = list.tail = newNode;
        }
        else{
            newNode.next = list.tail;
            newNode.pre = list.tail.pre;
            list.tail.pre.next = newNode;
            list.tail.pre = newNode;

        }
        list.size++;
        return list.head;
    }
    public Node addAfterTail(DoublyLinkedlist list, int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            list.head = list.tail = newNode;
        }
        else{
            newNode.pre = list.tail;
            list.tail.next = newNode;
            list.tail = newNode;

        }
        list.size++;
        return list.head;
    }

    public Node addAt(DoublyLinkedlist list, int index, int data){

        return list.head;
    }
    //add node in sorted doubly linked list
    public Node addNodeInSortedList(DoublyLinkedlist list, int data){
        Node newNode = new Node(data);
        //if empty list is passed
        if(isEmpty()){
            list.head = newNode;
            return list.head;
        }
        Node curr = list.head;
        Node prev = curr;
        while(curr != null){
            if(curr.data < data){
                prev = curr;
                curr = curr.next;
            }
            else {
                break;
            }
        }
        prev.next = newNode;
        newNode.next = curr;

        return list.head;
    }


    //removing element
    public Node removeAfterHead(DoublyLinkedlist list){
        if(isEmpty()){
            return list.head;
        }
        else if(isSingleNode()){
            list.head = list.tail = null;
        }
        else{
            Node temp = list.head;
            temp = temp.next.next;
            list.head.next = temp;
            temp.pre = head;
        }
        list.size--;
        return list.head;
    }
    public Node removeAtHead(DoublyLinkedlist list){
        if(isEmpty()){
            return list.head;
        }
        else if(isSingleNode()){
            list.head = list.tail = null;
        }
        else{
            Node temp = list.head;
            temp = temp.next;
            temp.pre = null;
            list.head.next = null;
            head = temp;
        }
        list.size--;
        return list.head;
    }
    public Node removeBeforeTail(DoublyLinkedlist list){
        if(isEmpty()){
            return list.head;
        }
        else if(isSingleNode()){
            list.head = list.tail = null;
        }
        else{
            Node temp = list.tail;
            temp = temp.pre.pre;
            temp.next = tail;
            list.tail.pre.next = null;
            temp.next.pre = null;
            list.tail.pre = temp;
        }

        list.size--;
        return list.head;
    }
    public Node removeAtTail(DoublyLinkedlist list){
        if(isEmpty()){
            return list.head;
        }
        else if(isSingleNode()){
            list.head = list.tail = null;
        }
        else{
            list.tail = list.tail.pre;
            list.tail.next = null;
        }

        list.size--;
        return list.head;
    }
    public Node removeAt(DoublyLinkedlist list,int index){

        list.size--;
        return list.head;
    }

    //displaying element
    public void printListForward(DoublyLinkedlist list){
        if(list.isEmpty())
            return;
        Node temp = list.head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void printListBackward(DoublyLinkedlist list){
        if(list.isEmpty())
            return;
        Node temp = list.tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.pre;
        }
        System.out.println();
    }

    //
}
