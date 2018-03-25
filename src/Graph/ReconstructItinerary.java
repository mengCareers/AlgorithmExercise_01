/*
 * Thought Process:
DCG Traversal => DFS implementation of Topological Sort
 */
package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}}; 
        List<String> ans = new ReconstructItinerary().findItinerary2(tickets);
        System.out.println(ans);
    }
    
    public List<String> findItinerary2(String[][] tickets) {
        LinkedList<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> outlist = new HashMap<>();

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
           
            if (!outlist.containsKey(from)) {
                outlist.put(from, new PriorityQueue<>());
            }
            outlist.get(from).add(to);
        }
        dfs("JFK", outlist, result);
        return result;
    }
    
    private void dfs(String node, Map<String, PriorityQueue<String>> outlist, LinkedList<String> result) {
        PriorityQueue<String> nodeadjs = outlist.get(node);
        while (nodeadjs != null && !nodeadjs.isEmpty()) {
            dfs(nodeadjs.poll(), outlist, result);
        }
        result.addFirst(node);
    }
/*
    public List<String> findItinerary(String[][] tickets) {
        List<List<String>> results = new ArrayList<>();

        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> outlist = new HashMap<>();

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            indegree.put(to, indegree.getOrDefault(to, 0) + 1);
            if (!outlist.containsKey(from)) {
                outlist.put(from, new ArrayList<>());
            }
            outlist.get(from).add(to);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("JFK");
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String from = queue.poll();
            result.add(from);
            if (!outlist.containsKey(from))
                continue;
            for (String to : outlist.get(from)) {
                int tmp = indegree.get(to) - 1;
                indegree.put(to, tmp);
                if (tmp == 0) {
                    queue.add(to);
                }
            }
        }
        results.add(result);

        Collections.sort(results, new Comparator<List<String>>() {
            public int compare(List<String> o1, List<String> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    int res = o1.get(i).compareTo(o2.get(i));
                    if (res != 0) {
                        return res;
                    }
                }
                return 0;
            }

        });

        return results.get(results.size() - 1);
    }
*/
}
