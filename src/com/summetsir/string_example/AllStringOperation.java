package com.summetsir.string_example;

import java.util.Scanner;

public class AllStringOperation {
    private static class SubstringUtility{
        public static String startIndexToEndIndex(String str, Scanner sc){
            System.out.println("Enter start index : ");
            int start = sc.nextInt();
            System.out.println("Enter end index : ");
            int end = sc.nextInt();

            return str.substring(start, end);
        }

        //printing all the substring of a given string
        public static void allSubstring(String str){
            for(int i=0; i<str.length(); i++){
                for(int j = i+1; j <= str.length(); j++){
                    System.out.println(str.substring(i,j));
                }
                System.out.println();
            }
        }

        public static String starIndexToEnd(String str, Scanner sc){
            System.out.println("Enter start index : ");
            int start = sc.nextInt();

            return str.substring(start);
        }

    }

    private static class SplitUtility{
        public static void splitAtSpace(String str){
            String [] splitAns;
            splitAns = str.split(" ");
            for(String s : splitAns){
                System.out.println(s);
            }
        }
        public static void splitAtComma(String str){
            String [] splitAns;
            splitAns = str.split(",");
            for(String s : splitAns){
                System.out.println(s);
            }
        }
    }



    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the String : ");
//        String str = sc.next();

//        //1.Substring
//        //Substring from start index to end index
//        System.out.println(SubstringUtility.startIndexToEndIndex(str,sc));
//
//        //substring from start index to end of the string
//        System.out.println(SubstringUtility.starIndexToEnd(str, sc));
//
//        //printing all the substring of a given string
//        SubstringUtility.allSubstring(str);

        //2.split
        //split at space
        String str1 = "This sentence will be splitted at spaces";
        System.out.println("Split by Spaces :: ---- ::");
        SplitUtility.splitAtSpace(str1);
        //split at comma
        System.out.println("Split by Comma :: ---- ::");
        String str2 = "This,sentence,will,be,splitted,at,comma";
        SplitUtility.splitAtComma(str2);


    }

}
