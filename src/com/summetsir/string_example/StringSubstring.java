package com.summetsir.string_example;

import java.util.Scanner;

public class StringSubstring {
    //Utility class to use method for substring operation
    public static class SubstringUtility{
        public static String startIndexToEndIndex(String str, Scanner sc){
            if(str == null){
                return "Enter some valid string";
            }
            System.out.println("Enter start index : ");
            int start = sc.nextInt();

            System.out.println("Enter end index : ");
            int end = sc.nextInt();

            try{
                str =  str.substring(start, end);
            }
            catch(StringIndexOutOfBoundsException e){
               str =  e.getMessage() + " is not valid index";
            }


            return str;
        }

        //printing all the substring of a given string
        public static void allSubstring(String str){
            if(str == null){
                System.out.println("Enter some valid string");
                return;
            }
            for(int i=0; i<str.length(); i++){
                for(int j = i+1; j <= str.length(); j++){
                    System.out.println(str.substring(i,j));
                }
                System.out.println();
            }
        }

        public static String starIndexToEnd(String str, Scanner sc){
            if(str == null){
                return "Enter some valid string";
            }
            System.out.println("Enter start index : ");
            int start = sc.nextInt();

            try{
                str =  str.substring(start);
            }
            catch(StringIndexOutOfBoundsException e){
                str =  e.getMessage() + " is not valid index";
            }
            return str;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String str = sc.next();
        //1.Substring
        //Substring from start index to end index
        System.out.println(SubstringUtility.startIndexToEndIndex(str,sc));

        //substring from start index to end of the string
        System.out.println(SubstringUtility.starIndexToEnd(str, sc));

        //printing all the substring of a given string
        SubstringUtility.allSubstring(str);

    }

}
