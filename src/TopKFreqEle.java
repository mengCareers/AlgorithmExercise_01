/* 692. Top K Frequent Words
TP: e.g. a a b b b c
a 2
b 3
c 1
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class TopKFreqEle {

    public List<String> getKFreq(int k, String[] arr) {
        List<String> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> 
                (map.get(w1) != map.get(w2) ? map.get(w2) - map.get(w1) : w1.compareTo(w2)));
        for (String s : map.keySet()) {
            pq.add(s);
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }
        return res;
    }
}
