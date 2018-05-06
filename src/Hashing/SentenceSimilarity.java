/* 734. Sentence Similarity
 * Thought Process:
=> build map, u = words1[i], v = words2[i]
=> return true if
map.get(u).contains(v)
u not in map but u equals to v
 */
package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class SentenceSimilarity {

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        int wlen1 = words1.length, wlen2 = words2.length;
        if (wlen1 != wlen2) {
            return false;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            String u = pair[0];
            String v = pair[1];
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<>());
            }
            map.get(u).add(v);
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }
        for (int i = 0; i < wlen1; i++) {
            if (!map.get(words1[i]).contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
}
