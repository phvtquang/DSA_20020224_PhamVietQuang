package w3;

import java.util.Arrays;
import java.util.Random;

/*
 * Binary Search Week3
 */
public class BSearch {
    public static int binarySearch(int[] a, int number) {
        int left = 0;
        int right = a.length-1;
        int mid = 0;
        while (left<=right) {
            mid = left+(right-left)/2;
            if (a[mid] == number) {
                return mid;
            } else
            if (a[mid] > number) {
                right = mid - 1;
            } else
            if(a[mid] < number) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(arr,rand.nextInt(10000)));
    }

}