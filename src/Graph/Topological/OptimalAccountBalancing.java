/* 465. Optimal Account Balancing
input : transactions [[A, B, n], ..] A gave B $n
output : minimum number of transactions required to settle the debt
 * Thought Process:
Directed,  Acyclic, no, it is cyclic
BFS
 * GET:
If not DAG, we do not manage to analyze the state for DP or build the graph for Traversal
Most frequently, we try backtracking.
 * 
Intuition
To get an account balanced, we don't care where the balance comes from. We aim to make balance values of all accounts equal to 0 with minimum number of transactions :
debtMap <key : people's ID, value : debt amount>
Analysis
If we make the account of the person whoes ID is start balanced, i.e., debts[start] equal to 0, the problem becomes smaller for we do not need to care about start any more. We keep track the minimum count of transfers on the fly :
minCnt = Math.min(minCnt, minTransfersFrom(start + 1,debts, cntTransfers + 1));
There are many people who can balance start's account - people i behind with debt[i] * debt[start] < 0 :

for (int i = start + 1; i < debts.length; i++) {
            if (debts[i] * debts[start] < 0) {
						...
 */
package Graph.Topological;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class OptimalAccountBalancing {

    public static void main(String[] args) {
        int[][] transactions = {
            {0, 1, 10},
            {1, 0, 15},
            {1, 2, 20},
            {2, 0, 25}
        };
        OptimalAccountBalancing inst = new OptimalAccountBalancing();
        inst.minTransfers(transactions);
    }

    public int minTransfers(int[][] transactions) {
        Map<Integer, Long> debtMap = new HashMap<>();
        for (int[] t : transactions) {
            debtMap.put(t[0], debtMap.getOrDefault(t[0], 0L) - t[2]);
            debtMap.put(t[1], debtMap.getOrDefault(t[1], 0L) + t[2]);
        }
        Long[] debts = new Long[debtMap.size()];
        int di = 0;
        for (int k : debtMap.keySet()) {
            debts[di++] = debtMap.get(k);
        }
        return minTransfersFrom(0, debts, 0);
    }

    private int minTransfersFrom(int start, Long[] debts, int cntTransfers) {
        while (start < debts.length && debts[start] == 0) {
            start++;
        }
        if (start == debts.length) {
            return cntTransfers;
        }
        int minCnt = Integer.MAX_VALUE;
        for (int i = start + 1; i < debts.length; i++) {
            if (debts[i] * debts[start] < 0) {
                debts[i] += debts[start];
                minCnt = Math.min(minCnt, minTransfersFrom(start + 1, debts, cntTransfers + 1));
                debts[i] -= debts[start];
            }
        }
        return minCnt;
    }

}
