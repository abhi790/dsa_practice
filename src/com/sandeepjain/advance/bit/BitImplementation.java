package com.sandeepjain.advance.bit;

public class BitImplementation {


    ////{Question 2 : Check for kth set bit in a number
    //kth bit using bitwise left shift
    public static boolean isKthBitSetLS(int n , int k){
        return (n&(1<<(k-1))) != 0;
    }
    //kth bit using bitwise right shift
    public static boolean isKthBitSetRS(int n , int k){
        return (1&(n >> (k-1))) == 1;
    }
    //kth bit using only bitwise AND
    public static boolean isKthBitSetAnd(int n , int k){
        return (n&(1<<(k-1))) != 0;
    }
    ////}


    ////{ Question 3 count the number of set bits in a number
    //Count set bit using right shift and AND operator TC:O(no of bits in n)
    public static int countSetBit(int n){

        int count = 0;
        while(n != 0){ // n>0 can also be used
            if((n&1) == 1) // (n%2) != 0 can also be used
                count++;
            n = n >> 1;  // n= n/2; can also be used
        }
        return count;
    }
    //count set bit using brian kerningham's method TC:O(no of set bits in n)
    public static int countSetBitBrianKer(int n){

        int count = 0;
        while(n != 0){
            count++;
            n = (n&(n-1));
        }
        return count;
    }
    //Count set bits in O(1) --- don't understand the solution as because it was in c++ language and java implementation is not provided
    ////} end of count the number of set bits in a number


    ////{Question 4 : power of two
    //Solution 1 : Naive solution O(no of bits in n)
    public static boolean isPowerOfTwoNaive(int n){
        if(n == 0 ) return false;
        while(n != 1){
            if((n&1) == 1)
                return false;
            n = n>>1;
        }
        return true;
    }
    //Solution 2 : Efficient solution using brian kerningham method
    public static boolean isPowerOfTwoBrianKer(int n){
        if(n == 0){
            return false;
        }
        return (n&(n-1)) == 0;
    }
    ////} end of power of two solution


    ////{Question 5 : only odd occurring element in the array
    //Solution 1 : Naive or Brute Force approach O(N^2)
    public static int onlyOddOccurringElementNaive(int []arr){
        int element = arr[0];
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j])
                    count++;
            }
            if(count % 2 != 0){
                element =  arr[i];
                break;
            }
        }
        return element;
    }
    //Solution 2 : Efficient method to reduce TC to O(N)
    public static int onlyOddOccurringElementEff(int [] arr){
        int element = arr[0];
        int [] lookUp = new int[arr.length+1];
        //this will take O(N) time to complete
        for(int i = 0; i < arr.length; i++){
            lookUp[arr[i]]++;
        }
//        //lookup table checking
//        for(var x : lookUp){
//            System.out.print(x + " ");
//        }
        //in the worst case this loop will run 0(N)
        for(int i = 0; i < arr.length; i++){
            int count = lookUp[i];
            if(count % 2 != 0){
                element = i;
                break;
            }
        }
        return element;
    }
    //Solution 3 : Using bitwise xor O(N)
    public static int onlyOddOccurringElementBitEff(int []arr){
        int element = 0; //using the property of xor operation
        for(int i =0; i < arr.length; i++){
            element = element^arr[i]; //3^5^5 = 3 , 5^5 = 0, 0^3 = 3,this property is used
        }

        return element;
    }
    ////}end of only odd occurring element in the array question

    ////{Question 6 : Find the missing number in the array of length n, containing [1,n+1] element, each element occur exactly one time except missing ele
    //Solution 1 : Brute force or Naive solution O(N^2)
    public static int findTheMissingNumberNaive(int []arr){
        System.out.println("Implement findTheMissingNumberNaive :-)");
        return 0;
    }
    //Solution 2 : Using lookup table O(N) TC
    public static int findTheMissingNumberHash(int []arr){

        int result = 0 ; int []lookUp = new int[arr.length+2];
        for(int i=0; i < arr.length ; i++){
            lookUp[arr[i]]++;
        }
//        //see lookup
//        for(var x : lookUp)
//            System.out.print(x + " ");

        for(int i = 1; i < lookUp.length; i++){
            if(lookUp[i] == 0){
                result = i;
                break;
            }
        }
        return result;
    }
    //Solution 3 : Using XOR operator to compute it into O(N) time
    public static int findTheMissingNumberUsingXor(int []arr){
        int result = 1;
        for(int i = 2; i <= arr.length + 1;i++){
            result = result^i;
        }

        for(int i = 0; i < arr.length; i++){
            result = result^arr[i];
        }
        return result;
    }
    //variation 2 solution : variation of above question only difference is range, elements in the range of [x,n+x]
    public static int findTheMissingNumberUsingXor2(int []arr){
        int x = arr[0]; int n = arr.length; int result = arr[0];
        for(int i = 1; i <= arr.length;i++){ // let arr = 3,6,5, then it will xor 3^4^5^6(bz range is [3,3+arr.length])
            result = result ^ (++x);
        }
        for(int i = 0; i < arr.length; i++){ // now it will xor result^3^5^6, finally 3,5,6 cancel each other and 4 will left as answer in result
            result = result ^ arr[i];
        }
        return result;
    }
    ////} end of missing number in the array


    ////{Question 7 : Find two odd occurring element in the array
    //lookup printing or array printing
    public static void printLookUp(int []lookUp){
        System.out.print("["); int i = 0;
        for(var ele:lookUp){
            if(i++ != lookUp.length - 1)
                System.out.print(ele + ",");
            else
                System.out.println(ele + "]");
        }
    }
    public static void printLookUp(String []arr){
        System.out.print("["); int i = 0;
        for(var ele:arr){
            if(i++ != arr.length - 1)
                System.out.print(ele + ",");
            else
                System.out.println(ele + "]");
        }
    }
    //Solution 1 : Brute force
    public static int [] findTwoOddOccurringEleNaive(int [] arr){
        int []ans = new int[2]; int k = 0;
        for(int i=0 ;i < arr.length;i++){
            int count = 0;
            for(int j = 0; j< arr.length; j++){
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            if(count%2 != 0){ //count is odd
                ans[k++] = arr[i];
            }
        }
        return ans;
    }
    //Solution 2 : Using hashtable O(N) time complexity, exactly two element are odd occurring
    public static int [] findTwoOddOccurringEleHash(int []arr){
        int []result = new int[2];
        int []lookUp = new int[arr.length+1];

        //create lookUp table in O(N)
        for(int i= 0; i<arr.length; i++){
            lookUp[arr[i]]++;
        }
//        printLookUp(lookUp);
        int j = 0;
        for(int i = 0; i < lookUp.length;i++){
            if(lookUp[i] % 2 != 0)
                result[j++] = i;
        }

        return result;
    }
    //Solution 3 : Using XOR operator difficult to understand
    public static int [] findTwoOddOccurringEleXor(int []arr){
        int xor = arr[0];
        //xor on all element in the array
        for(int i = 1; i< arr.length; i++){
            xor = xor ^ arr[i];
        }
        //creating the rightmost bit as set bit
        int rightBitSet = xor & (~(xor-1));
        int result1 = 0, result2 = 0;
        for(int i = 0; i < arr.length; i++){
            if((arr[i]&rightBitSet) != 0)
                result1 = result1 ^ arr[i];
            else
                result2 = result2 ^ arr[i];
        }
        return new int[]{result1,result2};
    }
    ////}end of find two odd occurring element in the array

    ////{Question 8 :
    public static int powerOfTwo(int n){
        int result = 1;
        for(int i = 1; i <= n;i++){
            result = result*2;
        }
        return result;
    }
    // Power set generation using bits
    public static String[] powerSetUsingBit(String sequence){
        int n = sequence.length();
        int power = powerOfTwo(n);
        String [] seq = new String[power];
        for(int counter = 0; counter < power; counter++){
            StringBuilder ans = new StringBuilder("");
            for(int j = 0; j < n; j++){
                if((counter & (1 << j)) != 0)
//                    System.out.print(sequence.charAt(j));
                    ans.append(sequence.charAt(j));
            }
//            System.out.println();
            seq[counter] = ans.toString();
        }
        return seq;
    }
}
