/*
 * Thought Process:
 * 
 */
package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class GraphLec {

    public static void main(String[] args) {

        GraphLec g = new GraphLec();
//        g.BFS("A");
//        g.DFS("A");
//        boolean ans = g.isReachable("A", "G");
//        List<List<String>> allRes = g.printAllPaths("A", "F");
        g.isHamiltonianCycle();
    }

    List<String> resForHam = new ArrayList<>();

    // a graph cycle (i.e., closed loop) through a graph that visits each node exactly once
    public boolean isHamiltonianCycle() {
        boolean hasHam = hasHamUtil("A");
        if (hasHam) {
            System.out.println(resForHam);
        }
        return hasHam;
    }

    private boolean isSafe(String v, String prev) {
        boolean connected = false;
        for (int i = 0; i < nodes.get(prev).listEdges.size(); i++) {
            if (v.equals(nodes.get(prev).listEdges.get(i).endNode)) {
                connected = true;
                break;
            }
        }
        if (!connected) {
            return false;
        }
        if (resForHam.contains(v)) {
            return false;
        }
        return true;
    }

    private boolean hasHamUtil(String cur) {
        for (int i = 0; i < nodes.get(cur).listEdges.size(); i++) {
            String v = nodes.get(cur).listEdges.get(i).endNode;
            if (v == "A") {
                resForHam.add(v);
                if (resForHam.size() == nodes.size()) {
                    return true;
                }
            }
            if (isSafe(v, cur)) {
                resForHam.add(v);
                if (hasHamUtil(v)) {
                    return true;
                }
                resForHam.remove(v);
            }
        }
        return false;
    }

    public List<List<String>> printAllPaths(String source, String dest) {
        Set<String> visited = new HashSet<>();
        List<String> curRes = new ArrayList<>();
        curRes.add(source);
        List<List<String>> allRes = new ArrayList<>();
        printPath(visited, source, dest, curRes, allRes);
        return allRes;
    }

    private void printPath(Set<String> visited, String cur, String dest, List<String> curRes, List<List<String>> allRes) {
        if (cur.equals(dest)) {
            allRes.add(new ArrayList(curRes));
            return;
        }
        visited.add(cur);
        Node cn = nodes.get(cur);
        for (int i = 0; i < cn.listEdges.size(); i++) {
            if (!visited.contains(cn.listEdges.get(i).endNode)) {
                curRes.add(cn.listEdges.get(i).endNode);
                printPath(visited, cn.listEdges.get(i).endNode, dest, curRes, allRes);
                curRes.remove(cn.listEdges.get(i).endNode);
            }
        }
        visited.remove(cur);
    }

    public boolean isReachable(String startNode, String endNode) {
        if (!nodes.containsKey(startNode) || !nodes.containsKey(endNode)) {
            return false;
        }
        resetVisited();
        Queue<Node> q = new LinkedList<>();
        q.add(nodes.get(startNode));
        while (!q.isEmpty()) {
            Node pn = q.poll();
            if (pn.name.equals(endNode)) {
                return true;
            }
            if (!pn.visited) {
                pn.visited = true;
                for (int i = 0; i < pn.listEdges.size(); i++) {
                    q.add(nodes.get(pn.listEdges.get(i).endNode));
                }
            }
        }
        return false;
    }

    public void DFS(String start) {
        if (!nodes.containsKey(start)) {
            return;
        }
        System.out.println("Starting DFS from " + start);
        resetVisited();
        Stack<Node> stack = new Stack<>();
        stack.push(nodes.get(start));
        while (!stack.empty()) {
            Node pn = stack.pop();
            if (!pn.visited) {
                pn.visited = true;
                System.out.print(pn.name + ", ");
                for (int i = 0; i < pn.listEdges.size(); i++) {
                    if (!nodes.get(pn.listEdges.get(i).endNode).visited) {
                        stack.push(nodes.get(pn.listEdges.get(i).endNode));
                    }
                }
            }
        }
        System.out.println("DFS Done");
    }

    public void BFS(String start) {
        if (!nodes.containsKey(start)) {
            return;
        }
        int counter = 1;
        System.out.println("Starting BFS from " + start);
        resetVisited();
        Queue<Node> q = new LinkedList<>();
        q.add(nodes.get(start));
        q.add(null);
        while (!q.isEmpty()) {
            Node pn = q.poll();
            if (pn != null) {
                if (!pn.visited) {
                    pn.visited = true;
                    System.out.print(pn.name + ", ");
                    for (int i = 0; i < pn.listEdges.size(); i++) {
                        q.add(nodes.get(pn.listEdges.get(i).endNode));
                    }
                }
            } else {
                if (q.isEmpty()) {
                    break;
                }
                System.out.println("Level " + counter);
                counter++;
                q.add(null);
            }
        }
        System.out.println("Level " + counter);
    }

    String startNode;
    Map<String, Node> nodes;

    public GraphLec() {
        startNode = "";
        nodes = new HashMap<>();
        init();
        resetVisited();
    }

    private void init() {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        A.addEdge("B", 1);
        B.addEdge("C", 1);
         B.addEdge("D", 1);
        // B.addEdge("E", 1);
        C.addEdge("A", 1);
        //D.addEdge("E", 1);
        //E.addEdge("F", 1);
        //G.addEdge("D", 0);
        nodes.put("A", A);
        nodes.put("B", B);
        nodes.put("C", C);
        nodes.put("D", D);
//        nodes.put("E", E);
//        nodes.put("F", F);
//        nodes.put("G", G);
    }

    public void setStartNode(String startNode) {
        if (nodes.containsKey(startNode)) {
            this.startNode = startNode;
        }
    }

    public void addNode(Node nodeToAdd) {
        if (nodes.containsKey(nodeToAdd.name)) {
            return;
        }
        nodes.put(nodeToAdd.name, nodeToAdd);
    }

    public void resetVisited() {
        for (String k : nodes.keySet()) {
            nodes.get(k).visited = false;
        }
    }

    class Node {

        String name;
        boolean visited;
        List<Edge> listEdges;

        private Node() {

        }

        public Node(String name) {
            this.name = name;
            visited = false;
            listEdges = new ArrayList<>();
        }

        public boolean addEdge(String endNodeToAdd, int weight) {
            for (int i = 0; i < listEdges.size(); i++) {
                if (endNodeToAdd == listEdges.get(i).endNode) {
                    return false;
                }
            }
            Edge edge = new Edge(weight, this.name, endNodeToAdd);
            listEdges.add(edge);
            return true;
        }

        public List<String> getNeighbours() {
            List<String> neighbours = new ArrayList<>();
            for (int i = 0; i < listEdges.size(); i++) {
                neighbours.add(listEdges.get(i).endNode);
            }
            return neighbours;
        }

        public int getNumEdges() {
            return listEdges.size();
        }

    }

    class Edge {

        String startNode;
        String endNode;
        int weight;

        private Edge() {

        }

        public Edge(int weight, String startNode, String endNode) {
            this.weight = weight;
            this.startNode = startNode;
            this.endNode = endNode;
        }

    }

}
