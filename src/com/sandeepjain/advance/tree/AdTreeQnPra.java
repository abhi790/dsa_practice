package com.sandeepjain.advance.tree;

import java.util.HashMap;

public class AdTreeQnPra {
    //Utility method
    private boolean isEmpty(TreeNode root){
        return root == null;
    }
    private boolean isLeafNode(TreeNode root){
        if(root == null) return false;
        return (root.leftChild == null && root.rightChild == null);
    }
    private int heightOfTree(TreeNode root){
        if(isLeafNode(root))
            return 1;
        else if(isEmpty(root)) {
            return 0;
        }

        int leftHeight = heightOfTree(root.leftChild);
        int rightHeight = heightOfTree(root.rightChild);

        return 1 + Math.max(leftHeight,rightHeight);
    }


    //1.Determine if two tree are identical Helper
    public void isTwoTreeEqualHelper(){
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode();
        boolean result = isTwoTreeEqual(root1, root2);
        System.out.println("Is both tree equal? : " + result);
    }
    public boolean isTwoTreeEqual(TreeNode root1, TreeNode root2){
        if(isLeafNode(root1) && isLeafNode(root2)){
            return root1.data == root2.data;
        }
        if(isEmpty(root1) && isEmpty(root2))
            return true;
        else if(isEmpty(root1) || isEmpty(root2)){
               return false;
        }

        return ((root1.data == root2.data) && isTwoTreeEqual(root1.leftChild,root2.leftChild) && isTwoTreeEqual(root1.rightChild, root2.rightChild));
    }

    //2.children sum parent
    public void childrenSumHelper(){
        TreeNode root = new TreeNode();
        boolean result = isChildrenSumParent(root);
        System.out.println("Is the given tree following children sum parent property? : " + result);
    }
    public boolean isChildrenSumParent(TreeNode root){
        if(isEmpty(root) || isLeafNode(root))
            return true;
        int sum = 0;
        if(root.leftChild != null){
            sum = sum + root.leftChild.data;
        }
        if(root.rightChild != null){
            sum = sum + root.rightChild.data;
        }

        return ((sum == root.data) && isChildrenSumParent(root.leftChild) && isChildrenSumParent(root.rightChild));
    }

    //3.Level order traversal line by line
    public void levelOrderTravLineByLineHelper(){
        TreeNode root = new TreeNode();
        System.out.println("Level Order traversal line by line :------");
        levelOrderTravLineByLine(root);
    }
    public void levelOrderTravLineByLine(TreeNode root){
        if(isEmpty(root)) return;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode temp = queue.poll();
                System.out.print(temp.data + " ");
                if(root.leftChild != null)
                    queue.add(root.leftChild);
                if(root.rightChild != null)
                    queue.add(root.rightChild);

            }
            System.out.println();
        }

    }


    //4.Level order traversal in spiral form


    //5.Maximum width of tree
    public void maximumWidthBTHelper(){
        TreeNode root = new TreeNode();
        System.out.println("The maximum width of the given Binary Tree is : " + maximumWidthBT(root));
    }
    public int maximumWidthBT(TreeNode root){
        int maxWidht = 0;
        if(isEmpty(root)) return maxWidht;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int maxEle = queue.size();
            if(maxEle > maxWidht)
                maxWidht = maxEle;
            for(int i = 0; i < maxEle; i++){
                TreeNode temp = queue.poll();
                if(temp.leftChild != null)
                    queue.add(temp.leftChild);
                if(temp.rightChild != null)
                    queue.add(temp.rightChild);

            }
        }
        return maxWidht;
    }

    //6.Check for balanced tree
    public void balancedBTHelper(){
        TreeNode root = new TreeNode();
        int result = isBalanceBT(root);
        System.out.print("Is the given Binary Tree is balanced? : " );
        if(result == -1)
            System.out.println("NO");
        else
            System.out.println("Yes");
    }
    //sir method in O(N) time complexity
    public int isBalanceBT(TreeNode root){
        if(isLeafNode(root))
            return 1;
        if(isEmpty(root))
            return 0;

        int lh = isBalanceBT(root.leftChild);
        if(lh == -1) return -1;
        int rh = isBalanceBT(root.rightChild);
        if(rh == -1) return -1;
        //check current node height balance or not
        if(Math.abs(lh - rh) > 1)
            return -1;
        return Math.max(lh,rh) + 1;
    }
    //my method(Naive approach) in O(N^2)
    public boolean isBalanceBT2(TreeNode root){
        if(isLeafNode(root) || isEmpty(root))
            return true;
        int leftHeight = heightOfTree(root.leftChild);
        int rightHeigt = heightOfTree(root.rightChild);

        return ((Math.abs(leftHeight - rightHeigt) <= 1) && isBalanceBT2(root.leftChild) && isBalanceBT2(root.rightChild));
    }

    //7.Left view of BT
    public void leftViewBTHelper(){
        TreeNode root = new TreeNode();
        System.out.println("Left View of the given tree :---");
        leftViewBTIterative(root);
    }
    public void leftViewBTIterative(TreeNode root){
        if(isEmpty(root)) return;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode temp = queue.poll();
                if(i == 0)
                    System.out.print(temp.data + " ");
                if(root.leftChild != null)
                    queue.add(root.leftChild);
                if(root.rightChild != null)
                    queue.add(root.rightChild);

            }
            System.out.println();
        }

    }

    //8.Right view of BT
    public void rightViewBTHelper(){
        TreeNode root = new TreeNode();
        System.out.println("Left View of the given tree :---");
        rightViewBTIterative(root);
    }
    public void rightViewBTIterative(TreeNode root){
        if(isEmpty(root)) return;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode temp = queue.poll();
                if(i == count - 1)
                    System.out.print(temp.data + " ");

                if(root.leftChild != null)
                    queue.add(root.leftChild);
                if(root.rightChild != null)
                    queue.add(root.rightChild);

            }
            System.out.println();
        }

    }

    //9.Lowest common ancestor in BT


    //10.Diameter of BT
    public void diameterOfBTHelper(){
        TreeNode root = new TreeNode();
        System.out.println("The diameter of the given tree is : " + diameterOfBT(root));
        System.out.println("The diameter of the given tree is : " + diameter(root));

        diaEffModifyHeight(root);
        System.out.println("The diameter of the given tree is : " + diameter);

    }
    //My solution takes O(N^2) time complexity, O(width of BT) space complexity
    public int diameterOfBT(TreeNode root){
        int diameter = 1;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode> ();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int leftH = heightOfTree(temp.leftChild);
            int rightH = heightOfTree(temp.rightChild);
            int maxNode = leftH + rightH + 1;
            if(maxNode > diameter)
                diameter = maxNode;

            if(temp.leftChild != null) queue.add(temp.leftChild);
            if(temp.rightChild != null) queue.add(temp.rightChild);
        }
        return diameter;
    }
    //Sir's approach O(N^2) time complexity and O(N) auxiliary stack space
    public int diameter(TreeNode root){
        if(root == null) return 0;
        int d1 = 1 + heightOfTree(root.leftChild) + heightOfTree(root.rightChild);
        int d2 = diameter(root.leftChild);
        int d3 = diameter(root.rightChild);
        return Math.max(d1,Math.max(d2,d3));
    }
    //Sir's efficient solution using Hashmap, implement the below diameterEff method
    public void diameterEfficientHelper(TreeNode root){
        int diameter = 1;
        java.util.HashMap<TreeNode, Integer> map = new java.util.HashMap<TreeNode,Integer>();
        diameterEff(root,map);
    }
    public int diameterEff(TreeNode root, HashMap<TreeNode,Integer > map){
        return 0;
    }
    int diameter = 0;
    //By Modifying the height method we can find diameter of a given tree
    public int diaEffModifyHeight(TreeNode root){
        if(root == null) return 0;
        int lh = diaEffModifyHeight(root.leftChild);
        int rh = diaEffModifyHeight(root.rightChild);
        diameter = Math.max(diameter,1+lh+rh);
        return Math.max(lh,rh) + 1;
    }

    //11.Vertical width of BT


    //12.Mirror Tree
    public void mirrorTreeHelperHelper(){
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode();
        boolean result = isMirrorTree(root1, root2);
        System.out.println("Is both tree are mirror of each other? : " + result);
    }
    public boolean isMirrorTree(TreeNode root1, TreeNode root2){
        if(isLeafNode(root1) && isLeafNode(root2)){
            return root1.data == root2.data;
        }
        if(isEmpty(root1) && isEmpty(root2))
            return true;
        else if(isEmpty(root1) || isEmpty(root2)){
            return false;
        }

        return ((root1.data == root2.data) && isMirrorTree(root1.leftChild,root2.rightChild) && isMirrorTree(root1.rightChild, root2.leftChild));
    }

    //13.Check if subtree


    //14.Make BT from LinkedlIst


    //15.BT To DLL


    //16.BT to CDLL


    //17.Connect node at same level


    //18.Construct BT from parent array


    //19.Tree from preorder and inorder
    public void constructBTHelper(){
        int [] pre = new int[]{10,20,30,40,50};
        int []in = new int[]{20,10,40,30,50};
        int inStarting = 0;
        int inEnding = in.length;
        TreeNode root = constructBT(pre,in, inStarting,inEnding);
        //print the given tree
        levelOrderTravLineByLine(root);

    }
    int preIndex = 0;
    public TreeNode constructBT(int [] pre, int []in,int is, int ie){
        if(is > ie) return null;
        TreeNode root = new TreeNode(pre[preIndex++]);
        int inIndex = 0;
        for(int i = is; i <= ie; i++){
            if(in[i] == root.data){
                inIndex = i;
                break;
            }
        }
        root.leftChild = constructBT(pre,in,is,inIndex - 1);
        root.rightChild = constructBT(pre,in, is,inIndex + 1);
        return root;
    }

    //20.Foldable BT

    //Driver code
    public static void main(String[] args) {
        AdTreeQnPra solve = new AdTreeQnPra();
//
//        //1.Determine if two tree are identical
//        solve.isTwoTreeEqualHelper();
//        //2.children sum parent
//        solve.childrenSumHelper();
//        //3.Level order traversal line by line
//        solve.levelOrderTravLineByLineHelper();
//        //4.Level order traversal in spiral form
//
//        //5.Maximum width of tree
//        solve.maximumWidthBTHelper();
//        //6.Check for balanced tree
//        solve.balancedBTHelper();
//        //7.Left view of BT
//        solve.leftViewBTHelper();
//        //8.Right view of BT
//        solve.rightViewBTHelper();
//        //9.Lowest common ancestor in BT
//
//        //10.Diameter of BT
//        solve.diameterOfBTHelper();
//
//        //11.Vertical width of BT
//
//        //12.Mirror Tree
//        solve.mirrorTreeHelperHelper();
//        //13.Check if subtree

        //14.Make BT from LinkedList

        //15.BT To DLL

        //16.BT to CDLL

        //17.Connect node at same level

        //18.Construct BT from parent array

        //19.Tree from postorder and inorder
        solve.constructBTHelper();
        //20.Foldable BT

    }
}
