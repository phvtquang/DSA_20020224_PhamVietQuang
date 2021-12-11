package w2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;

public class FastThreeSum {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\phvtquang\\Desktop\\B\\DSA\\resources\\8KintsNODUPLICATE.txt");
        int[] a = in.readAllInts();

        Stopwatch stopwatch = new Stopwatch();

        int c=0;

        for (int i = 0; i < a.length; i++) {
            int currentTarget = 0 - a[i];

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int j=i+1; j<a.length; j++) {
                if ( hashMap.containsKey(currentTarget-a[j]) ) {
                    //System.out.println(a[i] + " " + a[j] + " " + (currentTarget-a[j]));
                    c++;       
                } else {
                    hashMap.put(a[j],j);
                }
            }
        }
        System.out.println(c);
        System.out.println(stopwatch.elapsedTime());

    }

}
