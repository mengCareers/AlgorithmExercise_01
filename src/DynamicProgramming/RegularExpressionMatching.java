/* 10. Regular Expression Matching
input : s, p(attern)
    implement regular expression matching with support for '.' abd '*'
output: true if s matches p
 * Thought Process:
according to examples,
match entire string
* means zero or more of the preceding element
. any character
e.g.mississippi
    mis*is* p
if a*c, aaab,
        a* c   not match
The problem is to check if s[0..slen - 1] matches p[0..plen - 1].
We define the STATE as : dp[i][j] true if s[0..i] matches p[0..j].
Then, our END(AIM) STATE is : dp[slen - 1][plen - 1]
STATE TRANSFER : 
    imagine we are standing at s[i] and p[j], 
    what's next, 
    if p[j] == s[i], dp[i][j] = dp[i-1][j-1]
    else
      if p[j] = ., dp[i][j] = dp[i-1][j-1]
      if p[j] = *, 
      + if (s[i] != p[j-1])
        means 0  preceding element   dp[i][j] = dp[i][j-2]  
                    e.g.  ..dcbb
                               i
                        ..dcbbb*
                               j
      + if (s[i] == p[j-1] || p[j-1] == .)
        means 0  preceding element  dp[i][j] = dp[i][j-2]
        means 1 preceding element   dp[i][j] = dp[i][j-1] 
        means >1 preceding element  dp[i][j] = dp[i-1][j]
=> i-1,i-2 exist in dp array indices, so we move rightdown dp,


 END(AIM) STATE is : dp[dp.length - 1][dp[0].length - 1];                           
 the first row and column are meaning less, we need to make sure they won't affect states depending on them
    i.e. j = 1
MENTOR :
"aab"
"c*a*b" will return true
 * 
 */
package DynamicProgramming;

/**
 *
 * @author xinrong
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "movis";
        System.out.println(s.charAt(-1));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return s == p;
        }
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*') { // * is promised not to be the first char
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pArray[j - 1] == sArray[i - 1] || pArray[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pArray[j - 1] == '*') {
                    if (sArray[i - 1] == pArray[j - 2] || pArray[j - 2] == '.') {
                        dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
