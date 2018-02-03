/* Topo
Topo is impossible if a graph is not DAG, mainly used for scheduling jobs from given dependencies among jobs
The 1st vertex in topo is always a vertex with in-degree as 0 (not incoming edges)

 * Vector is a growable array of objects
Vector is similar to ArrayList but the differences are, 
it is synchronized and its default initial size is 10 and when the size exceeds its size increases to double of the original size that means the new size will be 20
* Thought Process:
A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
s1 compute indegree for each of the vertex present and initialize the count of visited nodes as 0.
s2 pick all the vertices with indegree as 0 and add them into a queue
s3 remove a vertex from queue and then
    increment cnt of visited nodes by 1
    decrese indegree by 1 for all its neightboring nodes
    if indegree of a neighboring nodes is reduced to 0, add it to the queue
s4 repeat s3 until the queue is empty
s5 if cnt of visited nodes is not equal to the # of nodes in the graph then the topo sort if not possible

Then how to find indegree of each node?
  for node in Nodes, indegree[node] = 0; for each edge(src, dest) in Edges, indegree[dest]++;
  for node in Nodes, if (list[node].size != 0)
                                    for each dest in list indegree[dest]++;
 */
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

/**
 *
 * @author xinrong
 */
class Graph{
    int V; // # of vertices
    List<Integer>[] adj; // array of list contains reference to adjacency list
    
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    
    public void addEdge(int u, int v) {
        adj[u].add(v);
    }
    
    public void topologicalSort() {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>)adj[i];
            for (int node : temp) {
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int cnt = 0; // cnt of visited vertices
        Vector<Integer> topOrder = new Vector<Integer>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topOrder.add(u);
            for (int node : adj[u]) {
                if (--indegree[node] == 0) q.add(node);
            }
            cnt++;
        }
        if (cnt != V) {
            System.out.println("There exists a cycle in graph");
            return;
        }
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }
    
}

public class TopologicalSorting {
    // Kahn’s algorithm (BFS)
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        g.topologicalSort();
    }
}
