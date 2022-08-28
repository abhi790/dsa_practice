package com.sandeepjain.basic.tree;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class TreeImplementation {
     TreeNode root;
    private int maxOfThree(int x, int y, int z){
        int max = 0;
        if(x >= y){
            if(x > z)
                max = x;
            else
                max = z;
        }
        else{

            if(y > z)
                max  = y;
            else max = z;
        }
        return max;
    }

    //Iterative Traversal of Binary Tree
    //1.ITERATIVE INORDER TRAVERSAL
    public void iterativeInOrderTra(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || (curr != null)){
            while(curr != null){
                stack.push(curr);
                curr  = curr.leftChild;
            }
            curr = stack.pop();
            System.out.println(curr.data);
            curr = curr.rightChild;
        }
    }
    //2.ITERATIVE PREORDER TRAVERSAL
    public void iterativePreOrderTra(TreeNode root){
/*
        //My Approach
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || (curr != null)){
            while(curr != null){
                stack.push(curr);
                System.out.print(curr.data + " ");
                curr  = curr.leftChild;
            }
            curr = stack.pop();
            curr = curr.rightChild;
        }
        System.out.println();
        */

//        //Sir's approach
//        if(root == null) return;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode curr = stack.pop();
//            System.out.print(curr.data+" ");
//            if(curr.rightChild != null) stack.push(curr.rightChild);
//            if(curr.leftChild != null) stack.push(curr.leftChild);
//        }
//        System.out.println();


        //Sir's space optimised solution
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(root);
        while(!stack.isEmpty()){
            while(curr != null){
                System.out.print(curr.data + " ");
                if(curr.rightChild != null)
                    stack.push(curr.rightChild);

                curr = curr.leftChild;
            }
            curr = stack.pop();
//            System.out.print(curr.data + " ");
        }

    }
    //3.ITERATIVE POSTORDER TRAVERSAL
    public void iterativePostOrderTra(TreeNode root){

    }


    //Recursive Traversal of Binary Tree
    //1.Inorder traversal
    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraversal(root.rightChild);
    }
    //2.Preorder Traversal
    public void preOrderTraversal(TreeNode root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }
    //3.PostOrder Traversal
    public void postOrderTraversal(TreeNode root){
        if(root == null) return;
        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.data + " ");
    }



    //Find the size of tree(count the node in the tree)
    public int sizeOfBT(TreeNode root){
        if(root == null)
            return 0;
        int leftSize = sizeOfBT(root.leftChild);
        int rightSize = sizeOfBT(root.rightChild);
        return 1 + leftSize + rightSize;
    }

    //maximum value in binary tree(Maximum value in the tree)
    public int maxOfBT(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        return maxOfThree(root.data,maxOfBT(root.leftChild),maxOfBT(root.rightChild));
    }

    //maximum height of binary tree(the longest path from root node to leaf node)
    public int maxHgtOfBT(TreeNode root){
        if(root == null) return 0;
        //recursive case
        int heightOfLeftChild =  maxHgtOfBT(root.leftChild);
        int heightOfRightChild =  maxHgtOfBT(root.rightChild);
        return 1 + Math.max(heightOfLeftChild, heightOfRightChild);
    }

}
