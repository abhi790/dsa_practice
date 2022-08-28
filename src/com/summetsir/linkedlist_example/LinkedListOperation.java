package com.summetsir.linkedlist_example;

public class LinkedListOperation {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        //add node at the tail of the list
        list.addLast(10);list.addLast(20);list.addLast(30);list.addLast(40);
//        list.showList();
//        //add node before the head node
//        list.addFirst(100);list.addFirst(200);list.addFirst(300);list.addFirst(400);
//        list.showList();
//        //remove node at the tail of the list
//        list.removeLast();list.removeLast();list.removeLast();
//        list.showList();
//        //remove node at the head of the list
//        list.removeFirst();list.removeFirst();list.removeFirst();list.removeFirst();
//        list.showList();

//        //add node at any valid position of the list
        list.addAnyPos(1,111);
//        list.showList();
        list.addAnyPos(list.size + 1,999);
        list.addAnyPos(list.size + 1,999);
//        list.showList();
        list.addAnyPos(5,222);
        list.showList();

//        //remove node at any valid position of the list
//        list.removeAnyPos(1);
//        list.showList();
//        list.removeAnyPos(6);
//        list.showList();
//        list.removeAnyPos(3);
//        list.showList();

//        //get value at any pos
//        System.out.println(list.getValue(10));
//        System.out.println(list.getValue(-5));

//        //Kth element from the end of the list
//        for(int i = 0; i < 9; i++)
//            System.out.println(list.getKthFromEnd(i));

//        //get the middle node value
//        System.out.println(list.getTheMidNodeValue());



    }
}
