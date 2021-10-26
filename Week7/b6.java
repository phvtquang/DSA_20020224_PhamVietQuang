import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   
    
    static void qsort(arrList<Integer> arr, int low, int high){
        
        if(low < high){
            int p = partition(arr,low,high);
             
            printarr(arr);
            qsort(arr,low,p-1);
            qsort(arr,p+1,high);
        }
    }
    
    static int partition(arrList<Integer> arr, int low, int high){
        int pivot = arr.get(high);
         
        int i = low;
        for(int j = low; j < high; j++){
            if(arr.get(j) < pivot){
                arr = swap(arr,i,j);
                ++i;
            }
        }
        arr = swap(arr,i,high);
     
        return i;
    }
    
    static arrList<Integer> swap(arrList<Integer> arr, int position1, int position2){
        int smallerValue = arr.get(position1);
        int biggerValue = arr.get(position2);
        arr.set(position1,biggerValue);
        arr.set(position2,smallerValue);
        
        return arr;
    }

    
    static void printarr(arrList<Integer> arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arrList <Integer> array = new arrList<Integer>();
        while(sc.hasNext()){
            array.add(sc.nextInt());
        }
        qsort(array, 0, n-1);  
    }
}