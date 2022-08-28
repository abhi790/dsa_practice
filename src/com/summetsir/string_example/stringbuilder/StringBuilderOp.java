package com.summetsir.string_example.stringbuilder;

public class StringBuilderOp {
    public static void setAndGetCharAt(){
        StringBuilder str = new StringBuilder("Abhimanyu");
        //getting char at index given
        System.out.println(str.charAt(0));

        //changing char at specified index no
        str.setCharAt(0,'a');
        System.out.println(str);
        str.setCharAt(8,'A');
        System.out.println(str);
    }
    public static void insertIntoIndex(){
        StringBuilder str = new StringBuilder("Abhmanyu");
        //inseting i at 3
        str.insert(3,'i');
        System.out.println(str);

    }
    public static void removeChar(){
        StringBuilder str = new StringBuilder("Abhiiimanyu");
        str.deleteCharAt(3);
        str.deleteCharAt(3);
        System.out.println(str);
    }
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
    public static void appendingAtEnd(){
        StringBuilder str = new StringBuilder("Abhima");
        str.append("n roy");
        System.out.println(str);
    }
    public static void performanceAnalysis(){
        int sampleSize = 1000000;
        System.out.println("String computing ");
        //Time taken by string to complete its task
        long startTime = System.currentTimeMillis();
        String s = "0";
        for(int i = 0; i < sampleSize;i++){
            s += s.charAt(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by String : " + (endTime - startTime) + " miliseconds");

        //Time taken by StringBuilder to complete its task
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("0");
        for(int i = 0; i < sampleSize;i++){
            sb.append(sb.charAt(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder : " + (endTime - startTime)+ " miliseconds");

    }
    public static void main(String[] args) {
        System.out.println("String Builder class: ");

//        //1.setting and getting character at specified index
//        setAndGetCharAt();
//
//        //2.inserting character at specified index
//        insertIntoIndex();
//
//        //3.appending character at the end of the stringbuilder
//        appendingAtEnd();
//
//        //4.removing at the index
//        removeChar();

//        //5.1st compression function
//        StringBuilder sb = new StringBuilder("aaabbcdddeeeeefggc"); //output must be abcdefgc
//        System.out.println(compressStringTypeOne(sb));
//
//        //6.2nd compression function
//        StringBuilder sb1 = new StringBuilder("aaabbcdddeeeeefggc"); //output must be a3b2cd3e5fg2c
//        System.out.println(compressStringTypeTwo(sb1));

//        //7.String and StringBuilder performance checks
//        performanceAnalysis();

    }

}
