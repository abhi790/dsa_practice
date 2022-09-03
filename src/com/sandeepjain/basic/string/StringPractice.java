package com.sandeepjain.basic.string;

import java.util.Arrays;
import java.util.TreeMap;

public class StringPractice<T> {
    private void _printArray(T [] arr){
        System.out.print("[" + arr[0]);
        for(int i=1; i < arr.length; i++){
            System.out.print("," + arr[i] );
        }
        System.out.println("]");
    }
    //1.check string anagram helper
    //O(N^2) time complexity
    public boolean checkStringAnagNaive(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int []freq = new int[s2.length()];
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                   if(freq[j] == 0){
                       freq[j] = 1;
                        break;
                   }
                }
            }
        }
        for(int flag : freq){
            if(flag == 0) return false;
        }
        return true;
    }
    //O(N) time complexity using frequency array
    public boolean checkStringAnagEff1(String s1, String s2){
        if(s1.length() != s2.length() ) return false;
        int [] freq1 = new int[256];
        for(int i =0; i < s1.length(); i++){
            freq1[i]++;
        }
        for(int i = 0; i < s2.length(); i++){
            freq1[i]--;
        }

        for(int i =0 ; i < 256; i++){
            if(freq1[i] != 0) return false;
        }
        return true;
    }
    public void checkStringAnagramHelper(){
        String s1 = "geeks"; // geeks and ekegs are anagram(contains same character with equal frequency)
        String s2 = "keeg";
        System.out.println(checkStringAnagNaive(s1,s2));

    }

    //2.Find the index of first repeating character in the string
    //Brute force O(N^2) time complexity
    public int findFirstRepeatingCharNaive(String str){
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    return i;
                }
            }
        }

        return -1;
    }
    //Efficient using hashmap O(N) time complexity
    public int findFirstRepeatingCharEff(String str){
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i =0; i <str.length(); i++){
            Integer c = map.get(str.charAt(i));
            if(c != null){
                map.put(str.charAt(i),++c);
            }
            else
                map.put(str.charAt(i),1);
        }

        for(int i = 0; i < str.length(); i++){
            if(map.get(str.charAt(i)) > 1)
                return i;
        }
        return  -1;
    }
    //Efficient using ----- O(N but exactly one traversal of string) time complexity
    public int findFirstRepeatingCharEff2(String str){
        int res = Integer.MAX_VALUE;
        int []freq = new int[256];
        Arrays.fill(freq,-1);
//        _printArray((T[]) freq);
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(freq[c] == -1){
                freq[c] = i;
            }
            else{
                res = Math.min(res, freq[c]);
            }
        }

        return (res == Integer.MAX_VALUE) ? -1:res;
    }
    //Efficient using ----- O(N but exactly one traversal of string) time complexity(slight modification of previous one)
    public int findFirstRepeatingCharEff3(String str){
        int res = Integer.MAX_VALUE;
        int []freq = new int[256];
        Arrays.fill(freq,-1);
        for(int i = str.length() - 1; i >= 0; i--){
            char c = str.charAt(i);
            if(freq[c] == -1){
                freq[c] = i;
            }
            else{
                res = i; //simply
            }
        }

        return (res == Integer.MAX_VALUE) ? -1:res;
    }
    public void findFirstRepeatingHelper(){
        String str = "geeksforgeeks"; // g is the first repeating char and it's index is 0
        System.out.println(findFirstRepeatingCharNaive(str));
        System.out.println(findFirstRepeatingCharEff(str));
        System.out.println(findFirstRepeatingCharEff2(str));
        System.out.println(findFirstRepeatingCharEff3(str));
    }

    //3.Find first non repeating character in the string (see later get multiple failure)
    public int findFirstNonRepeatingNaive(String str){
        int res = -1;
        for(int i = 0; i < str.length(); i++){
            boolean found = false;
            for(int j = i+1; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    found = true;
                    break;
                }

            }
            if(!found){
                res = i;
                break;
            }
        }
        return res;
    }
    public int findFirstNonRepeatingEff(String str){
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            Integer count = map.get(c);
            if(count != null){
                map.put(c,++count);
            }
            else {
                map.put(c,1);
            }
        }
        for(int i = 0; i < str.length(); i++){
             char c = str.charAt(i);
             if(map.get(c) == 1){
                 return i;
             }
        }

        return -1;
    }
    public int findFirstNonRepeatingEff2(String str){
        return -1;
    }
    public void findFirstNonRepeatingHelper(){
        String str = "geeksforgeeks";
        System.out.println(findFirstNonRepeatingNaive(str));
    }
}


//Driver code
class Main{
    public static void main(String[] args) {
        StringPractice solve = new StringPractice();
//        //1.check string anagram
//        solve.checkStringAnagramHelper();
//        //2.first repeating character in the string
//        solve.findFirstRepeatingHelper();
        //3.first non-repeating character in the string
        solve.findFirstNonRepeatingHelper();
    }
}
