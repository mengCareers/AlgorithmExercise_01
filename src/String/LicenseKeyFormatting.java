/*
1st group, len <= K, with >=1 char
rest group, len = k
between group -
lowercase to upper case

each part has 4 characters.
 * Thought Process:
 * 
 */
package String;

/**
 *
 * @author xinrong
 */
public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String S ="--a-a-a-a--";
        int K = 2;
        String ans = licenseKeyFormatting(S, K);
        System.out.println(ans);
    }

    public static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (Character.isAlphabetic(c)) {
                sb.append(String.valueOf(c).toUpperCase());
            } else if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                continue;
            }
            cnt++;
            if (cnt == K) {
                sb.append('-');
                cnt = 0;
            }
        }
        // CORNER CASE
        if (sb.length() - 1 >= 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
