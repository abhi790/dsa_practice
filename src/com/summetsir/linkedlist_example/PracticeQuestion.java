package com.summetsir.linkedlist_example;

public class PracticeQuestion {
    private static Node getNodeAt(SinglyLinkedList list, int index){
        if(index < 0 || index > list.size)
            return null;
        Node tempNode = list.head;
        int count = 0;
        while(count < index){
            tempNode = tempNode.next;
            count++;
        }

        return tempNode;
    }

    //reverse a list using getNodeAt and swapping the node data without touching the next pointer
    public SinglyLinkedList reverseList(SinglyLinkedList list){
        int lt = 0;
        int rt = list.size - 1;
        while(lt < rt){

            Node ln = PracticeQuestion.getNodeAt(list,lt);
            Node rn = PracticeQuestion.getNodeAt(list,rt);
            //swap the data
            int temp = ln.data;
            ln.data = rn.data;
            rn.data = temp;
            lt++;
            rt--;
        }

        return list;
    }

    public void stackUsingLinkedList(){
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(12);
//        stack.display();
        stack.push(24);
//        stack.display();
        stack.push(36);
//        stack.display();
        stack.push(48);
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();
        System.out.println(stack.peek());
    }

    public void queueUsingLinkedList(){
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.push(45);queue.push(89);queue.push(36);queue.push(16);queue.push(95);
        queue.display();
        queue.pop();queue.pop();queue.pop();
        queue.display();
        System.out.println(queue.top());
    }

    public void printMiddleNodeValueOfList(SinglyLinkedList list){
        for(int i = 1; i < 10; i++){
            list.addFirst(i);
//            if(i < 2)continue;
            list.showList();
            System.out.println(list.getTheMidNodeValue());
        }

    }

    //to help to provide some dummy data to the list
    public SinglyLinkedList createDummyList(SinglyLinkedList list){
        for(int i = 10; i <= 50; i+= 6)
            list.addLast(i);
        return list;
    }
    public SinglyLinkedList createDummyList(SinglyLinkedList list, int [] arr){
        for(var items : arr){
            list.addLast(items);
        }
        return list;
    }

    public SinglyLinkedList mergeSortedList(SinglyLinkedList list1, SinglyLinkedList list2){
        list1 = createDummyList(list1,new int[] {10,20,22,25,26,29,30,40,50});
        list2 = createDummyList(list2);
        list1.showList();
        list2.showList();
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

    //merge two list into one
    public void mergingTwoListIntoOne() {
        SinglyLinkedList mergeList1 = createDummyList(new SinglyLinkedList(), new int[]{90,10,78,23,42});
        SinglyLinkedList mergeList2 = createDummyList(new SinglyLinkedList(), new int[]{5,80,32,96});
        mergeList1.showList();
        mergeList2.showList();
        SinglyLinkedList mergedList = new SinglyLinkedList();
        mergedList = mergedList.mergeIntoOne(mergeList1,mergeList2);
        mergedList.showList();

    }
    public SinglyLinkedList mergingTwoListIntoOne(SinglyLinkedList first, SinglyLinkedList second) {
        first = first.mergeIntoOne(first,second);
//        first.showList();

        return first;
    }
    public  boolean isEven(int data){
        return data % 2 == 0;
    }
    //odd even question implementation
    public SinglyLinkedList oddEvenListSolution(SinglyLinkedList list){
        SinglyLinkedList oddList = new SinglyLinkedList();
        SinglyLinkedList evenList = new SinglyLinkedList();
        Node tempNode = list.head;
        while(tempNode != null){
            int val = tempNode.data;
            list.removeFirst();
            if(isEven(val))
                evenList.addLast(val);
            else
                oddList.addLast(val);

            tempNode = tempNode.next;
        }
        list = mergingTwoListIntoOne(oddList,evenList);

        return list;
    }


    //k reverse approach 2
    public SinglyLinkedList kReverseLinkedList(SinglyLinkedList list, int k){
        SinglyLinkedList prev = null;
        while(list.size > 0){
            SinglyLinkedList current = new SinglyLinkedList();
            if(k <= list.size){
                for (int i = 0; i < k; i++) {
                    int data = list.head.data;
                    list.removeFirst();
                    current.addFirst(data);

                }
            }
            else{
                int size = list.size;
                for (int i = 0; i < size; i++) {
                    int data = list.head.data;
                    list.removeFirst();
                    current.addLast(data);
                }
            }
            if(prev == null){
                prev = current;
            }
            else{
                prev = mergingTwoListIntoOne(prev,current);
            }

        }

        return prev;
    }

    //display list recursively
    public void display(Node head){
        //base case
        if(head == null)
            return;
        display(head.next);
        System.out.print(head.data + "->");
    }

    //Reversing a linkedlist using recursion
    public void reverseUsingRecursive(Node node, Node tail){
        if(node == null)
            return ;
        reverseUsingRecursive(node.next,tail);
        if(node != tail)
            node.next.next = node;
    }

    //below code is for reverse a list using only data without even touching the pointer
    private Node start;
    private void reverseListHelper(SinglyLinkedList list, Node node, int floor){
        if(node == null)
            return;
        reverseListHelper(list,node.next,floor+1);

        //swap data here
        if(floor >= list.size/2){
            int temp = node.data;
            node.data = start.data;
            start.data = temp;
        }

        //increament the front pointer
        start = start.next;
    }
    public void reverseListDataRecursive(SinglyLinkedList list){

        start = list.head;
        reverseListHelper(list, list.head,0);
    }

    //is linkedlist is palindrome
    public boolean isListPalindrome(SinglyLinkedList list){
        start = list.head;
        boolean isPalindrome = palindromeHelper(list,list.head,0);
        return isPalindrome;
    }
    public boolean palindromeHelper(SinglyLinkedList list, Node node, int floor){
        if(node == null)
            return true;

        boolean result = palindromeHelper(list, node.next, floor+1);
        if(!result){
            return false;
        }
        if(floor >= list.size/2){
            if(node.data != start.data){
                return false;
            }
            else
            {
                start = start.next;
                return true;
            }
        }
        else {
            return true;
        }

    }


    //folding a linkedlist
    SinglyLinkedList ans = new SinglyLinkedList();
    public SinglyLinkedList foldList(SinglyLinkedList list){
        start = list.head;
        //first approach
//        foldListHelper(list,list.head,0);

        //second approach
        foldListHelper(list,list.head,0);
        list.tail = null;
        return list;
    }
    public void foldListHelper(SinglyLinkedList list, Node node, int floor){
        if(node == null) return ;

        foldListHelper(list,node.next, floor + 1);

        //swapping link of node and start pointers
        if(floor > list.size/2){
                Node temp = start.next;
                start.next = node;
                node.next = temp;
                start = temp;
        }
        else if(floor == list.size/2){
            list.tail = node;
            list.tail.next = null;
        }

    }

    //Adding two linkedlist
    public SinglyLinkedList addTwoList(SinglyLinkedList list1, SinglyLinkedList list2){
        SinglyLinkedList ans = new SinglyLinkedList();
        int carry = addTwoListHelper(list1.head,list1.size,list2.head,list2.size,ans);
        if(carry > 0) ans.addFirst(carry);
        return ans;
    }
    int carry = 0;

    private int addTwoListHelper(Node head1,int place1, Node head2, int place2, SinglyLinkedList ans){
        int add = 0;int carry ;
        if(head1 == null || head2 == null) return 0;
        else if(place1 > place2){
           carry = addTwoListHelper(head1.next,place1-1,head2,place2,ans);
            add = head1.data + carry;
        }
        else if(place1 < place2){
            carry = addTwoListHelper(head1,place1,head2.next,place2 - 1,ans);
            add = head2.data + carry;
        }
        else if(place1 == place2){
            carry = addTwoListHelper(head1.next,place1-1,head2.next,place2 - 1,ans);
            add = head1.data + head2.data + carry;
        }

        carry = add/10;
        ans.addFirst(add%10);
        return carry;
    }

    //Driver code
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
//        //add node at the tail of the list
//        list.addLast(10);list.addLast(20);list.addLast(30);list.addLast(40);
//        list.addFirst(100);list.addFirst(200);list.addFirst(300);list.addFirst(400);
//        list.showList();

//        PracticeQuestion solve = new PracticeQuestion();
//        list = solve.reverseList(list);
//        list.reverseListByValue(list);
//        list.showList();

//        //reversing a linklist by changing next pointer
//        list.reverseListByNext(list);
//        list.showList();

//        //stack implementation of linkedlist
//        solve.stackUsingLinkedList();

//        //queue implementation of linkedlist
//        solve.queueUsingLinkedList();

//        //solving problem of getting the middle node of the given list
//        solve.printMiddleNodeValueOfList(new SinglyLinkedList());

//        //solving question to merge two sorted list
//        list = solve.mergeSortedList(new SinglyLinkedList(),new SinglyLinkedList());
//        list.showList();

//        //applying mergesort on a list
//        SinglyLinkedList mergeList = solve.createDummyList(new SinglyLinkedList(), new int[]{90,10,78,23,42});
//        mergeList.showList();
//        mergeList = mergeList.mergerSort(mergeList.head,mergeList.tail);
//        mergeList.showList();

//        //merging two list into one
//        solve.mergingTwoListIntoOne();

//        //Odd even question, put all the odd element first and then even element in the list
//        //creating a list containing odd and even value using method enterDummyData
//        SinglyLinkedList oddEvenList = solve.createDummyList(new SinglyLinkedList(), new int[]{2,7,5,6,8,10,13,11,12,96,1,23,78,17,51});
//        oddEvenList.showList();
//        oddEvenList = solve.oddEvenListSolution(oddEvenList);
//        oddEvenList.showList();
//        System.out.println(oddEvenList.size);

//        //Reverse k no of element in the list
//        SinglyLinkedList kReverseList = solve.createDummyList(new SinglyLinkedList(), new int []{1,2,3,4,5,6,7,8,9,10,11});
//        kReverseList.showList();
//        kReverseList =  solve.kReverseLinkedList(kReverseList,5);
//        kReverseList.showList();

//        //display linkedlist recursively
//        SinglyLinkedList recursiveDisplay = solve.createDummyList(new SinglyLinkedList(), new int []{1,2,3,4,5,6,7,8,9,10,11});
//        recursiveDisplay.showList();
//        solve.display(recursiveDisplay.head);
//        System.out.println("null");
//        recursiveDisplay.showList();

//        //Reversing a linkedlist using recursive approach by changing next pointer
//        list = solve.createDummyList(new SinglyLinkedList(), new int []{1,2,3,4,5,6,7,8,9,10,11});
//        list.showList();
//        solve.reverseUsingRecursive(list.head,list.tail);
//        //head is still pointing to next node and this will create a cycle in the linkedlist(faced infinite loop while coding)
//        list.head.next = null;
//        //swap head and tail
//        Node temp = list.head;
//        list.head = list.tail;
//        list.tail = temp;
//        list.showList();

//        //Reversing a linkedlist using recursive approach by swapping data only
//        list = solve.createDummyList(new SinglyLinkedList(), new int []{1,2,3,4,5,6,7,8,9,10});
//        list.showList();
//        solve.reverseListDataRecursive(list);
//        list.showList();

//        //Finding if list is palindrome or not using recursive approach
//        list = solve.createDummyList(new SinglyLinkedList(), new int []{1,3,9,5,10,3,1});
//        list.showList();
//        System.out.println(solve.isListPalindrome(list));


//        //Folding a list using recursive approach
//        list = solve.createDummyList(new SinglyLinkedList(), new int []{1,3,4,10,45,98,65});
//        list.showList();
//        list = solve.foldList(list);
//        list.showList();

//        //Add two linked list
//        SinglyLinkedList list1 = solve.createDummyList(new SinglyLinkedList(),new int[]{9,9,9,9});
//        SinglyLinkedList list2 = solve.createDummyList(new SinglyLinkedList(),new int[]{1,1,1,1});
//        solve.addTwoList(list1,list2).showList();



    }

}
