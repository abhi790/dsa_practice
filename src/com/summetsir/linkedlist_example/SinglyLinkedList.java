package com.summetsir.linkedlist_example;

public class SinglyLinkedList {
    Node head;
    Node tail;
    int size;
    public SinglyLinkedList(){

    }

    public  boolean isEmpty(){
        return head == null;
    }
    //get node at index
    public Node getNodeAt(int index){
        int count = 0;
        Node temp = head;
        while(count < index){
            temp = temp.next;
            count++;
        }

        return temp;
    }
    //get method
    public int getValue(int index){
        if(index < 0 || index >= size)
            return -1;
        int count = 0; int value = 0;
        Node tempNode = head;
        while(count <= index){
            value = tempNode.data;
            tempNode  = tempNode.next;
            count++;
        }
        tempNode = null;
        return value;
    }
    public boolean isSingleNode(){
        return head == tail;
    }

    //add new node at the end of the linked-list
    public Node addLast(int data){
        Node newNode = new Node(data);
        size++;
        //if linkedlist is empty then inserted node should be first and last node
        if(isEmpty()){
            head = newNode;
            tail = head;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }

        return head;
    }

    //add new node before the head node of the linked-list
    public Node addFirst(int data){
        Node newNode = new Node(data);
        size++;
        //if linkedlist is empty then inserted node should be first and last node
        if(isEmpty()){
            head = newNode;
            tail = head;
        }

        else{
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    //show the list
    public void showList(){
        Node tempNode = head;
        while(tempNode != null){
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }
        System.out.println("null");
    }

    //remove node at head of the list
    public Node removeFirst(){
        if(isEmpty())
            return null;
        if(isSingleNode()){
            head = null;
            tail = null;
        }
        else{
            Node tempNode = head;
            head = head.next;
            tempNode = null;
        }
        size--;
        return head;

    }

    //remove node at the tail of the list
    public Node removeLast(){
        if(isEmpty())
            return null;
        if(isSingleNode()){
            head = null;
            tail = null;
        }
        else{
            Node preTail = head;
            while(preTail.next != tail){
                preTail = preTail.next;
            }
            preTail.next = null;
            tail = preTail;
        }
        size--;
        return head;

    }

    //add at any valid position in the list
    public Node addAnyPos(int pos, int data){
        if(pos <= 0 || pos > size + 1)
            return head;
        if(pos == 1)
            addFirst(data);

        else if(pos == size + 1)
            addLast(data);

        else{
            Node travelNode = head;
            for(int i = 2; i < pos; i++){
                travelNode = travelNode.next;
            }
            Node newNode = new Node(data);
            newNode.next  = travelNode.next;
            travelNode.next = newNode;
            size++;
        }
        return head;
    }

    //remove at any valid position in the list
    public Node removeAnyPos(int pos){
        if(pos <= 0 || pos > size )
            return head;
        if(pos == 1)
            removeFirst();

        else if(pos == size)
            removeLast();

        else{
            Node travelNode = head;
            for(int i = 2; i < pos; i++){
                travelNode = travelNode.next;
            }
            Node temp = travelNode.next.next;
            travelNode.next = temp;
            temp = null;
            travelNode = null;
            size--;
        }
        return head;
    }

    //reverse a linked list using getNodeAt function and swapping the node data(concept of two pointer)
    public SinglyLinkedList reverseListByValue(SinglyLinkedList list){
        int lt = 0;
        int rt = list.size - 1;
        while(lt < rt){

            Node ln = getNodeAt(lt);
            Node rn = getNodeAt(rt);
            //swap the data
            int temp = ln.data;
            ln.data = rn.data;
            rn.data = temp;
            lt++;
            rt--;
        }

        return list;
    }

    //reverse a linked list by changing next pointer by useful implementation
    public SinglyLinkedList reverseListByNext(SinglyLinkedList list){
        if(isEmpty()) return null;
        if(isSingleNode()) return list;

        Node current = list.head;
        Node pre = null;
        while(current != null){
            Node temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        list.head = list.tail;
        list.tail = pre;
        return list;
    }

    //Get kth element from the end of the list
    public int getKthFromEnd(int k){
        if(k >= size || k < 0)
            return -1;
        Node slow = head;
        Node fast = head.next;
        for(int i = 0; i < k; i++ ){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public int getTheMidNodeValue(){
//        if(isSingleNode())return head.data;
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    //To return the middle node of any list provided head and tail is given
    public Node getMidNode(Node head, Node tail){
//        if(isSingleNode())return head.data;
        Node slow = head;
        Node fast = head;

        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //merge two sorted list into one list and return it
    public SinglyLinkedList mergeSortedList(SinglyLinkedList list1, SinglyLinkedList list2){

        SinglyLinkedList ansList = new SinglyLinkedList();
        Node traversal1 = list1.head;
        Node traversal2 = list2.head;
        while(traversal1 != null && traversal2 != null){
            if(traversal1.data > traversal2.data){
                ansList.addLast(traversal2.data);
                traversal2 = traversal2.next;

            }
            else{
                ansList.addLast(traversal1.data);
                traversal1 = traversal1.next;
            }
        }
        while(traversal2 != null){
            ansList.addLast(traversal2.data);
            traversal2 = traversal2.next;
        }
        while(traversal1 != null){
            ansList.addLast(traversal1.data);
            traversal1 = traversal1.next;
        }
        return  ansList;
    }

    //mergesort is used to sort an unsorted list in increasing order
    public SinglyLinkedList mergerSort(Node head, Node tail){

        //step 2 : return only and sorted list which is a single node
        if(head == tail){
            SinglyLinkedList sortedList = new SinglyLinkedList();
            sortedList.addLast(head.data);
            return sortedList;
        }

        //step 1 : To find the mid of the list with the help of head and tail node given
        Node mid = getMidNode(head,tail);
        SinglyLinkedList firstSortedHalf = mergerSort(head,mid);
        SinglyLinkedList secondSortedHalf = mergerSort(mid.next, tail);

        //step 3 : to merge the two sorted half list into one sorted half
        SinglyLinkedList finalSortedList = mergeSortedList(firstSortedHalf, secondSortedHalf);
        return finalSortedList;
    }

    //merge two list(element of any order) into one list
    public SinglyLinkedList mergeIntoOne(SinglyLinkedList first, SinglyLinkedList second){
        first.tail.next = second.head;
        first.tail = second.tail;
        first.size = first.size + second.size;
        return first;
    }




}
