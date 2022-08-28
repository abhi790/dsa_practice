package com.sandeepjain.basic.linkedlist;

public class Linkedlist {
    Node head;
    Node tail;
    int size;
    ///few private utility method for program utilization
    private boolean isEmpty(){
        return head == null;
    }
    private boolean isSingleNode(){
        return head == tail;
    }


    ////{ Question 1 : adding element into the linkedlist
    public Linkedlist addFirst(Linkedlist list,int data){
        Node newNode = new Node(data);
        //if list is empty then first and last node are same
        if(isEmpty()){
            list.head = list.tail = newNode;
        }

        //else add node and modify head node
        else{
            newNode.next = list.head;
            list.head = newNode;
        }
        list.size++;
        return list;
    }
    public Linkedlist addLast(Linkedlist list,int data){
        Node newNode = new Node(data);
        //if list is empty then make first and last node same
        if(isEmpty()){
            list.head = list.tail = newNode;
        }

        //else add node and change the tail node
        else{
            list.tail.next = newNode;
            list.tail = newNode;
        }
        list.size++;
        return list;
    }
    public Linkedlist addAt(Linkedlist list,int index,int data){
        list.size++;
        return new Linkedlist();
    }
    ////} end of add methods of linkedlist

    ////{ Question 2 : removing element from the linkedlist
    public Linkedlist removeFirst(Linkedlist list){
        //if list is empty then nothing to remove simply return
        if(isEmpty()){
            return list;
        }

        //else if single node is present make head and tail to null
        else if(isSingleNode()){
            list.head = list.tail = null;
        }
        //move head one step in forward direction
        else{
            list.head = list.head.next;
        }
        list.size--;
        return list;
    }
    public Linkedlist removeLast(Linkedlist list){
        //if list is empty then nothing to remove simply return
        if(isEmpty()){
            return list;
        }
        //else if single node is present make head and tail to null
        else if(isSingleNode()){
            list.head = list.tail = null;
        }
        //move tail one step in backward direction
        else{
            Node temp = list.head;
            while(temp.next != list.tail){
                temp = temp.next;
            }
            temp.next = null;
            list.tail = temp;
        }
        list.size--;
        return list;
    }
    public Linkedlist removeAt(Linkedlist list,int index){
            list.size--;
            return new Linkedlist();
    }
    ////} end of remove methods of linkedlist


    ////{ Question 3 : display linked list, 1.iterative and 2.recursive
    //1.Iterative solution better than recursive solution in terms of space
    public void displayList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    //2.recursive solution
    public void displayListRecursive(Node head){
        if(head == null)
            return;

        System.out.print(head.data + " ");
        displayListRecursive(head.next);
    }
    ////} end of display function(two method discussed)

    ////{searching a key in linked list and return the position if not then return -1
    public int searchValue(Linkedlist list, int key){
        Node temp = list.head; int ans = -1; int count = 0;
        while(temp != null){
            count++;
            if(temp.data == key){
                ans = count;
                break;
            }
            temp = temp.next;
        }
        return ans;
    }
    public int searchValueRecursive(Node node, int key, int count){
        if(node == null)
            return -1;
        if(node.data == key)
            return count + 1;
       return searchValueRecursive(node.next,key,count+1);
    }
}
