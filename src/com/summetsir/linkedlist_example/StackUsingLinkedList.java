package com.summetsir.linkedlist_example;

public class StackUsingLinkedList {
    Node head;
    Node tail;
    int size ;
    public boolean isEmpty(){
        return tail == null;
    }
    public boolean isSingle(){
        return head == tail;
    }

    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    public int pop(){
        int data = head.data;
        if(isEmpty()){
            return -1;
        }
        if(isSingle()){
            head = tail = null;
        }
        else{
            Node temp = head;
            head = head.next;
            temp = null;
        }
        size--;
        return data;
    }
    public int peek(){
        return head.data;
    }

    public void display(){
        Node tempNode = head;
        while(tempNode != tail){
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.data + "->null");
    }

}
