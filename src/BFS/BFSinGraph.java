/*
Get:
- Why we use boolean visited array in BFS of Graph?
Unlike trees, graphs may contain cycles, so we may com to same node infinite times .

- What is Graph Search?
Solution from A to B || all possibilities starting from A

- Why use Adjacency List to represent Graph?
If not, we use set of vertices & set of edges, then we want to add a vertex,
We only can iterate the edges set to get its neighbors.

- e.g. of BFS — Pocket Cube : 2 * 2 * 2
1. Configuration : Vertex for each possible state of cube
		       Edge for each possible move
   From solved - oneMove - twoMoves …
   Construct the Graph one layer at a time until done, and we know the diameter.

- Graph representation
Adjacency lists: array Adj of |V| linked lists
Adj[u] store u’s neighbors
In Object-Oriented fashion: v.neighbors = Adj[v]
In Implicit (space-saved) way: Adj(u) is a func
                      v.neighbors is a method

 */
package BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class BFSinGraph {
    class Graph {
        private int V; // # of nodes;
        private LinkedList<Integer>[] adj; // adjacency list : arrays of linkedlist
    
        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adj[i] = new LinkedList();
        }
        
        // Func to add an edge to a graph
        void addEdge(int v, int w) {
            adj[v].add(w);
        }
        // BFS starting from s
        void BFS(int s) {
            boolean visited[] = new boolean[V];
            Queue<Integer> q = new LinkedList<>();
            visited[s] = true;
            q.add(s);
            while (!q.isEmpty()) {
                s = q.poll();
                System.out.print(s + " ");
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        q.add(n);
                    }
                }
            }
        }
    }
}
