/* 362. Design Hit Counter
Design a hit counter which counts the number of hits received in the past 5 minutes.

Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * Thought Process:
 * 
 */
package Design;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class HitCounter {

    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
        hc.hit(1);
        hc.hit(2);
        hc.hit(3);
        hc.getHits(4);
        hc.hit(300);
        hc.getHits(300);
        hc.getHits(301);
    }

    Map<Integer, Integer> hits;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        hits = new HashMap<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        hits.put(timestamp, hits.getOrDefault(timestamp, 0) + 1);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int hitCnt = 0;
        Iterator<Map.Entry<Integer, Integer>> iter = hits.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = iter.next();
            if (timestamp - 300 < entry.getKey()) {
                hitCnt += entry.getValue();
            }
        }
        return hitCnt;
    }
}
