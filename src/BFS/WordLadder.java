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
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        int lvl = 1;
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }

        while (!q.isEmpty()) {
            int lvlsz = q.size();
            for (int li = 0; li < lvlsz; li++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return lvl;
                }
                for (int ci = 0; ci < word.length(); ci++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] ch = word.toCharArray();
                        ch[ci] = c;
                        String newWord = new String(ch);
                        if (!visited.contains(newWord) && dict.contains(newWord)) {
                            q.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            lvl++;
        }

        return 0;
    }
}
