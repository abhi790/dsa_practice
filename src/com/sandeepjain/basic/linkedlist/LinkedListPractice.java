package com.sandeepjain.basic.linkedlist;

public class LinkedListPractice {

    ////{Question 1 : adding element into the linked list
    public void addElementHelper(Linkedlist list){
        list.addFirst(list,100);
        list.addFirst(list,200);
        list.addLast(list,300);
        list.addFirst(list,700);
        list.addFirst(list,800);
        list.addLast(list,9000);
        list.addFirst(list,12);
        list.addFirst(list,23);
        list.addLast(list,15);
        list.displayList(list.head);
        System.out.println(list.size);
    }

    ////{Question 2 : removing element from the linked list
    public void removeElementHelper(Linkedlist list){
        list.removeFirst(list);
        list.displayList(list.head);
        list.removeLast(list);
        list.displayList(list.head);

    }
    ////{Question 3 : displaying element
    public void displayHelper(Linkedlist list){
        list.displayList(list.head);
        list.displayListRecursive(list.head);
        System.out.println();
    }
    ////{Question 4 : searching a key in the linkedlist
    public void searchElementHelper(Linkedlist list){
        int elementToSearch = 301;
        System.out.println("Item found at : " + list.searchValue(list,elementToSearch));
        System.out.println("Item found at : " + list.searchValueRecursive(list.head,elementToSearch,0));

    }

    //Driver code
    public static void main(String[] args) {
        LinkedListPractice solve = new LinkedListPractice();
        Linkedlist list = new Linkedlist();
        ////{Question 1 : adding element into the linked list
        solve.addElementHelper(list);
        ////{Question 2 : removing element from the linked list
        solve.removeElementHelper(list);
        ////{Question 3 : displaying element
        solve.displayHelper(list);
        ////{Question 4 : searching a key in the linkedlist
        solve.searchElementHelper(list);
        ////{Question 5 :

    }

}
