/*
 * Thought Process:
Attention : Provided 
```
        String[][] equations = {{"4", "2"}};
        double[] values = {2.0};
        String[][] queries = {{"2", "2"}};
```
The graph Map is as below :
				"4"=>("2"= 2.0)           "2"=>("4"= 0.5) 
In dfsEquation() :
				"2" -> "4" -> "2"
				0.5    *	2.0    = 1.0
             
 * 
 */
package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class EvaluateDivision {
    
    public static void main(String[] args) {
        EvaluateDivision inst = new EvaluateDivision();
        String[][] equations = {{"4", "2"}};
        double[] values = {2.0};
        String[][] queries = {{"4", "4"}};
        inst.calcEquation(equations, values, queries);
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        /**
         * e.g. a / b = 2.0, b / c = 3.0 in the Map graph: 
         * "a"=>("b"= 2.0)
         * "b"=>("a"= 0.5)  ("c"= 3.0) 
         * "c"=>("b"=0.333)
         */
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String st, en;
        int vi = 0;
        double[] res = new double[queries.length];

        // to build the graph to represent equations and corresponding values
        for (int i = 0; i < equations.length; i++) {
            st = equations[i][0];
            en = equations[i][1];
            if (graph.get(st) == null) {
                graph.put(st, new HashMap<>());
            }
            graph.get(st).put(en, values[i]);
            if (graph.get(en) == null) {
                graph.put(en, new HashMap<>());
            }
            graph.get(en).put(st, (double) 1 / values[i]);
        }

        // to get the result for each query
        for (int i = 0; i < queries.length; i++) {
            st = queries[i][0];
            en = queries[i][1];
            res[i] = dfsEquation(st, en, graph, new HashSet<>());
        }

        return res;

    }

    private double dfsEquation(String st, String en, Map<String, Map<String, Double>> graph, HashSet<String> visited) {
        if (graph.get(st) == null || graph.get(en) == null || visited.contains(st)) {
            return -1.0;
        }
        visited.add(st);
        if (graph.get(st).get(en) != null) {
            return graph.get(st).get(en);
        }
        for (String k : graph.get(st).keySet()) {
            double tres = dfsEquation(k, en, graph, visited);
            if (tres != -1.0) {
                return tres * graph.get(st).get(k);
            }
        }
        return -1.0;
    }

}
