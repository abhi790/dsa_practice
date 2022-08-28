package com.summetsir.linkedlist_example;

public class QueueUsingLinkedList {
    Node head;
    Node tail;
    int size;
    public boolean isEmpty(){
        return head == null;
    }
    public boolean isSingleNode(){
        return head == tail;
    }
    //addlast
    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
        }

        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    //remove first
    public int pop(){
        if(isEmpty())return -1;
        int data = head.data;
        if(isSingleNode()){
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

    //get first
    public int top(){
        return  head.data;
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
