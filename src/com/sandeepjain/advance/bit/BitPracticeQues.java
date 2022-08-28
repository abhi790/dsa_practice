package com.sandeepjain.advance.bit;

public class BitPracticeQues {

    //Question 1 : all the basic bit operation 7 primary operation
    public void basicBitOperationHelper(){
        BitOperation bitOperation = new BitOperation();
        int x = 6, y=3, z = -6;

        //AND operation
        int ans = bitOperation.andOperation(x,y);
        System.out.println("AND operation of " + x + " and " + y + " is : " + ans);
        ans = bitOperation.andOperation(-x,-y);
        System.out.println("AND operation of " + (-x) + " and " + (-y) + " is : " + ans);

        //OR operation
        ans = bitOperation.orOperation(x,y);
        System.out.println("OR operation of " + x + " and " + y + " is : " + ans);
        ans = bitOperation.orOperation(-x,-y);
        System.out.println("AND operation of " + (-x) + " and " + (-y) + " is : " + ans);

        //XOR operation
        ans = bitOperation.xorOperation(x,y);
        System.out.println("XOR operation of " + x + " and " + y + " is : " + ans);
        ans = bitOperation.xorOperation(-x,-y);
        System.out.println("AND operation of " + (-x) + " and " + (-y) + " is : " + ans);

        //NOT operation                                             _______________
        ans = bitOperation.notOperation(z); // universal formula -- ||~x = -(x+1)|| , x can be negative as well as positive
//                                                                  ^^^^^^^^^^^^^^^
        System.out.println("NOT operation of " + z + " is : " + ans);

        //Left shift operator
        ans = bitOperation.leftShiftOperator(x,y);
        System.out.println("Left Shift operation of " + x + " and " + y + " is : " + ans);
        ans = bitOperation.leftShiftOperator(-x,-y);
        System.out.println("Left Shift operation of " + (-x) + " and " + (-y) + " is : " + ans);

        //Right shift operator
        ans = bitOperation.rightShiftOperator(x,y);
        System.out.println("Right Shift operation of " + x + " and " + y + " is : " + ans);
        ans = bitOperation.rightShiftOperator(-x,-y);
        System.out.println("Right Shift operation of " + (-x) + " and " + (-y) + " is : " + ans);

        //UnsignedRight shift operator
        ans = bitOperation.unsignedRightShiftOperator(x,y);
        System.out.println("UnsignedRight Shift operation of " + x + " and " + y + " is : " + ans);
        ans = bitOperation.unsignedRightShiftOperator(-x,-y);
        System.out.println("UnsignedRight Shift operation of " + (-x) + " and " + (-y) + " is : " + ans);

    }

    //Question 2 : check if kth bit set 3 method
    public void kthBitSetHelper(){
        //Using bitwise and operator
        System.out.println("Kth Bit set using bitwise and operator");
        System.out.println(BitImplementation.isKthBitSetAnd(5,3));
        System.out.println(BitImplementation.isKthBitSetAnd(8,2));
        System.out.println(BitImplementation.isKthBitSetAnd(0,10));
        //Using bitwise left shift operator
        System.out.println("Kth Bit set using bitwise left shift operator");
        System.out.println(BitImplementation.isKthBitSetLS(5,3));
        System.out.println(BitImplementation.isKthBitSetLS(8,2));
        System.out.println(BitImplementation.isKthBitSetLS(0,10));
        //Using bitwise right shift operator
        System.out.println("Kth Bit set using bitwise left shift operator");
        System.out.println(BitImplementation.isKthBitSetRS(5,3));
        System.out.println(BitImplementation.isKthBitSetRS(8,2));
        System.out.println(BitImplementation.isKthBitSetRS(0,10));

    }

    //Question 3 : count set bits in a number 3 method
    public void countSetBitHelper(){
        //Method 1 : Using naive solution Runs in O(no of bits in n)
        System.out.println("There is " + BitImplementation.countSetBit(8) + " set bit in " + 8);
        System.out.println("There is " + BitImplementation.countSetBit(7) + " set bit in " + 7);
        //Method 2 : Using Brian Kerningham's method Runs in O(no of set bits in n)
        System.out.println("There is " + BitImplementation.countSetBitBrianKer(40) + " set bit in " + 40);

    }

    //Question 4 : power of two helper
    public void powerOfTwoHelper(){
        //Method 1 : Naive solution
        System.out.println("8 is power of two ? : " + BitImplementation.isPowerOfTwoNaive(8));
        System.out.println("1 is power of two ? : " + BitImplementation.isPowerOfTwoNaive(1));
        System.out.println("0 is power of two ? : " + BitImplementation.isPowerOfTwoNaive(0));

        //Method 2 : Using Brian Kerningham's
        System.out.println("8 is power of two ? : " + BitImplementation.isPowerOfTwoBrianKer(8));
        System.out.println("1 is power of two ? : " + BitImplementation.isPowerOfTwoBrianKer(1));
        System.out.println("0 is power of two ? : " + BitImplementation.isPowerOfTwoBrianKer(0));
    }

    //Question 5 : only odd occurring element in the array
    public void onlyOddOccuringElementHelper(int [] arr){
        //Method 1 : Naive of Brute Force approach
        System.out.println("The only element in the array which has odd number of count is : " + BitImplementation.onlyOddOccurringElementNaive(arr));
        //Method 2 : Using hashtable to reduce time complexity to O(N)
        System.out.println("The only element in the array which has odd number of count is : " + BitImplementation.onlyOddOccurringElementEff(arr));
        //Method 3 : Using xor operator to reduce time complexity to O(N)
        System.out.println("The only element in the array which has odd number of count is : " + BitImplementation.onlyOddOccurringElementBitEff(arr));

    }

    //Question 6 :  Find the missing number
    // Type 1 : Find the missing number in the array of length n, containing [1,n+1] element, each element occur exactly one time except missing ele
    public void missingEleHelper(int []arr){
//        //Brute force not working O(N^2)
//        BitImplementation.findTheMissingNumberNaive(arr);
        //USing hashtable O(N)
        System.out.println(BitImplementation.findTheMissingNumberHash(arr));
        //Using xor operator O(N)
        System.out.println(BitImplementation.findTheMissingNumberUsingXor(arr));
    }
    //Type 2 : variation of above question only difference is range, elements in the range of [x,n+x]
    public void missingEleHelper2(int []arr){
        System.out.println(BitImplementation.findTheMissingNumberUsingXor2(arr));
    }

    //Question 7 : Find two odd occurring element in the array
    public void twoOddOccurringEleHelper(int []arr){
        //Method 1 : Brute force approach
        int []ans = BitImplementation.findTwoOddOccurringEleNaive(arr);
        BitImplementation.printLookUp(ans);
        //Method 2 : Using Hash O(N)
        ans = BitImplementation.findTwoOddOccurringEleHash(arr);
        BitImplementation.printLookUp(ans);
        //Method 3 : Using xor TC : O(N)
        ans = BitImplementation.findTwoOddOccurringEleXor(arr);
        BitImplementation.printLookUp(ans);
    }

    //Question 8 : Powerset generation
    public void powerSetHelper(String sequence){
     String [] ans = BitImplementation.powerSetUsingBit(sequence);
     BitImplementation.printLookUp(ans);
    }

    public static void main(String[] args) {

        BitPracticeQues solve = new BitPracticeQues();
//        //Question 1 : all the basic bit
//        solve.basicBitOperationHelper();

//        //Question 2 : check if kth bit is set or not, use just n&k == 1 then true else false
//        solve.kthBitSetHelper();

//        //Question 3 : count set bits in a number n
//        solve.countSetBitHelper();

//        //Question 4 : power of two
//        solve.powerOfTwoHelper();

//        //Question 5 : only odd occurring element in the array
//        solve.onlyOddOccuringElementHelper(new int[] {4,3,4,4,4,5,5});

//        //Question 6 :  Find missing element
//        //Type 1 : all element in array have exactly one occurrence except one missing ele find that,
//        //if size of array is n, then array contains element [1,n+1], find the missing element(brute force not implemented)
//        solve.missingEleHelper(new int[] {1,3,4,5,2,7});
//        //Type 2 : variation of above question only difference is range, elements in the range of [x,n+x]
//        solve.missingEleHelper2(new int[]{3,6,5});

//        //Question 7 : Finding two odd occurring element in an array
//        solve.twoOddOccurringEleHelper(new int[]{3,4,3,4,5,4,4,6,7,7});

        //Question 8 : Power set generation using bit Manipulation
        solve.powerSetHelper("abc");
    }
}
