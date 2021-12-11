package Graphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public class Graph {

    ArrayList<Integer>[] adj = new ArrayList[100];;

    public Graph() {
        //ArrayList<Integer>[] adj = new ArrayList[100];
    }

    void AddEdge(int v1, int v2) {
        adj[v1].add(v2);
        adj[v2].add(v1);
    }
    void RmEdge(int v1,int v2) {
        for (int i = 0; i < adj[v1].size(); i++) {
            if (adj[v1].get(i) == v2) {
                adj[v1].remove(i);
                break;
            }
        }

        for (int i = 0; i < adj[v2].size(); i++) {
            if (adj[v2].get(i) == v1) {
                adj[v2].remove(i);
                break;
            }
        }

    }
    void AddVer(int v) {
        adj[v] = new ArrayList<Integer>();
    }
    void RmVer(int v) {
        for (int i = 0; i < adj[v].size(); i++) {
            RmEdge(v,adj[v].get(i));
        }
        adj[v] = null;
    }
    boolean HasEdgeBetween(int v1, int v2) {
        for (int i = 0; i < adj[v1].size(); i++) {
            if (adj[v1].get(i) == v2) {
                return true;
            }
        }
        return false;
    }
    ArrayList<Integer> GetAdjVer(int v) {
        return adj[v];
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.AddVer(1);
        graph.AddVer(2);
        graph.AddVer(3);
        graph.AddVer(4);
        graph.AddVer(5);

        graph.AddEdge(1,2);
        graph.AddEdge(2,3);
        graph.AddEdge(2,4);
        graph.AddEdge(2,5);
        graph.AddEdge(3,5);
        graph.AddEdge(4,5);

        //TEST HAS EDGE
        System.out.println(graph.HasEdgeBetween(5,2));

        for (int i = 0; i < graph.adj.length; i++) {
            if (graph.adj[i] != null) {
                System.out.print(" VERTEX : " + i + " EDGE : ");
                for (int j = 0; j < graph.GetAdjVer(i).size(); j++) {
                    System.out.print(graph.GetAdjVer(i).get(j));
                }
                System.out.println();
            }
        }

        System.out.println("REMOVE EDGE");

        //TEST RM
        graph.RmEdge(2,1);

        for (int i = 0; i < graph.adj.length; i++) {
            if (graph.adj[i] != null) {
                System.out.print(" VERTEX : " + i + " EDGE : ");
                for (int j = 0; j < graph.GetAdjVer(i).size(); j++) {
                    System.out.print(graph.GetAdjVer(i).get(j));
                }
                System.out.println();
            }
        }

        //TEST RM VER
        System.out.println("AFTER REMOVE VER");

        graph.RmVer(1);

        for (int i = 0; i < graph.adj.length; i++) {
            if (graph.adj[i] != null) {
                System.out.print(" VERTEX : " + i + " EDGE : ");
                for (int j = 0; j < graph.GetAdjVer(i).size(); j++) {
                    System.out.print(graph.GetAdjVer(i).get(j));
                }
                System.out.println();
            }
        }

    }

}
