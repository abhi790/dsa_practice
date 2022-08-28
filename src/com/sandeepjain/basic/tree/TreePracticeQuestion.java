package com.sandeepjain.basic.tree;

public class TreePracticeQuestion {
    private TreeImplementation tree = new TreeImplementation();
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
    public void iterativeTraversalHelper(){
        //1.Iterative Inorder Traversal


        //2.Iterative Preorder Traversal

        //3.Iterative Postorder Traversal
    }

    //Recursive Traversal of Binary Tree
    public void recursiveTraversalHelper(){
        //Three type of depth First Traversal is present
        //1.Inorder 2.Preorder 3.Postorder
        tree.inOrderTraversal(new TreeNode(10));
        System.out.println();
        tree.preOrderTraversal(new TreeNode(23));
        System.out.println();
        tree.postOrderTraversal(new TreeNode(56));
        System.out.println();
    }

    //find the size of tree(count the node in the tree)
    public void sizeOfBTHelper(){
        tree.sizeOfBT(new TreeNode(45));
    }
    //maximum value in binary tree(Maximum value in the tree)
    public void maximumOfBTHelper(){
        System.out.println(tree.maxOfBT(new TreeNode(79)));
    }
    //maximum height of binary tree(the longest path from root node to leaf node)
    public void maxHgtHelper(){
        System.out.println(tree.maxHgtOfBT(new TreeNode(78)));
    }

    public static void main(String[] args) {
        TreePracticeQuestion solve = new TreePracticeQuestion();

        //Depth First Traversal
        solve.recursiveTraversalHelper();

        //Size of binary tree
        solve.sizeOfBTHelper();

        //Maximum of binary tree
        solve.maximumOfBTHelper();

        //maximum height of binary tree(the longest path from root node to leaf node)
        solve.maxHgtHelper();

        //

    }
}
