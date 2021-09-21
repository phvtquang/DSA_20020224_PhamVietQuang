package w2;

import edu.princeton.cs.algs4.*;
public class UFClient2 {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        int c=0;
        while (!StdIn.isEmpty()) {
            c++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) != uf.find(q)) {
                uf.union(p,q);
            }
            for (int i=1; i<N; i++) {
                if (uf.find(i) != uf.find(i-1)) {
                    break;
                }
                if (i==N-1) {
                    StdOut.println(c);
                    return;
                }
            }
        }
        StdOut.println("FAILED");
    }
}
