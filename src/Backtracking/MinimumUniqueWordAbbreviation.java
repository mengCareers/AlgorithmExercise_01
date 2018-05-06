/* 411. Minimum Unique Word Abbreviation
A string such as "word" contains the following abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.
 * Thought Process:
 * 
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class MinimumUniqueWordAbbreviation {

    public String minAbbreviation(String target, String[] dictionary) {
        StringBuilder allRes = new StringBuilder(target);
        generateAbbr(target, dictionary, new StringBuilder(), allRes, 0, 0);
        return allRes.toString();
    }

    /**
     * Utility Method to generate abbreviations of target
     * @param target
     * @param dictionary
     * @param curRes
     * @param allRes
     * @param abbrCnt
     * @param i 
     */
    private void generateAbbr(String target, String[] dictionary, StringBuilder curRes, StringBuilder allRes, int abbrCnt, int i) {
        int len = curRes.length();
        if (i == target.length()) {
            if (abbrCnt == 1) {
                return;
            }
            if (abbrCnt > 0) {
                curRes.append(abbrCnt);
            }
            if (!hasConflict(curRes, dictionary, target.length()) && curRes.length() < allRes.length()) {
                allRes.setLength(0);
                allRes.append(curRes);
            }
        } else {
            // if abbr target[i]
            generateAbbr(target, dictionary, curRes, allRes, abbrCnt + 1, i + 1);
            // if not abbr target[i]
            if (abbrCnt != 0) {
                curRes.append(abbrCnt);
            }
            curRes.append(target.charAt(i));
            generateAbbr(target, dictionary, curRes, allRes, 0, i + 1);
        }
        curRes.setLength(len);
    }

    /**
     * Utility Method to check if curRes, has conflict with abbreviations of the strings in the dictionary
     * @param curRes an abbreviation of the target
     * @param dictionary
     * @param targetLen
     * @return 
     */
    private boolean hasConflict(StringBuilder curRes, String[] dictionary, int targetLen) {
        String abbr = curRes.toString();
        for (String word : dictionary) {
            if (word.length() == targetLen) {
                if (canAbbr(word, abbr)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Utility Method to check if word can be abbreviated to abbr
     * @param word
     * @param abbr
     * @return 
     */
    private boolean canAbbr(String word, String abbr) {
        int wi = 0, ai = 0;
        while (wi < word.length() && ai < abbr.length()) {
            if (word.charAt(wi) == abbr.charAt(ai)) {
                wi++;
                ai++;
                continue;
            }
            if (abbr.charAt(ai) <= '0' || abbr.charAt(ai) > '9') {
                return false;
            }
            int abbrCnt = 0;
            while (ai < abbr.length() && (abbr.charAt(ai) >= '0' && abbr.charAt(ai) <= '9')) {
                abbrCnt = abbrCnt * 10 + abbr.charAt(ai) - '0';
                ai++;
            }
            wi += abbrCnt;
        }
        return wi == word.length() && ai == abbr.length();
    }

}
