package com.sandeepjain.basic.algo_analysis;

public class AlgoProblem {
    public static class Utility{

    }
    public int sumOfNaturalNo(int n){
        int result = 0;
//        //first way
//        for(int i = 1; i <=n; i++){
//            for(int j = 1; j<= i; j++){
//                result++;
//            }
//        }
//        System.out.println("The result is : " + result);
//        result  = 0;
//        //second method
//        for(int i = 1; i<= n; i++){
//            result += i;
//        }
//        System.out.println("The result is : " + result);
//        //third method
//        result = n*(n + 1)/2;
//        System.out.println("The result is : " + result);

        return result;
    }
    //recursive fibonacci
    public long fibo1(int n) {
        if(n == 0 || n == 1)
            return n;
        return fibo1(n-1) + fibo1(n-2);
    }
    //memoization fibonacci
    public long fibo2(int n){
        if(n == 0 || n < 0)
            return 0;
        long [] f = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i<= n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    public long fibo3(int n){
        if(n == 0 || n == 1)
            return n;
        long a = 0, b=1;long c = 0;
        for(int i = 2; i<= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public void fibonacciPrinting(int n){

//        long start = System.currentTimeMillis();
//        //method 1 : recursive
//        System.out.println(fibo1(n));
//        long end = System.currentTimeMillis();
//        System.out.println("Recursive call takes : " + (end - start) + "ms"); //n = 46 took 13985ms
//        //method 1 : memoization
//        System.out.println(fibo2(n));
//
//        //method 3 :
//        System.out.println(fibo3(n));
    }

    //Driver code
    public static void main(String[] args) {
        AlgoProblem solve = new AlgoProblem();
//        //sum of first n natural numbers
//        System.out.println(solve.sumOfNaturalNo(100000));

        //fibonacci printing
//        for(int i = 0; i<= 92;i++)
            solve.fibonacciPrinting(46);
    }
}
