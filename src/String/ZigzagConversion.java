/* 6. ZigZag Conversion
=> ri is used to represent current row number, riToAdd is used to control the shift among rows.
=> An array of StringBuilder is used to save results for each row.
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder[] sbArr = new StringBuilder[numRows];
//        for (StringBuilder sb : sbArr) {
//            sb = new StringBuilder();
//        }  NOT WORK
        for (int i = 0; i < sbArr.length; i++) {
            sbArr[i] = new StringBuilder();
        }
        int riToAdd = 1, ri = 0;

        for (int i = 0; i < s.length(); i++) {
            sbArr[ri].append(s.charAt(i));
            if (ri == 0) {
                riToAdd = 1;
            }
            if (ri == numRows - 1) {
                riToAdd = -1;
            }
            ri += riToAdd;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbArr) {
            res.append(sb);
        }
        return res.toString();
    }
}
