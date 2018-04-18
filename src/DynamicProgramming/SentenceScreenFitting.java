/*
 * Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class SentenceScreenFitting {

    public static void main(String[] args) {
        String[] sentence = {"a", "bcd", "e"};
        int res = wordsTyping(sentence, 3, 6);
        // System.out.println(res);
    }

    public static int wordsTyping(String[] sentence, int rows, int cols) {

        int fullSentenceLen = 0;
        for (String s : sentence) {
            fullSentenceLen += (s.length() + 1);
        }

        int ri = 0;
        int si = 0;
        int wordsFilled = 0;

        while (ri < rows) {
            int space = cols;
            int repeat = space / fullSentenceLen;
            space -= repeat * fullSentenceLen;
            wordsFilled += repeat * sentence.length;

            while (space >= sentence[si].length()) {
                space -= sentence[si].length();
                if (space >= 1) {
                    space -= 1;
                }
                si++;
                si = si % sentence.length;
                wordsFilled++;
            }
            ri++;
        }
        return wordsFilled / sentence.length;

    }

    public int wordsTypingTLE(String[] sentence, int rows, int cols) {
        int rx = 0;
        int cnt = 0;
        int sidx = 0;
        while (rx < rows) {
            int cx = 0;
            while (cx < cols) {
                if (cx + sentence[sidx].length() <= cols) {
                    cx = cx + sentence[sidx].length() + 1;
                    sidx++;
                } else {
                    break;
                }

                if (sidx == sentence.length) {
                    cnt++;
                    sidx = 0;
                }
            }
            rx++;
        }
        return cnt;
    }
}
