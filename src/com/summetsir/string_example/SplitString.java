package com.summetsir.string_example;

public class SplitString {
     public static class SplitUtility{
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
