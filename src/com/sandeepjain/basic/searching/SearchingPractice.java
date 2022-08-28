package com.sandeepjain.basic.searching;
class BinarySearch{
    public int binarySearchIterative(int []arr, int item){
        int first = 0;
        int last = arr.length - 1;
        while(first <= last){
            int mid = (first + last)/2;
            if(arr[mid] == item)
                return mid;
            else if(arr[mid] > item)
                last = mid - 1;
            else
                first = mid + 1;

        }
        return -1;
    }
    public int binarySearchRecursive(int []arr, int item, int start, int end){
        if(start > end) return -1;
        int mid = (start + end)/2;
        if(arr[mid] == item) return mid;
        else if(arr[mid] > item)
            return binarySearchRecursive(arr,item, start,mid - 1);
        return binarySearchRecursive(arr,item,mid + 1, end);
    }

}

public class SearchingPractice {
    public void binarySearchIterativeHelper(int []arr, int item){
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Item is found at : " + binarySearch.binarySearchIterative(arr, item ));
        System.out.println("Item is found at : " + binarySearch.binarySearchRecursive(arr, item,0,arr.length-1));

    }
    public void binarySearchRecursiveHelper(int []arr,int item){

    }
    public static void main(String[] args) {
        SearchingPractice solve = new SearchingPractice();
        solve.binarySearchIterativeHelper(new int[]{2,5,8,10,15,20}, 20);

    }
}
