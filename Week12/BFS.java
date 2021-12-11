import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int s) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>(adj.size());
        for (int i = 0; i < adj.size(); i++) {
            res.add(0);
        }
        queue.addFirst(s);

        while (q.size() > 0) {
            int current = q.pollLast();
            ArrayList<Integer> tmp = adj.get(current);
            for (int i = 0; i < tmp.size(); i++) {
                int v = tmp.get(i);
                if (res.get(v) == 0) {
                    q.addFirst(v);
                    res.set(v, res.get(current) + 6);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){

            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<Integer>());
            }

            int m = in.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                // First
                ArrayList<Integer> tmp = adj.get(u);
                tmp.add(v);
                adj.set(u, tmp);

                // Second
                tmp = adj.get(v);
                tmp.add(u);
                adj.set(v, tmp);
            }

            int s = in.nextInt() - 1;

            ArrayList<Integer> result = Solution.bfs(adj, s);

            for (int i = 0; i < n; i++) {
                if (i != s) {
                    if (result.get(i) == 0) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(result.get(i) + " ");
                    }
                }
            }
            System.out.print("\n");
        }
        in.close();
    }
}