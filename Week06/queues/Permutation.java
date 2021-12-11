import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> testDeque = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            String c = StdIn.readString();
            testDeque.enqueue(c);
        }

        Iterator<String> iterator = testDeque.iterator();
        while (iterator.hasNext() && k > 0) {
            StdOut.println(iterator.next());
            k--;
        }

    }
}
