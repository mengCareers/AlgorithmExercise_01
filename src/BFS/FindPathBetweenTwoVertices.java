/*
 * Thought Process: Take the 1st vertex as source in BFS, follow standard,
 * if see 2nd vertex during traversal, return true;
 */
package BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class FindPathBetweenTwoVertices {
    private int V; // # of nodes;
    private LinkedList<Integer>[] adj; // adjacency list : arrays of linkedlist
    
    FindPathBetweenTwoVertices(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }
    
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
    
    public boolean isReachable(int s, int d) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            s = q.poll();

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (n == d) return true;
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                }
            }
        }
        return false;
    }
    
    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        FindPathBetweenTwoVertices g = new FindPathBetweenTwoVertices(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
 
        u = 3;
        v = 1;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u +" to " + v);
        else
            System.out.println("There is no path from " + u +" to " + v);;
    }
}
