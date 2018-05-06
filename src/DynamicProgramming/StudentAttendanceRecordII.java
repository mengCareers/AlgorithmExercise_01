/* 552. Student Attendance Record II
Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. 
A student attendance record is a string that only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late). 
* Thought Process:
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
? public class StudentAttendanceRecordII {

    public static void main(String[] args) {
        new StudentAttendanceRecordII().checkRecord(1);
    }

    long M = 1000000007;

    public int checkRecord(int n) {
        long[] f = new long[n <= 5 ? 6 : n + 1];
        f[0] = 1;
        f[1] = 2;
        f[2] = 4;
        f[3] = 7;
        for (int i = 4; i <= n; i++) {
            f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
        }
        long sum = f[n];
        for (int i = 1; i <= n; i++) {
            sum += (f[i - 1] * f[n - i]) % M;
        }
        return (int) (sum % M);
    }
}
