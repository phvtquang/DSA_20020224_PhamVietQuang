package w2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;

public class FastTwoSum {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\phvtquang\\Desktop\\DSA\\resources\\8Kints.txt");
        int[] a = in.readAllInts();

        int c = 0;

        Stopwatch stopwatch = new Stopwatch();

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i=0; i<a.length; i++) {
            hashMap.put(a[i],i);
            int diff = 0 - a[i];
            if (hashMap.containsKey(diff) && hashMap.get(diff) != i ) {
                //System.out.println(a[hashMap.get(diff)] + " " + a[i]);
                c++;
            }
        }
        System.out.println(c);
        System.out.println(stopwatch.elapsedTime());


    }
}
