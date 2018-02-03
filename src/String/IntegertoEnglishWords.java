package String;

/*
input : num
output: english words representation of num
 * Get:
toWordsUtil(x,xxx / 1000) + " " + dict[x] + " " + toWordsUtil(x,xxx % 1000);
 * 
 */

/**
 *
 * @author xinrong
 */
public class IntegertoEnglishWords {
    String[] less_ten = 
    {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] less_twenty = 
    {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = 
    {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] hundreds =
    {"Hundred", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return toWordsUtil(num);
    }    
    public String toWordsUtil(int n) {
        String res = "";
        if (n < 10)
            res = less_ten[n];
        else if (n < 20)
            res = less_twenty[n % 10];
        else if (n < 100)
            res = tens[n / 10] + " " + toWordsUtil(n % 10);
        else if (n < 1000)
            res = toWordsUtil(n / 100) + " " + hundreds[0] + " " + toWordsUtil(n % 100);
        else if (n < 1000000)
            res = toWordsUtil(n / 1000) + " " + hundreds[1] + " " + toWordsUtil(n % 1000);
        else if (n < 1000000000)
            res = toWordsUtil(n / 1000000) + " " + hundreds[2] + " " + toWordsUtil(n % 1000000);
        else if (n >= 1000000000)
            res = toWordsUtil(n / 1000000000) + " " + hundreds[3] + " " + toWordsUtil(n % 1000000000);
        return res.trim();
    }
}
