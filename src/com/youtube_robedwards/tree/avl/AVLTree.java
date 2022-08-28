package com.youtube_robedwards.tree.avl;

public class AVLTree<E> {
    TreeNode<E> root;
    int currentSize;

    public void add(E obj){
        TreeNode<E> newNode = new TreeNode<>(obj);
        if(root == null){
            root = newNode;
            currentSize++;
            return;
        }
        add(root,newNode);
    }
    public void add(TreeNode<E> parent,  TreeNode<E> newNode){
//        if((Comparable<E>)newNode.compareTo(parent))

    }
}
