package w2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum {
    public static void main(String[] args) {
        In in = new In("C:\\Users\\phvtquang\\Desktop\\DSA\\resources\\8Kints.txt");
        int[] a = in.readAllInts();
        Stopwatch stopwatch = new Stopwatch();

        int c=0;

        // bruteforce
        for (int i = 0; i < a.length; i++) {
            for (int j=i+1; j < a.length; j++) {
                for (int k=j+1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        //System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        c++;
                    }
                }
            }
        }

        System.out.println(c);
        System.out.println(stopwatch.elapsedTime());
    }
}
