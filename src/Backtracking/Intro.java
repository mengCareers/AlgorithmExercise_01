/*
 * Thought Process:
 * It is 对解空间DFS
      implemented by 递归
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class Intro {
    List<List<Integer>> res; // 解集合
    List<Integer> cur;       // 单个解 
    
    public List<List<Integer>> driver(int n) { // n - 1 -> 最深搜索深度
        
        res = new ArrayList<>(); 
        cur = new ArrayList<>();
        
        backtrack(0, n);
        
        return res;
    }
    
    private void backtrack(int movei, int n) { // movei - 当前搜索深度
        
        if (withinConstraint(cur)) {
            res.add(new ArrayList<>(cur));
            return;
        }    
        
        if (movei == n) // if movei 超出 最深搜索深度, return;
            return;
        
        // for child of movei
//        for (int i = ..; i < ..; i++) { 
//            cur.add(...);
//            backtrack(i + 1, n);
//            cur.remove(cur.size() - 1);    // clean up for backtracking
//        }
    }

    private boolean withinConstraint(List<Integer> cur) {
        // false if not satisfy constraint
        // sometimes all cur are valid to be added to res e.g. Subsets
        return true;
    }
}
