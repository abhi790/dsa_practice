package com.sandeepjain.advance.bit;

public class BitOperation {

    //AND operation
    public int andOperation(int x, int y){
//        System.out.println(x&y);
        return x&y;
    }

    //OR operation
    public int orOperation(int x, int y){
//        System.out.println(x|y);
        return x|y;
    }

    //XOR operation
    public int xorOperation(int x, int y){
//        System.out.println(x^y);
        return x^y;
    }

    //NOT operation
    public int notOperation(int x){
//        System.out.println(~x);
        return ~x;
    }

    //Left shift operator
    public int leftShiftOperator(int x, int y){
        return x << y;
    }

    //Right shift operator
    public int rightShiftOperator(int x, int y){
        return x >> y;
    }

    //unsignedRight shift operator
    public int unsignedRightShiftOperator(int x, int y){
        return x >>> y;
    }


}
