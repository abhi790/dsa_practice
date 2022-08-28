package com.youtube_robedwards.linkedlist;


import java.util.ListIterator;

public class LinkedList<E>  {
    class Node<E>{
        E data;
        Node<E> next;
        public Node(E obj){
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    //construct a linkedlist
    public LinkedList(){
        head = null;
        tail = null;
        currentSize = 0;
    }

    //add element at the head of the list O(1) time complexity
    public void addFirst(E obj){
        Node<E> newNode = new Node<>(obj);
        currentSize++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //add element at the end of the list O(1) time complexity
    public void addLast(E obj){
        Node<E> newNode = new Node<>(obj);
        currentSize++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    //remove first O(1) time complexity
    public E removeFirst() throws EmptyListException {
        if(head == null)
            throw new EmptyListException("Can't remove, Empty list");

        currentSize--;
        E temp = head.data;
        //if the list has single node
        if(head == tail)
            head = tail = null;
        else
            head = head.next;
       return temp;
    }

    //remove last O(N)
    public E removeLast() throws  EmptyListException{
        if(head == null) throw new EmptyListException("List is empty");
        currentSize--;
        E value = head.data;
        if(head == tail){
            head = tail = null;
            return value;
        }
        Node<E> temp = head;
        value = tail.data;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;

        return value;
    }

    //remove from middle O(N)
    public E remove(E obj) throws EmptyListException {
        Node<E> current = head, previous = null;
        while(current != null){
            if(((Comparable<E>)obj).compareTo(current.data) == 0){
                if(current == head)
                    return removeFirst();
                //optional checks not required to do
                else if(current == tail)
                    return removeLast();
                currentSize--;
                previous.next = current.next;
                return obj;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    //contains to check the presence of the element E in the list
    public boolean contains(E obj){
        Node<E> current = head;
        while(current != null){
            if(((Comparable<E>)obj).compareTo(current.data) == 0)
                return true;

            current = current.next;
        }
        return false;
    }

    //just for fun
    public void fun(){
        int[] arr = {1,3,4,5,8,9};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int x : arr){
            System.out.println(x);
        }
    }
}
