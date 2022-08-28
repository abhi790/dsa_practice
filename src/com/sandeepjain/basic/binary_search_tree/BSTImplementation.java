package com.sandeepjain.basic.binary_search_tree;

public class BSTImplementation {

    //searching, inserting, deleting in balanced binary tree is O(log(N))
    //1.Searching a key in balanced binary search tree
    //recursive O(logN)
    public boolean searchAKeyInBST(TreeNode root, int key){
        if(root == null) return false;
        else if(root.data == key) return true;
        else if(root.data > key)
            return searchAKeyInBST(root.leftNode,key);
        else
            return  searchAKeyInBST(root.rightNode,key);
    }
    //iterative approach O(logN)
    public boolean searchAKeyInBSTIter(TreeNode root, int key){
        boolean result = false;

        TreeNode temp = root;
        while(temp != null){
            if(temp.data == key){
                result = true;
                break;
            }
            else if(temp.data > key){
                temp = temp.leftNode;
            }
            else
                temp = temp.rightNode;
        }
        return result;
    }

    //2.Inserting a key in balanced binary search tree
    //recursive approach O(logN)
    public TreeNode insertAKeyInBST(TreeNode root, int data){
        if(root == null) return new TreeNode(data);
        if(root.data == data)
            return root;
        else if(root.data > data)
            root.leftNode = insertAKeyInBST(root.leftNode, data);
        else
            root.rightNode = insertAKeyInBST(root.rightNode, data);
        return root;
    }

    //iterative approach O(logN)
    public TreeNode insertAKeyInBSTIter(TreeNode root, int data){
        TreeNode newNode;
        //if an empty root is passed then we have to simpy create a treenode and return its address
        if(root == null){
            newNode = new TreeNode(data);
            return newNode;
        }

        TreeNode parent = root, curr = root;
        //insertion always take place after the leaf node
        while(curr != null){
            parent = curr;
            if(curr.data == data) return root;
            else if(curr.data > data){
                curr = curr.leftNode;
            }
            else
                curr = curr.rightNode;
        }

        newNode = new TreeNode(data);
        //decide where to insert the desired node, left child or right child
        if(parent.data > data) {
            //insert on the left child
            parent.leftNode = newNode;
        }
        else
            //insert on the right child
            parent.rightNode = newNode;
        return root;
    }

    //3.Deleting a key from a balanced bst
//    //recursive
//    public TreeNode deletingAKeyFromBST(){
//
//    }
    //Iterative

    //4.Floor in BST TC: O(logN), Auxiliary Space:O(1)
    public TreeNode floorValue(TreeNode root, int key){
        if(root == null) return null;
        TreeNode potentialFloor = null, curr = root;
        while(curr != null){

            if(curr.data == key) return curr;
            //search the key on the left hand side of the root
            else if(curr.data > key)
                    curr = curr.leftNode;
            else{
                potentialFloor = curr;
                curr = curr.rightNode;
            }
        }
        return potentialFloor;
    }

    //5.Ceil in BST TC: O(logN), Auxiliary Space:O(1)
    public TreeNode ceilValue(TreeNode root, int key){
        if(root == null) return null;
        TreeNode potentialCeil = null, curr = root;
        while(curr != null){

            if(curr.data == key) return curr;
                //search the key on the left hand side of the root
            else if(curr.data > key){
                potentialCeil = curr;
                curr = curr.leftNode;
            }
            else{
                curr = curr.rightNode;
            }
        }
        return potentialCeil;
    }



}
