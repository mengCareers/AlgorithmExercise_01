/* 551.Student Attendance Record I
You are given a string representing an attendance record for a student.
The record only contains the following three characters : 
A : Absent
L : Late
P : Present
A student could be rewarded if his record 'A' <= 1 and no consecutive'L' <= 2
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int cntA = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                cntA--;
                if (cntA < 0) {
                    return false;
                }
            } else if (c == 'L') {
                int j = i + 1;
                int cntL = 1;
                while (j < s.length()) {
                    if (s.charAt(j) == 'L') {
                        cntL--;
                        if (cntL < 0) {
                            return false;
                        }

                    } else {
                        break;
                    }
                    j++;
                }
            }
        }
        return true;
    }
}
