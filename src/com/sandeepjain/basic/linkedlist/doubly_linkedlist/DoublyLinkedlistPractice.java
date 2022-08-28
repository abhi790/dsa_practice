package com.sandeepjain.basic.linkedlist.doubly_linkedlist;

public class DoublyLinkedlistPractice {
    DoublyLinkedlist list = new DoublyLinkedlist();
    //Question 1 : add element in doubly linkedlist
    public void addElementHelper(){
        //add before the head
        list.addBeforeHead(list,199);
        list.addBeforeHead(list,299);
        list.printListForward(list);
        //add after the head
        list.addAfterHead(list,99);
        list.addAfterHead(list,88);
        list.printListForward(list);
        //add before the tail
        list.addBeforeTail(list,1999);
        list.addBeforeTail(list,2999);
        list.printListForward(list);
        //add after the tail
        list.addAfterTail(list,1000);
        list.addAfterTail(list,2000);
        list.printListForward(list);
//        list.printListBackward(list);
    }
    //Question 2 : remove element from doubly linkedlist
    public void removeElementHelper(){
        list.printListForward(list);
        list.removeAtHead(list);
        list.printListForward(list);
        list.removeAtTail(list);
        list.printListForward(list);
//        System.out.println(list.size);
        list.removeAfterHead(list);
        list.printListForward(list);
        list.removeBeforeTail(list);
//        System.out.println(list.size);
        list.printListForward(list);

    }

    public static void main(String[] args) {
        DoublyLinkedlistPractice solve = new DoublyLinkedlistPractice();
        //Question 1 : add element in doubly linkedlist
        solve.addElementHelper();
        //Question 2 : remove element from doubly linkedlist
        solve.removeElementHelper();
    }
}
