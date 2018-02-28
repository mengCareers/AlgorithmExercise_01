/* 127. Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord
- Only one letter can be changed at a time.
- Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
e.g. Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]
    As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.
* Thought Process:
q
 * 
 */
package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        int lvl = 1;
        while (!q.isEmpty()) {
            int lvlnum = q.size();
            for (int l = 0; l < lvlnum; l++) {
                String ps = q.poll(); // hit
                if (ps.equals(endWord)) {
                    return lvl;
                }
                for (int i = 0; i < ps.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] pc = ps.toCharArray();
                        pc[i] = c;
                        String nps = new String(pc);
                        if (dict.contains(nps)) {
                            if (!visited.contains(nps)) {
                                q.add(nps);
                                visited.add(nps);
                            }
                        }
                    }
                }
            }
            lvl++;
        }
        return 0;
    }
}
