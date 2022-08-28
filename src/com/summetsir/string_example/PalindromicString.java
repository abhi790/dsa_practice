package com.summetsir.string_example;

public class PalindromicString {

    public static void printPalindromicString(String str){
        for (int i=0; i<str.length();i++){
            for (int j=i+1; j<=str.length(); j++){
                String checkString = str.substring(i,j);
                if(isPalindrome(checkString))
                {
                    System.out.println(checkString);
                }
            }
        }
    }
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

    public static void main(String[] args) {
        String str = "abc";
        printPalindromicString(str);
    }
}
