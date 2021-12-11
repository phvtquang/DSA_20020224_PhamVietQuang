package w2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\phvtquang\\Desktop\\DSA\\resources\\8Kints.txt");
        int[] a = in.readAllInts();

        Stopwatch stopwatch = new Stopwatch();

        int c=0;

        for (int i = 0; i < a.length; i++) {
            for (int j=i+1; j < a.length; j++) {
                if ( a[i] + a[j] == 0 ) {
                    c++;
                    //System.out.println(a[i] + " " + a[j]);
                }
            }
        }
        System.out.println(c);
        System.out.println(stopwatch.elapsedTime());


    }
}
