/*

6.QUEST FOR THE HIDDEN CODE


In a remote village, there existed two mystical strings S1 and S2. in these strings was hidden a secret encoded in 
their characters.

Your task is to find and return an integer value representing the encoded secret of the strings by finding the sum of 
the ASCII values of the characters in the longest common substring between these two strings . Return o if there is no 
common substring.


NOTE:

-> String S1 and S2 contain English alphabets in lower case only.

-> if there are multiple longest common substrings , then return the ASCII sum of the substring that occurs first.


Input specification:
--------------------

input1: A string value S1
input2: A string value S2


Output specification:
---------------------

Return an integer value Representing the encoded secret of the strings by finding the sum of the ASCII values of the 
characters in the longest common substring between these two strings.




Example 1:
----------

input1: adventure
input2:future


Output: 448

Explanation:
------------
Here , the string S1 is "adventure" and S2 is "future" .The longest common substring between S1 and S2 is "true"
with their ASCII values summing up to 448 (116 + 117+114+101).Therefore, 448 is returned as the output.


Example 2:
----------

input1: mystery
input2: legend

Output: 101

Explanation:
------------

Here, the string S1 is "mystery" and S2 is "legend" .The longest common substring between S1 and S2 is "e", 
with its ASCII value summing up to 101, Therefore, 101 is returned as the output.


*/
public class HiddenCode {
    public static int longestCommonSubstringAsciiSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        int endIndex = -1; // End index in s1 of longest common substring

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                }
            }
        }

        if (maxLen == 0) return 0;

        String longestCommon = s1.substring(endIndex - maxLen, endIndex);
        int sum = 0;
        for (char ch : longestCommon.toCharArray()) {
            sum += (int) ch;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstringAsciiSum("adventure", "future"));  // Output: 448
        System.out.println(longestCommonSubstringAsciiSum("mystery", "legend"));   // Output: 101
    }
}
