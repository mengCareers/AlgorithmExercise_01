/* 604. Design Compressed String Iterator
Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
 * Thought Process:
When curCnt == totalCnt, we are done with curChar.
We reset curCnt, curChar.
And we update totalCnt when we relocate idx to next char.
 * 
 */
package Design;

/**
 *
 * @author xinrong
 */
public class DesignCompressedStringIterator {

    int idx;
    String compressedStr;
    int curCnt;
    int totalCnt;
    char curChar;

    public DesignCompressedStringIterator(String compressedString) {
        idx = 0;
        compressedStr = compressedString;
    }

    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        if (curCnt == totalCnt) {
            curCnt = 0;
            curChar = compressedStr.charAt(idx);
           
            totalCnt = 0;
            idx++;
            while (idx < compressedStr.length() && Character.isDigit(compressedStr.charAt(idx))) {
                totalCnt = totalCnt * 10 + (compressedStr.charAt(idx) - '0');
                idx++;
            }          
        }
        curCnt++;
        return curChar;
    }

    public boolean hasNext() {
        if (idx < compressedStr.length() || curCnt < totalCnt) {
            return true;
        }
        return false;
    }
}
