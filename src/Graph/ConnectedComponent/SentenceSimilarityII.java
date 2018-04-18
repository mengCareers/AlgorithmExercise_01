/* 737.Sentence Similarity II
 * Thought Process:
Union Find
undirected graph <= pairs
pre[w1] = 
 * GET :
To take advantage of the Union Find Algorithm, we need to build the undirected graph first, i.e., pairs[][] in this case. Since UF template take INT as input normally, we simply assign a cnt to the word in pairs, and save them into Map index. We do UNION when we recognize already connected component.
Afterwards, we check if words in words1 are connected with those in words2 using FIND.
Never forget to initialize the parent[] in UF.
 */
package Graph.ConnectedComponent;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Integer> index = new HashMap<>();
        int cnt = 0;
        UF uf = new UF(pairs.length * 2);
        for (String[] pair : pairs) {
            for (String word : pair) {
                if (!index.containsKey(word)) {
                    index.put(word, cnt++);
                }
            }
            uf.union(index.get(pair[0]), index.get(pair[1]));
        }
        for (int i = 0; i < words1.length; i++) {
            String w1 = words1[i], w2 = words2[i];
            if (w1.equals(w2)) {
                continue;
            }
            if (!index.containsKey(w1) || !index.containsKey(w2) || uf.find(index.get(w1)) != uf.find(index.get(w2))) {
                return false;
            }
        }
        return true;
    }

    class UF {

        int[] parent;

        public UF(int N) {
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            int r = x;
            while (r != parent[r]) {
                r = parent[r];
            }
            int i = x, j;
            while (i != r) {
                j = parent[i];
                parent[i] = r;
                i = j;
            }
            return r;
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
