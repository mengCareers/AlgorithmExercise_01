/* 809.Expressive Words
input : S, words
output: # of word in words which can be extended to S
 * Thought Process:
how do we definer a word extensible ot S
we check S,
for ch in S,
aaabbccc
aabbccc
    if length of consecutive chs < 3, append the consecutive
    or else, append ch
            or the consecutive
 * GET :
If a word W in words is stretchy,

[Unique chars of S] must equal to [unique chars of W] and they should maintain the same order
=> we serialize unique chars as keyChars for comparison
e.g. bbccaaa keyChars = "bca"
we compare the frequency of corresponding unique char, we define :
[frequencies of unique char ch in S] - cntS,
[frequencies of unique char ch in W] - cntW,
  if (cntS < 3) cntW must equal to cntS;
  if (cntS >= 3) good;
  if (cntS < cntW) bad;
 */
package String;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class ExpressiveWords {

    public int expressiveWords(String S, String[] words) {
        int cnt = 0;
        Word wordS = new Word(S);
        for (String W : words) {
            Word wordW = new Word(W);
            if (!wordS.keyChars.equals(wordW.keyChars)) {
                continue;
            }
            int i = 0;
            for (; i < wordS.cntKeyChars.size(); i++) {
                int cntS = wordS.cntKeyChars.get(i);
                int cntW = wordW.cntKeyChars.get(i);
                if (cntS < 3 && cntS != cntW || cntS < cntW) {
                    break;
                }
            }
            if (i == wordS.cntKeyChars.size()) {
                cnt++;
            }
        }
        return cnt;
    }

    class Word {

        String keyChars;
        List<Integer> cntKeyChars;

        public Word(String s) {
            cntKeyChars = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            char[] sArr = s.toCharArray();
            int ptr = -1;
            for (int i = 0; i < sArr.length; i++) {
                if (i == sArr.length - 1 || sArr[i] != sArr[i + 1]) {
                    sb.append(sArr[i]);
                    cntKeyChars.add(i - ptr);
                    ptr = i;
                }
            }
            keyChars = sb.toString();
        }
    }
}
