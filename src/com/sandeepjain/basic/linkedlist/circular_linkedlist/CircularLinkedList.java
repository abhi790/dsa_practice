package com.sandeepjain.basic.linkedlist.circular_linkedlist;

public class CircularLinkedList {
    Node head;
    Node tail;
    int size;
    //some private method for personal use
    private boolean isEmpty(){
        return head == null;
    }
    //adding element in the list
    public Node addLast(CircularLinkedList list,int data){
        //create a new node
        Node newNode = new Node(data);
        newNode.next = list.head;

        if(list.isEmpty()){
            list.head = list.tail = newNode;
        }
        else{
            list.tail.next = newNode;
            list.tail = newNode;
        }
       // list.tail.next = head; //pointing last node to first node
        list.size++;
        return list.head;
    }
    public Node addFirst(CircularLinkedList list, int data){
        //create a new node
        Node newNode = new Node(data);
        newNode.next = list.head;
        if(list.isEmpty()){
            list.head = list.tail = newNode;
        }
        else{
            list.tail.next = newNode;
            list.head = newNode;
        }
        list.size++;
        return list.head;
    }
    //removing element from the list

    //traversing the list
    public void traverseList(Node head){
        if(head == null) return;
        System.out.print(head.data + " ");
        while(head.next != head){
            System.out.println(head.next.data + " ");
            head = head.next;
        }
    }
    public void traverseListRecursive(Node head){
        if(head == null) return;
        System.out.print(head.data + " ");
        if(head.next == head)
                return;
        traverseListRecursive(head.next);
    }
    //
}
