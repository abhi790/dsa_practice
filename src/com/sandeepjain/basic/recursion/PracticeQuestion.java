package com.sandeepjain.basic.recursion;

public class PracticeQuestion {
    //Question 1 : Recursion for Factorial of N
    public long factOfN(int n){
        //if n becomes zero which base case for factorial
        if(n == 0){
            return 1;
        }
        //recursive case
        return n*factOfN(n-1);
    }

    //Question 2 : Recursion for nth Fibonacci
    public long fibo(int n){
        //base case
        if(n == 0 || n == 1)
            return n;
        return fibo(n-1) + fibo(n-2);
    }

    //Question 3 : Recursive printing of number from n to 1
    public void printRecursive1(int n){
        if(n == 0){
            System.out.println();
            return;
        }
        System.out.print(n + " ");
        printRecursive1(n-1); //tail recursive because function call is the last thing inside function
    }

    //Question 4 : Recursive printing of number from n to 1
    public void printRecursive2(int n){
        if(n == 0){
            System.out.println();
            return;
        }
        printRecursive2(n-1); //not a tail recursion because there is still task to accomplished after recursive call
        System.out.print(n + " ");
    }

    //Question 5 : Tail Recursive way fast
    //1.tail recursion of factorial of a number
    public long factOfN(int n, int val){ //Tail recursion
        if(n == 0){
            return val;
        }
        return factOfN(n-1,n*val);
    }
    //5.2 Tail recursion of nth fibonacci
    public long fibo(int n, int a,int b){ //Tail recursion
        int c = a+b;
        if(n <= 0 ){
            return a;
        }
        if(n == 1) {
            return b;
        }
        a=b;
        b=c;
        return fibo(n-1,a,b);
    }

    //5.3 Tail recursion to check a given string is palindrome or not
    public boolean isPali(String str,int start, int end){ //Tail recursion
        //base case
        if(start == end) return true; //this is in the case of odd length string
        if(start > end) return true; //this is in the case of even length string

        //checking of the both end character before calling the recursive case
        if(str.charAt(start) != str.charAt(end)) {
            return false;
        }

        //recursive case
        return isPali(str,start+1,end - 1);
    }

    //Question 6 : sum of digit of a number using normal recusion
    public int sumOfDigit(int n){
        //base case
        if(n == 0)
            return 0;

        //recursive case
        return n%10 + sumOfDigit(n/10);
    }
    //Sum of digit using tail recursion
    public int sumOfDigit(int n,int result){
        //base case
        if(n == 0)
            return result;

        //recursive case
        return sumOfDigit(n/10, result + n%10);
    }

    //Question 7 not able to figure it out the solution

    //Question 8 : Subset generation of a string
    public void subsetGeneration(String str, int index , String curr){
        if(index == str.length()) {
            System.out.println(curr + " ");
            return ;
        }

        subsetGeneration(str,index+1,curr); //we not include
        subsetGeneration(str,index+1, curr + str.charAt(index)); //we will not include
    }

    //Question 9 : Tower of Hanoi
    public void towerOfHanoi(int n, char A, char B, char C){
        //base case
        if(n == 1){
            System.out.println("Move 1 from " + A + " to " + C);
            return;
        }
        towerOfHanoi(n-1,A,C,B);
        System.out.println("Move " + n + " from " + A + " to " + C);
        towerOfHanoi(n-1,B,A,C);
    }


    public static void main(String[] args) {
        //Recursion Question Practice
        PracticeQuestion solve = new PracticeQuestion();
//        //Question 1 :Recursion for Factorial of n
//        System.out.println("Factorial of 5 is : " + solve.factOfN(5) );

//        //Question 2 : Recursion for nth Fibonacci number
//        int n = 10;
//        System.out.println(n + "th fibonacci number is : " + solve.fibo(n));

//        //Question 3 : Print a number from n to 1
//        int n = 10;
//        solve.printRecursive1(n);
//        //Question 4 : Print a number from 1 to n
//        solve.printRecursive2(n);

//        //Question 5 : Tail Recursive way
//        //Question 5.1 : Tail recursive solution of factorial of n
//        System.out.println(solve.factOfN(5,1));

//        //Question 5.2 : Tail recursive solution of nth fibonacci
//        System.out.println(solve.fibo(10,0,1));

//        //Question 5.3 : Tail recursion to check a given string is palindrome or not
//        String str = "abda";
//        System.out.println(solve.isPali(str,0,str.length()-1));

//        //Question 6 : Sum of digit of a number normal recursion slower way
//        System.out.println(solve.sumOfDigit(1984));
//        //using tail recursion faster way
//        System.out.println(solve.sumOfDigit(1984,0));

        //Question 7 : maximum rope cutting not understood the solution as well as question

//        //Question 8 : Subset generation using recursion difficult to understand but implemented the solution
//        String str = "ABC"; //answer is : "", "A","B", "C", "AB", "AC","BC","ABC"
//        solve.subsetGeneration(str,0,"");

//        //Question 9 : Tower of Hanoi
//        solve.towerOfHanoi(8,'A','B','C');



    }
}
