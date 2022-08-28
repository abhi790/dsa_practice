package com.sandeepjain.advance.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdvanceTreeImplementation {
    TreeNode root;

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
        //My Approach is working
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

    //4.Level order traversal line by line
    public void levelOrderTravLineByLine(TreeNode root){
        //Method 1 using only one loop and by inserting null intentionally into the queue

        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);

        while(queue.size()>1){
            TreeNode temp = queue.poll();
            if(temp == null){
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(temp.data + " ");
            if(temp.leftChild != null) queue.add(temp.leftChild);
            if(temp.rightChild != null) queue.add(temp.rightChild);
        }
    }
    public void levelOrderTravLineByLine2(TreeNode root){
        //Method 2 using two loop, better way

        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            while(count > 0){
                TreeNode temp = queue.poll();
                System.out.print(temp.data + " ");
                if(temp.leftChild != null)
                    queue.add(temp.leftChild);
                if(temp.rightChild != null)
                    queue.add(temp.rightChild);
                count--;
            }
            System.out.println();
        }
    }

    //5.Print Kth node from the root, k=0 means root itself
    public void printKthLevelNodes(TreeNode root, int k){
        if(root == null) return;
        if(k == 0){
            System.out.println(root.data +" ");
            return ;
        }
        printKthLevelNodes(root.leftChild,k-1);
        printKthLevelNodes(root.rightChild,k-1);
    }

    //6.Left view of the binary tree(two solution)
    //Iterative solution, using level order traversal line line algo
    public void leftViewOfBT(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i<count; i++){
                TreeNode temp = queue.poll();
                if(i == 0)
                    System.out.print(temp.data + " ");
                if(temp.leftChild != null){
                    queue.add(temp.leftChild);
                }
                if(temp.rightChild != null){
                    queue.add(temp.rightChild);
                }
            }
        }
    }
    //Recursive solution using two extra variable
    int maxLevel = 0;
    public void leftViewOfBTRecursive(TreeNode root){

    }

    //7.Right view of the binary tree(two solution)
    //Iterative solution, using level order traversal line line algo
    public void rightViewOfBT(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i<count; i++){
                TreeNode temp = queue.poll();
                if(i == count - 1)
                    System.out.print(temp.data + " ");
                if(temp.leftChild != null){
                    queue.add(temp.leftChild);
                }
                if(temp.rightChild != null){
                    queue.add(temp.rightChild);
                }
            }
        }
    }
    //Recursive solution using two extra variable
    int maxLevel2 = 0;
    public void rightViewOfBTRecursive(TreeNode root){

    }

    //8.Children sum
    public int Childsum(TreeNode root){
        if(isEmptyTree(root)) return 0;
        else return root.data;
    }
    private boolean isEmptyTree(TreeNode root){
        return root == null;
    }
    private boolean isLeafNode(TreeNode root){
        if(root == null) return false;
        if(root.leftChild == null && root.rightChild == null) return true;
        else return false;
    }
    //My solution to children sum property
    public boolean ChildrenSum(TreeNode root){
        if(isEmptyTree(root) || isLeafNode(root))
            return true;
        if(ChildrenSum(root.leftChild) && ChildrenSum(root.rightChild)){
            int leftChildSum = Childsum(root.leftChild);
            int rightChildSum = Childsum(root.rightChild);
            if(leftChildSum + rightChildSum == root.data)
                return true;

            else return false;
        }
        else return false;

    }
    //Sir solution for children sum property
    public boolean sirChildrenSum(TreeNode root){
        if(isEmptyTree(root) || isLeafNode(root))
            return true;
        int sum = 0;
        if(root.leftChild != null){
            sum = sum + root.leftChild.data;
        }
        if(root.rightChild != null){
            sum = sum + root.rightChild.data;
        }
        return ((root.data == sum) && (sirChildrenSum(root.leftChild)) && (sirChildrenSum(root.rightChild)));
    }

    //9.Height Balanced binary tree
    public int heightOfTree(TreeNode root){
        if(isEmptyTree(root))
            return 0;
        if(isLeafNode(root))
            return 1;

        int leftHeight = heightOfTree(root.leftChild);
        int rightHeight = heightOfTree(root.rightChild);

        return 1 + Math.max(leftHeight,rightHeight);
    }
    //9.1-My Naive solution takes O(N^2) time complexity
    public boolean isBalancedHeight(TreeNode root){
        if(isLeafNode(root) || isEmptyTree(root))
            return true;
        if(isBalancedHeight(root.leftChild) && isBalancedHeight(root.rightChild)){
            int leftHeight = heightOfTree(root.leftChild);
            int rightHeight = heightOfTree(root.rightChild);
            if(Math.abs(leftHeight - rightHeight) > 1)
                return false;
            else return true;
        }
        return false;
    }
    //9.2-sir Naive solution(same as mine) takes O(N^2) time complexity
    public boolean isBalancedHeight2(TreeNode root){
        if( isLeafNode(root) ||isEmptyTree(root))
            return true;

        int left = heightOfTree(root.leftChild);
        int right =heightOfTree(root.rightChild);
        return ((Math.abs(left - right) <= 1) && isBalancedHeight2(root.leftChild) && isBalancedHeight2(root.rightChild));
    }

    //9.3-IsBalancedHelper O(N) time complexity
    public boolean isBalancedHelper(TreeNode root){
        int result = isBalancedHeight3(root);
        if(result == -1)
            return false;
        return true;
    }
    public int isBalancedHeight3(TreeNode root){
        if(isLeafNode(root))
            return 1;
        if(isEmptyTree(root))
            return 0;
        int lh = isBalancedHeight3(root.leftChild);
        if(lh == -1) return -1;
        int rh = isBalancedHeight3(root.rightChild);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh,rh) + 1;
    }

    //10.
}
