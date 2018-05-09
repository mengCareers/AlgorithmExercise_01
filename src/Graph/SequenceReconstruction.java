/* 
 Check whether org can be uniquely reconstructed from sequences in seqs
 org is a permutation of integers from 1 to n
 reconstruct : build a shortest common supersequence among sequences
 determine whether there is only one sequence that can be reconstructed from seqs 
                   and it is org
 * Thought Process:
 * one and only, topological sort, if no circle and the path is, then return true
 * Get :
 * org defined the topological order of seqs
That is, 
    seqs should contain all elements in org,
    element appear earlier in org should always appear earlier in seqs
            that is what we called one and only, restricted order
    to ensure unique, consecutive pairs in org will also appear in seqs
            that is, there must be an edge connect each pair of vertices in topological order
 *     for example: if org is [1, 2, 3]
 *                                               2
 *                                             /
 *     if seqs if [1, 2] [1, 3], the graph is 1 
 *                                             \
 *                                               3 (should be directional edges here)
 *     and no edge connect 2 and 3 in the topological order, so the order is not unique, it could be [1, 2, 3] or [1, 3, 2];
 *     if the seqs is [1, 2] [2, 3], then the order is unique.
 * Thought Process:
seqs can have topological sort only if it is DAG
seqs can have only one topological sort, orgs, only if 
                            there is an edge connect each pair of vertices in the topological order
We implement topological sort among seqs in BFS pattern,
to check if seqs is a DAG.
We compare inDegree.size() with org.length to restrict 
 */
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
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
public class SequenceReconstruction {

    public static void main(String[] args) {
        SequenceReconstruction inst = new SequenceReconstruction();
        int[] org = {1};
        List<List<Integer>> seqs = new ArrayList<>();
        List<Integer> seq = Arrays.asList(new Integer[]{});
        seqs.add(seq);
        seqs.add(seq);
        boolean result = inst.sequenceReconstruction(org, seqs);
        System.out.println(result);
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org == null || org.length == 0) {
            return seqs == null || seqs.size() == 0;
        }
        if (seqs == null || seqs.size() == 0) {
            return org == null || org.length == 0;
        }
        int N = org.length;
        List<List<Integer>> outList = new ArrayList<>();
        int[] inDegree = new int[N + 1]; // start from 1
        Set<Integer> nodeSet = new HashSet<>();
        for (int i = 0; i < N + 1; i++) {
            outList.add(new ArrayList<>());
        }
        for (List<Integer> seq : seqs) {
            if (seq.size() == 0) {
                continue;
            }
            if (seq.get(0) > N || seq.get(0) <= 0) {
                return false;
            }
            nodeSet.add(seq.get(0));

            for (int i = 1; i < seq.size(); i++) {
                if (seq.get(i) > N || seq.get(i) <= 0) {
                    return false;
                }
                nodeSet.add(seq.get(i));

                outList.get(seq.get(i - 1)).add(seq.get(i));
                inDegree[seq.get(i)]++;
            }
        }
        if (inDegree[org[0]] != 0 || nodeSet.size() != N) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int from = queue.poll();
            if (idx >= N || from != org[idx++]) {
                return false;
            }
            for (int to : outList.get(from)) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    queue.add(to);
                }
            }
        }
        return idx == N;
    }
}
