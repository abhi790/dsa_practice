package com.summetsir.string_example;


import java.util.ArrayList;
import java.util.Scanner;

public class QuestionPractice {
    public static class Utility{
        //checking a string is palindrome or not
        public static boolean isPalindrome(String str){
            int st = 0;
            int lt = str.length()-1;
            while(lt >= st){
                if(str.charAt(st) != str.charAt(lt))
                    return false;
                st++;lt--;
            }
            return true;
        }
        //split at spaces
        public static String [] splitAtSpace(String str){
            return str.split(" ");
        }
        //compression function
        public static StringBuilder compressStringTypeOne(StringBuilder sb){
            int j = 0;
            StringBuilder ans = new StringBuilder("");
            ans.append(sb.charAt(0));
            for(int i = 1; i<sb.length(); i++){
                if(ans.charAt(j) != sb.charAt(i)){
                    ans.append(sb.charAt(i));
                    j++;
                }
            }
            return  ans;
        }
        public static StringBuilder compressStringTypeTwo(StringBuilder sb){
            int count = 1; int j = 0;
            StringBuilder ans = new StringBuilder("");
            ans.append(sb.charAt(0));
            for(int i = 1; i<sb.length(); i++){
                if(ans.charAt(j) == sb.charAt(i)){
                    count++;
                }
                else if(ans.charAt(j) != sb.charAt(i)){
                    if(count != 1){
                        ans.append(count);
                        j++;
                    }
                    count = 1;
                    ans.append(sb.charAt(i));
                    j++;
                }
            }
            if(count != 1)
                ans.append(count);
            return  ans;
        }
        //check a given number is prime or not
        public static boolean isPrime(int value){
            if(value < 2) return false;
            for(int div = 2; div * div <= value; div++){
                if(value % div == 0)
                    return false;
            }
            return true;
        }

    }
    public static void removeAllPrimeFromArraylist(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> removePrime = new ArrayList<>();
        int n ;
        System.out.println("Enter the no of input : ");
        n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            removePrime.add(sc.nextInt());
        }
        System.out.println("Before removing items from the arraylist : " + removePrime);
        for(int i = removePrime.size() - 1; i >=0; i--){
            if(Utility.isPrime(removePrime.get(i)))
                removePrime.remove(i);
        }
        System.out.println("After removing items from the arraylist : " + removePrime);

    }
    public static String toggleCaseOfAString(String str){
        StringBuilder sb = new StringBuilder(str);
        String s = "Enter a valid string without any space or digit or special character";
        for(int i =0; i<sb.length();i++){
            int ascii = sb.charAt(i);
            int requiredAscii = 0;

            if(ascii > 122 || ascii < 65)
                return s;
            else if(ascii >=65 && ascii <= 90){
                requiredAscii = ascii + 32;
                sb.setCharAt(i, (char) requiredAscii);
            }
            else if(ascii >=97 && ascii <= 122){
                requiredAscii = ascii - 32;
                sb.setCharAt(i, (char) requiredAscii);
            }

//            System.out.println("Ascii of " + sb.charAt(i) +" is " + ascii);
        }
        return sb.toString();
    }
    //ascii difference between consecutive character in string
    public static String asciiDifference(String str){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < str.length() -1; i++){
            byte asciiDif = (byte) (str.charAt(i+1) - str.charAt(i));
            sb.append(str.charAt(i));
            sb.append(asciiDif);
        }
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }

    public static void main(String[] args) {
//        //1.compression method 1 and method 2
//        System.out.println(Utility.compressStringTypeOne(new StringBuilder("aaabbbcccddd")));
//        System.out.println(Utility.compressStringTypeTwo(new StringBuilder("aaabbbcccdfg")));
//
//        //2.split at spaces
//        System.out.println(Arrays.toString(Utility.splitAtSpace("split at spaces")));
//
//        //3.check palindromic string
//        System.out.println(Utility.isPalindrome("aba"));

//        //4.check isPrime
//        System.out.println(Utility.isPrime(1));

//        //5.Remove all prime from the arraylist --- likewise we can implement for even or odd number removable
//        removeAllPrimeFromArraylist();
//
//        //6.Toggle case of a string
//        System.out.println(toggleCaseOfAString("AbhImAnYu"));

//
//        //7.ascii difference string banana hai kisi bhi string ki
//        System.out.println(asciiDifference("abcba"));

    }
}
