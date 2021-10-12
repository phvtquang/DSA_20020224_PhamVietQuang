

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[11];
        int i=-1;
        Random rd = new Random();
        while (i<10) {
            i++;
            arr[i] = rd.nextInt();
        }
        // print before
        System.out.println("BEFORE : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();

        //selection sort
        for (int j = 0; j < arr.length-1; j++) {
            int min_index = j;
            for (int k = j+1; k < arr.length ; k++) {
                if (arr[k] < arr[min_index] ) {
                    min_index = k;
                    // swap
                    int t = arr[min_index];
                    arr[min_index] = arr [k];
                    arr[j] = t;
                }
            }
        }

        //print
        System.out.println("AFTER : ");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
}
