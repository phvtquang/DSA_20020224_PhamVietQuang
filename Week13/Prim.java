import java.util.*;

public class Test {

    static class Cost implements Comparable<Cost> {
        public int r, v;
        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }
        @Override
        public int compareTo(Cost c) {
            if (r < c.r) return -1;
            if (r> c.r) return 1;
            if (v < c.v) return -1;
            if (v > c.v) return 1;
            return 0;
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Cost>[] graph = new ArrayList[n+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int startNode = scanner.nextInt();
            int endNode = scanner.nextInt();
            int w = scanner.nextInt();

            Cost cost = new Cost(w,endNode);
            graph[startNode].add(cost);
            Cost cost1 = new Cost(w,startNode);
            graph[endNode].add(cost1);
        }

        int startnode  = scanner.nextInt();
        ArrayList<Integer> visited = new ArrayList<>();
        visited.add(startnode);
        int res = 0;
        while (visited.size() != n) {
            int minNode = -1;
            int minW = 100;
            for (int i = 0; i < visited.size(); i++) { 
                for (int j = 0; j < graph[visited.get(i)].size(); j++) {   
                    if (!visited.contains(graph[visited.get(i)].get(j).v)) {
                        if(graph[visited.get(i)].get(j).r < minW) {
                            minNode = graph[visited.get(i)].get(j).v;
                            minW = graph[visited.get(i)].get(j).r;
                        }
                    }
                }
            }
            visited.add(minNode);
            res+=minW;
        }
        System.out.println(res);
    }
}
