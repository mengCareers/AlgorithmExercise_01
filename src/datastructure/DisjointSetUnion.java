/* 
can be used to detect cycle
    cycle exists if subset of both vertices of every edge equal
 * Thought Process:
根节点不重要，我们需要的是验证图的连通性
一个连通图是不会有两个根结点的
 * 
 */
package datastructure;

import java.util.Scanner;

/**
 *
 * @author xinrong
 */
public class DisjointSetUnion {

    static int[] pre;

    static int find(int x) {
        int r = x;
        while (pre[r] != r) {
            r = pre[r];
        }
        int i = x, j;
        while (pre[i] != r) {
            j = pre[i];
            pre[i] = r;
            i = j;
        }
        return r;
    }

    static void join(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            pre[fx] = fy;
        }
        // we may fx = fy if needed
    }
}
