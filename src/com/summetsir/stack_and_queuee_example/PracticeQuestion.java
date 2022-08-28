package com.summetsir.stack_and_queuee_example;

import java.util.Stack;

public class PracticeQuestion {
    //Utility function
    private int[] nextSmallerELeRightUsingIndex(int [] arr){
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
                ans[i] = arr.length;
            else
                ans[i] = stack.peek();

            //push the current element on the stack bz this element can be the next smaller element to some other element
            stack.push(i);
        }
        return ans;
    }

    private int[] nextSmallerELeLeftUsingIndex(int [] arr){
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
    private void printArray(int [] arr){
        for(var ele : arr){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

    //1.Duplicate brackets
    public boolean isDuplicateBracket(String bracket){
        Stack<Character> stack = new Stack<>();
       for(int i = 0; i< bracket.length(); i++){
           char ch = bracket.charAt(i);
           if(ch == ')'){
               if(stack.peek() == '(') return true;

               while(stack.peek() != '('){
                   stack.pop();
               }
               stack.pop();
           }
           else
            stack.push(ch);
       }
        return false;
    }

    //2. Valid Parenthesis
    public boolean isValidParenthesis(String parenthesis){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< parenthesis.length(); i++){
            char ch = parenthesis.charAt(i);

                if(ch == '(' || ch == '{' || ch == '['){
                    stack.push(ch);
                }
                else if((ch == ')' || ch == '}' || ch == ']') && stack.size() != 0){
                    if(ch == ')' && stack.peek() != '(') return false;
                    else if(ch == '}' && stack.peek() != '{') return false;
                    else if(ch == ']' && stack.peek() != '[') return false;
                    stack.pop();
                }
                //stack is already zero and still there is closing brackets present in the string
                else if((ch == ')' || ch == '}' || ch == ']') && stack.size() == 0) return false;
            }
        if(stack.isEmpty())
            return true;
        return false;
    }

    //Question 3-7 ... Next greater or smaller element to the right or left using stack
    public void nextGreaterSmallerEle(){
        NextGreSmallerElement nGSE = new NextGreSmallerElement();

        //Question 3- Next greater element to the right
        int []element = new int[]{10,9,8,7,6,5,4,3,2,1}; //element in decreasing order will create best case
//        nGSE.printArray(element);
//        element = nGSE.nextGreaterELeRight(element);
//        nGSE.printArray(element);

        //Question 3- Next greater element to the right
        element = new int[]{2,5,9,3,1,12,6,8,7}; //element in decreasing order will create best case
        nGSE.printArray(element);
        element = nGSE.nextGreaterELeRightUsingIndex(element);
        nGSE.printArray(element);
//
//        //Question 4- Next greater element to the right, alternatives approach
//        element = new int[]{2,5,9,3,1,12,6,8,7};
//        nGSE.printArray(element);
//        element = nGSE.nextGreaterEleRightA2(element);
//        nGSE.printArray(element);

//        //Question 5- Next Greater element to the left
//        element = new int[]{2,5,9,3,1,12,6,8,7}; // element in ascending order is best case run in O(N)
//        nGSE.printArray(element);
//        element = nGSE.nextGreaterELeLeft(element);
//        nGSE.printArray(element);

//        //Question 6- Next Smaller element to the right
//        element = new int[]{1,2,3,4,5,6,7,8,9,10}; // element in ascending order is best case run in O(N)
//        nGSE.printArray(element);
//        element = nGSE.nextSmallerELeRight(element);
//        nGSE.printArray(element);

//        //Question 7- Next Smaller element to the left
//        element = new int[]{2,5,9,3,1,12,6,8,7}; // element in ascending order is best case run in O(N)
//        nGSE.printArray(element);
//        element = nGSE.nextSmallerELeLeft(element);
//        nGSE.printArray(element);
    }

    //Question 8 - Stock Span pushing element on stack
    public int [] stockSpan(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        ans[0] = 1;
        stack.push(arr[0]);
        for(int i= 1; i < arr.length; i++){
            int span = 1;
            //remove element from the stack until we get next greater element
            while(stack.size() > 0 && arr[i] >= stack.peek()){
                span++;
                stack.pop();
            }

            //if the stack became empty we have not found any greater element then we need to put index + 1 in the ans array
            if(stack.size() == 0){
                ans[i] = i + 1;
            }
            else
                ans[i] = span;

            //push the current element on top of the stack
            stack.push(arr[i]);
        }

        return ans;
    }

    //Stock Span pushing index on the stack
    public int [] stockSpanAlternatives(int [] arr){
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        ans[0] = 1;
        stack.push(0); //we will push the index inside the stack
        for(int i= 1; i < arr.length; i++){
            //remove element from the stack until we get next greater element
            while(stack.size() > 0 && arr[i] >= arr[stack.peek()])
                stack.pop();


            //if the stack became empty we have not found any greater element then we need to put index + 1 in the ans array
            if(stack.size() == 0){
                ans[i] = i + 1;
            }
            else
                ans[i] = i - stack.peek();

            //push the current index on top of the stack
            stack.push(i);
        }

        return ans;
    }

    //Question 9 - the largest area histogram
    public int largestAreaHistogram(int []histogram){
//        int [] ans = new int[histogram.length];

        //find the next smaller element on the right array
        int [] nSER = new PracticeQuestion().nextSmallerELeRightUsingIndex(histogram);
        printArray(nSER);
        //find the next smaller element on the left array
        int [] nSEL = new PracticeQuestion().nextSmallerELeLeftUsingIndex(histogram);
        printArray(nSEL);
        int maxArea = 0;
        int []widthSpan = new int[histogram.length];
        for(int i = 0; i < histogram.length; i++){
            widthSpan[i] = nSER[i] - nSEL[i] - 1;
            int width = widthSpan[i]; //width of the current element
            int height = histogram[i];
            int area = width * height;
            if(area > maxArea)
                maxArea = area;
        }
        printArray(widthSpan);
        return maxArea;
    }

    //Question 10 - sliding window maximum
    public int [] slidingWindowMax(int []arr, int k){
        int []swm = new int[arr.length - k + 1];
        //step 1 = find out the next greater element to the right
        Stack<Integer> stack = new Stack<>();
        int [] nGR = new int[arr.length];
        nGR[arr.length - 1] = arr.length;
        stack.push(arr.length-1);
        for(int i = arr.length - 2; i>=0; i--){
            //step 1.1 pop the element from stack until we get next greater element
            while(stack.size() > 0  && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }

            //if stack became empty we haven't got any next greater element to the right then assume that next greater element is present at the index after the last index
            if(stack.size() == 0){
                nGR[i] = arr.length;
            }
            else
                nGR[i] = stack.peek(); //index of our next greater element

            //push the index of current element on the stack as because it can be the next greater element to some other element
            stack.push(i);
        }
//        printArray(nGR);

        //step 2 : finding out the max element inside the given window size
        int j = 0;
        for(int i = 0; i <= arr.length - k; i++){
            //make sure i and j are on the same page then start processing
            if(j < i)
                j = i;
            //if index of next greater element is in the window then move j to that index
            while(nGR[j] < i + k){
                j = nGR[j];
            }
            swm[i] = arr[j];

        }

        return swm;
    }

    //Question 11 - sliding window minimum
    public int [] slidingWindowMin(int []arr, int k){
        int []swm = new int[arr.length - k + 1];
        //step 1 - find out the next smallest element to the right
        Stack<Integer> stack = new Stack<>();
        int [] nSR = new int[arr.length];
        nSR[arr.length - 1] = arr.length;
        stack.push(arr.length - 1);
        for(int i = arr.length - 2; i >= 0; i--){
            //pop the element from the stack until we got next smallest element to the right
            while(stack.size() > 0 && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }

            //if the stack became the empty then we didn't found any index which containing smaller element
            if(stack.size() == 0)
                nSR[i] = arr.length;
            else
                nSR[i] = stack.peek();

            //don't forget to push the index inside the stack
            stack.push(i);

        }
        printArray(nSR);
        //step 2 : find the minimum element inside the given window
        int j = 0;
        for(int i = 0; i <= arr.length - k; i++){
            //if j left behind of i then make sure they are on the same page
            if(j < i)
                j = i;
            //search for the minimum element inside the window
            while(nSR[j] < i + k){
                j = nSR[j];
            }
            //copy the minimum element into the swm array
            swm[i] = arr[j];
        }
        return swm;
    }

    //Question 12 - expression evaluation, infix, postfix, prefix
    public void expressionEvaluation(){

    }

    //Driver code
    public static void main(String[] args) {
        PracticeQuestion solve = new PracticeQuestion();
//        //Question 1- Duplicate bracket
//        String bracket = "(a+b)+((c+d))";
//        boolean isDuplicate = solve.isDuplicateBracket(bracket);
//        if(isDuplicate) {
//            System.out.println("Contains Duplicate");
//        }
//        else {
//            System.out.println("No Duplicacy is present");
//        }

//        //Question 2 - Given string is valid parenthesis
//        String parenthesis = "(a+b+[{c+d)}]";
//        boolean isValid = solve.isValidParenthesis(parenthesis);
//        if(isValid){
//            System.out.println("Valid String of parenthesis");
//        }
//        else {
//            System.out.println("Not a valid string of parenthesis");
//        }

//        //Question 3 - 7 ... NExt greater or smaller element to the right or left using stack
//        solve.nextGreaterSmallerEle();

//        //Question 8 - stock span(inspired from next greater element on the left)
//        int []element = new int[]{2,5,9,3,1,12,6,8,7}; //element in decreasing order will create best case
//        solve.printArray(element);
//        element = solve.stockSpan(element);
//        solve.printArray(element);

//        //Question 9 - the largest area histogram(inspired by next greater element and stock span)
//        int []element = new int[]{5,1,5,4,3,2,1,2,3,4,10};
//        solve.printArray(element);
//        System.out.println(solve.largestAreaHistogram(element)); //tricky one uses next greater right and next smaller left

//        //Question 10 - sliding window maximum(concept of next greater element to the right is used here)
//        int []element = new int[]{5,7,6,8,10,9};
//        solve.printArray(element);
//        int [] swm = solve.slidingWindowMax(element,4);
//        solve.printArray(swm);

//        //Question 11 - sliding window minimum(concept of next smaller element to the right is used here)
//        int []element = new int[]{1,4,5,3,2,3,4,10};
//        solve.printArray(element);
//        int [] swm = solve.slidingWindowMin(element,4); //swm - sliding window minimum
//        solve.printArray(swm);

        //Question 12 - expression evaluation , infix,postfix,prefix


    }
}
