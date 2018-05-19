/* 802.Find Eventual Safe States
directed graph, start at node,
and every turn, walk along a edge
when reach terminal, stop
we define start eventually safe if we can reach terminal from start eventually
there exists K, we must have stopped at a terminal node < K steps
input : graph
output: nodes are eventually safe
 * Thought Process:
start : each node
walk to any of children
end   : terminal

there seems no end for recursion this way
can we start from terminal?
start : terminal
from all incoming edges
end   : all node
 * Mentor :
In your solution, how do we do with loop?
Alright, follow me, a node is eventually safe if all its outgoing edges are to nodes that are eventually safe
Reverse thinking and Tomological sort is a good start, you got it, great. 
 */
package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class FindEventualSafeStates {

    public static void main(String[] args) {
        FindEventualSafeStates inst = new FindEventualSafeStates();
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> result = inst.eventualSafeNodes(graph);
        System.out.println(result);
    }
    
    Set<Integer> eventualSafe;
    Map<Integer, List<Integer>> inList;
    Map<Integer, List<Integer>> outList;
    int[] outDeg;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        eventualSafe = new HashSet<>();
        inList = new HashMap<>();
        outList = new HashMap<>();

        outDeg = new int[graph.length];
        buildGraph(graph);
        for (int i = 0; i < outDeg.length; i++) {
            if (outDeg[i] == 0) { // terminal 

                if (!inList.containsKey(i)) {
                    eventualSafe.add(i);
                    continue;
                }
                eventualSafeNodesFrom(i, graph);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int node : eventualSafe) {
            result.add(node);
        }
        Collections.sort(result);
        return result;
    }

    private void buildGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            outList.put(i, new ArrayList<>());
            for (int node : graph[i]) {
                outList.get(i).add(node);
                if (!inList.containsKey(node)) {
                    inList.put(node, new ArrayList<>());
                }
                inList.get(node).add(i);
            }
            outDeg[i] = graph[i].length;
        }
    }

    private void eventualSafeNodesFrom(int startTerminal, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startTerminal);
        while (!q.isEmpty()) {
            int cur = q.poll();
            eventualSafe.add(cur);
            if (!inList.containsKey(cur)) {
                continue;
            }
            for (int neigh : inList.get(cur)) {
                outList.get(neigh).remove((Object) cur);
                if (outList.get(neigh).isEmpty()) {
                    q.add(neigh);
                }
            }
        }
    }
}
