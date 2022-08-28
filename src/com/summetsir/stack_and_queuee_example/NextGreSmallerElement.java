package com.summetsir.stack_and_queuee_example;

import java.util.Stack;

public class NextGreSmallerElement {
    public void printArray(int [] arr){
        for(var ele : arr){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }
    //3.Next greater element to the right
    public int[] nextGreaterELeRight(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int lastIndex = arr.length - 1;
        stack.push(arr[lastIndex]);
        ans[lastIndex] = -1;
        for(int i = lastIndex - 1; i >= 0; i--){
            //pop the element in the stack until we get next greater element
            while((stack.size() > 0) && (arr[i] >= stack.peek()))
                stack.pop();


            //if the stack became empty, and we didn't get any next greater element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;

            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next greater element to some other element
            stack.push(arr[i]);
        }
        return ans;
    }

    //3.1 Next greater element to the right using index
    public int[] nextGreaterELeRightUsingIndex(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int lastIndex = arr.length - 1;
        stack.push(lastIndex);
        ans[lastIndex] = -1;
        for(int i = lastIndex - 1; i >= 0; i--){
            //pop the element in the stack until we get next greater element
            while((stack.size() > 0) && (arr[i] >= arr[stack.peek()]))
                stack.pop();


            //if the stack became empty, and we didn't get any next greater element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;

            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next greater element to some other element
            stack.push(i);
        }
        return ans;
    }

    //4.Next greater element to the right 2nd approach
    public int[] nextGreaterEleRightA2(int []arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < arr.length; i++){
            while(stack.size() > 0 &&  arr[i] > arr[stack.peek()]) {
                int pos = stack.peek();
                ans[pos] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        while(stack.size() > 0){
            int pos = stack.peek();
            ans[pos] = -1;
            stack.pop();
        }
        return ans;
    }

    //5.Next greater element to the left
    public int[] nextGreaterELeLeft(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        ans[0] = -1;
        for(int i = 1; i < arr.length; i++){
            //pop the element in the stack until we get next greater element
            while((stack.size() > 0) && (arr[i] >= stack.peek()))
                stack.pop();


            //if the stack became empty, and we didn't get any next greater element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;

            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next greater element to some other element
            stack.push(arr[i]);
        }
        return ans;
    }
    //5.1 Next greater element to the left using index
    public int[] nextGreaterELeLeftUsingIndex(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ans[0] = -1;
        for(int i = 1; i < arr.length; i++){
            //pop the element in the stack until we get next greater element
            while((stack.size() > 0) && (arr[i] >= arr[stack.peek()]))
                stack.pop();

            //if the stack became empty, and we didn't get any next greater element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next greater element to some other element
            stack.push(i);
        }
        return ans;
    }

    //6.Next Smaller element to the right
    public int[] nextSmallerELeRight(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int lastIndex = arr.length - 1;
        stack.push(arr[lastIndex]);
        ans[lastIndex] = -1;
        for(int i = lastIndex - 1; i >= 0; i--){
            //pop the element in the stack until we get next greater element
            while((stack.size() > 0) && (arr[i] <= stack.peek()))
                stack.pop();


            //if the stack became empty, and we didn't get any next greater element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;

            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next greater element to some other element
            stack.push(arr[i]);
        }
        return ans;
    }

    //6.1 Next Smaller element to the right using index
    public int[] nextSmallerELeRightUsingIndex(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int lastIndex = arr.length - 1;
        stack.push(lastIndex);
        ans[lastIndex] = -1;
        for(int i = lastIndex - 1; i >= 0; i--){
            //pop the element in the stack until we get next smaller element index
            while((stack.size() > 0) && (arr[i] <= arr[stack.peek()]))
                stack.pop();

            //if the stack became empty, and we didn't get any next smaller element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next smaller element to some other element
            stack.push(i);
        }
        return ans;
    }

    //7.Next Smaller element to the left
    public int[] nextSmallerELeLeft(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        ans[0] = -1;
        for(int i = 1; i < arr.length; i++){
            //pop the element in the stack until we get next smaller element
            while((stack.size() > 0) && (arr[i] <= stack.peek()))
                stack.pop();

            //if the stack became empty, and we didn't get any next smaller element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next smaller element to some other element
            stack.push(arr[i]);
        }
        return ans;
    }

    //7.1 Next smaller element to the left using index
    public int[] nextSmallerELeLeftUsingIndex(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        ans[0] = -1;
        for(int i = 1; i < arr.length; i++){
            //pop the element in the stack until we get next smaller element index
            while((stack.size() > 0) && (arr[i] <= arr[stack.peek()]))
                stack.pop();

            //if the stack became empty, and we didn't get any next smaller element then current element put -1
            if(stack.size() == 0)
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next smaller element to some other element
            stack.push(i);
        }
        return ans;
    }


}
