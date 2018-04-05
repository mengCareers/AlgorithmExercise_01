/*
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class FenwickTree {

    int[] farr;

    public FenwickTree(int sz) {
        farr = new int[sz + 1]; // why plus 1
    }

    private static int lowbit(int ind) {
        return ind & (-ind);
    }

    public int rangeSum(int ind) {
        int sum = 0;
        while (ind > 0) {
            sum += farr[ind];
            ind = ind - lowbit(ind);
        }
        return sum;
    }

    public int rangeSum(int s, int e) {
        return rangeSum(e) - rangeSum(s - 1);
    }

    public void update(int ind, int v) {
        while (ind < farr.length) {
            farr[ind] += v;
            ind = ind + lowbit(ind);
        }
    }

    public static void main(String[] args) {
        int sz = 10;
        FenwickTree inst = new FenwickTree(sz);
        System.out.println("Init : ");
        for (int i = 1; i <= sz; i++) {
            System.out.print(inst.rangeSum(i, i) + " ");
        }
        System.out.println();
        // set
        System.out.println("--Set : ");
        for (int i = 1; i <= sz; i++) {
            inst.update(i, i + 1);
        }
        for (int i = 1; i <= sz; i++) {
            System.out.print(inst.rangeSum(i, i) + " ");
        }
        System.out.println();
        for (int i = 1; i <= sz; i++) {
            System.out.print(inst.farr[i] + " ");
        }
        System.out.println();
        // range sum
        System.out.println("--Range Sum : ");
        System.out.printf("from %d nd to %d nd = %d%n", 2, 4, inst.rangeSum(2, 4));
        // update
        System.out.println("--Update : ");
        inst.update(2, 5);
        for (int i = 1; i <= sz; i++) {
            System.out.print(inst.rangeSum(i, i) + " ");
        }
        System.out.println();
        for (int i = 1; i <= sz; i++) {
            System.out.print(inst.farr[i] + " ");
        }
        System.out.println();
        // range sum
        System.out.println("--Range Sum : ");
        System.out.printf("from %d nd to %d nd = %d%n", 2, 4, inst.rangeSum(2, 4));
    }
}
