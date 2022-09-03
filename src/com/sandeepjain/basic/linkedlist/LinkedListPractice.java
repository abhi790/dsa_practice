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
    ////{Question 5 : Checking for cycle in the linkedlist
    public void checkingCycleInListHelper(){
        //create a hypothetical list that contain cycle(hope so, hahahhhh)
        Linkedlist list = new Linkedlist();
        if(hasCycle(list)) System.out.println("The given list contains cycle");
        else System.out.println("No cycle is present in the given list");
    }
    public boolean hasCycle(Linkedlist list){
        boolean result = false;
        if(list.head == null || list.head.next == null) return result;
        Node slow = list.head;
        Node fast = list.head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                result = true;
                break;
            }
        }

        return result;
    }

    ////{Question 6 : finding the intersect node of two linkedlist
    public void findingIntersectNodeHelper(){
        Linkedlist list1 = new Linkedlist();
        Linkedlist list2 = new Linkedlist();
        if(list1.head == null || list2.head == null){
            System.out.println("There is no intersecting node available");
            return;
        }
        //we don't need to find the tail of list1 as because we kept a tail reference for this
        list1.tail = list2.head;
        Node intersect = findingIntersectNode(list1,list2);
        if(intersect != null) System.out.println("We found the intersect and the node is : " + intersect.toString());
        list1.tail = null;
    }
    public Node findingIntersectNode(Linkedlist list1, Linkedlist list2){
        if(list1.head == list1.tail || list2.head == list2.tail)
            return null;
        //check for cycle
        Node slow = list1.head;
        Node fast = list1.head;
        boolean result = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                result = true; //contains cycle
                break;
            }
        }
        if(result){
            slow = list1.head;
            fast = fast;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
                if(slow == fast)
                    return slow;
            }

        }

        return null;
    }

    ////{Question 6 : magic of slow and fast pointer
    public void magicOfFastAndSlowPointerHelper(){
        //Q1: Delete the middle node of the list and return the head
        Node head = new Node();
        head = deleteMiddleNode(head);

        //Q2: Delete a given node and assume the node is not the tail node
        Node node = head.next.next; //any valid non-tail node :-D
        deleteGivenNode(node);

        //Q3: Swap the kth data from both the end of the list
        int k = 3;
        head = swapKthNode(head,k);

    }
    //Q1: Delete the middle node of the list and return the head
    public  Node deleteMiddleNode(Node head){
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        Node preOfSlow = slow;
        //at the end of the loop slow pointer will point the middle node of the list, and preOfSlow will point slow
        while(fast != null && fast.next != null){
            preOfSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //make a link and you are done
        preOfSlow.next = slow.next;
        return head;
    }
    //Delete the given node assume that given node is not a tail node
    public void deleteGivenNode(Node node){
        //copy the data of node next to given node
        node.data = node.next.data;
        //exchange the reference as because given node is not the tail node
        node.next = node.next.next;
    }
    //Q3: Swap the kth(1th indexed) data from both the end of the list
    public Node swapKthNode(Node head, int k){
        if(head == null || head.next == null) return head;
        int counter = k;
        Node start = head;
        Node end = head;
        Node traverse = head;
        while(counter > 1){
            traverse = traverse.next;
            start = start.next;
            counter--;
        }
        while(traverse.next != null){
            traverse = traverse.next;
            end = end.next;
        }
        int value = end.data;
        end.data = start.data;
        start.data = value;
        return head;
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
        ////{Question 5 : Checking for cycle in the linkedlist
        solve.checkingCycleInListHelper();
        ////{Question 6 : magic of slow and fast pointer
        solve.magicOfFastAndSlowPointerHelper();

    }

}
