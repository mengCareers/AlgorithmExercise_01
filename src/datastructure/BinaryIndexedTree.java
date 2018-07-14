/*
树状数组
于数据压缩的。 现在它常常被用于存储频率及操作累积频率表
 * Thought Process:
 * 
 */
package datastructure;

/**
 *
 * @author xinrong
 */
public class BinaryIndexedTree {

    int[] e;

    public BinaryIndexedTree(int sz) {
        e = new int[sz + 1]; // plus 1 for e[0] should equal to 0 but rightmostOne(0) != 0
                             //            rightmostOne(1) = 0 so e[1] will promise to be 0, so we set 1 as start
    }

    /**
     * rightmostOne(4) = 4
     * rightmostOne(6) = 2
     * rightmostOne(7) = 1
     * @param ind
     * @return 
     */
    private static int rightmostOne(int num) {
        return num & (~num + 1);
    }

    /**
     * if i = 7
     * sum = e[7] + e[6] + e[4]       
     * @param i
     * @return 
     */
    public int rangeSumFromStart(int i) {
        int sum = 0;
        while (i > 0) {
            sum += e[i];
            i = i - rightmostOne(i);
        }
        return sum;
    }

    public int rangeSum(int s, int e) {
        return rangeSumFromStart(e) - rangeSumFromStart(s - 1);
    }

    /**
     * a[i] += v
     * 则对e[i]及后续坐标有影响
     * @param i
     * @param v 
     */
    public void update(int i, int v) {
        while (i < e.length) {
            e[i] += v;
            i = i + rightmostOne(i);
        }
    }

    public static void main(String[] args) {
        int sz = 10;
        BinaryIndexedTree inst = new BinaryIndexedTree(sz);
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
            System.out.print(inst.e[i] + " ");
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
            System.out.print(inst.e[i] + " ");
        }
        System.out.println();
        // range sum
        System.out.println("--Range Sum : ");
        System.out.printf("from %d nd to %d nd = %d%n", 2, 4, inst.rangeSum(2, 4));
    }
}
