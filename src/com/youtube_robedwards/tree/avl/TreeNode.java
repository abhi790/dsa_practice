package com.youtube_robedwards.tree.avl;

public class TreeNode<E> {
    E data;
    TreeNode<E> leftNode;
    TreeNode<E> rightNode;
    TreeNode<E> parentNode;

    public TreeNode(E obj) {
        data = obj;
    }
}
