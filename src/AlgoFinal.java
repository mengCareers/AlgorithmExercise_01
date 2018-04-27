
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class AlgoFinal {

    // <editor-fold defaultstate="collapsed" desc="Question 1">
    /**
     * Method to count the number of islands
     *
     * @param grid
     * @return The number of islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int cntIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    cntIslands++;
                }
            }
        }
        return cntIslands;
    }

    /**
     * Utility Method in a Depth-First-Search way
     *
     * @param x
     * @param y
     * @param grid
     */
    private void dfs(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        dfs(x + 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x - 1, y, grid);
        dfs(x, y - 1, grid);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Question 2">
    private int resultDiameter = 0;

    /**
     * Method to compute the length of the diameter of the tree
     *
     * @param root
     * @return The length of the diameter
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepth(root);
        return resultDiameter;
    }

    /**
     * Utility Method to get the Depth of a tree. To update the result diameter
     * on the fly as well.
     *
     * @param root
     * @return
     */
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        resultDiameter = Math.max(resultDiameter, left + right);
        return Math.max(left, right) + 1;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Question 3">
    /**
     * Method to count the number of ways to tile the given board using the 2 *
     * 1 tiles
     *
     * @param boardColumns The number of columns of the given board
     * @return The number of ways to tile
     */
    public int numberOfWaysToTile(int boardColumns) {
        if (boardColumns <= 2) {
            return boardColumns;
        }
        int[] cntWays = new int[boardColumns + 1];
        cntWays[1] = 1;
        cntWays[2] = 2;
        for (int i = 3; i <= boardColumns; i++) {
            cntWays[i] = cntWays[i - 1] + cntWays[i - 2];
        }
        return cntWays[boardColumns];
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Question 4">
    /**
     * Method to check if the given String is valid
     *
     * @param s
     * @return True if the given String is valid
     */
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Integer> leftIndices = new Stack<>();
        Stack<Integer> starIndices = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    leftIndices.push(i);
                    break;
                case ')':
                    if (!leftIndices.empty()) {
                        leftIndices.pop();
                    } else if (!starIndices.empty()) {
                        starIndices.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    starIndices.push(i);
                    break;
            }
        }
        while (!leftIndices.empty()) {
            int lefti = leftIndices.pop();
            if (starIndices.empty() || starIndices.pop() < lefti) {
                return false;
            }
        }
        return true;
    }
    // </editor-fold>

    /**
     * User Defined Class TreeNode
     */
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    /**
     * Driver Class to test the methods in class
     *
     * @param args
     */
    public static void main(String[] args) {
        AlgoFinal test = new AlgoFinal();

        System.out.println("Test Question 1 :");
        char[][] grid = new char[4][5];
        grid[0] = "11000".toCharArray();
        grid[1] = "11000".toCharArray();
        grid[2] = "00100".toCharArray();
        grid[3] = "00011".toCharArray();
        int cntIslands = test.numIslands(grid);
        System.out.println(cntIslands);

        System.out.println("Test Question 2 :");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int resultDiameter = test.diameterOfBinaryTree(root);
        System.out.println(resultDiameter);

        System.out.println("Test Question 3 :");
        for (int i = 1; i <= 10; i++) {
            System.out.print(test.numberOfWaysToTile(i) + " ");
        }
        System.out.println();

        System.out.println("Test Question 4 :");
        String s = "((*)";
        System.out.println(test.checkValidString(s));

    }
}
