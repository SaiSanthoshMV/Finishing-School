// Mr. Param is working with Strings.
// He is given a String S. He has to find the palindromes in S, 
// A palindrome can be a substring of S (Strictly substrings only, not subsequences).

// Your task is to find the count the number of palindromes can be formed from S.

// NOTE: Count each occurence of palindromes if duplicate substrings found. 

// Input Format:
// -------------
// A string S

// Output Format:
// --------------
// Print an integer, number of palindromes.

// Sample Input-1:
// ---------------
// divider

// Sample Output-1:
// ----------------
// 9

// Explanation:
// -------------
// Palindromes are d, i, v, i, d, e, r, ivi, divid

// Sample Input-2:
// ---------------
// abcdef

// Sample Output-2:
// ----------------
// 6

// Explanation:
// -------------
// Palindromes are a, b, c, d, e, f.

import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isPalindrome(s.substring(i, j)))
                    count += 1;
            }
        }
        System.out.println(count);
        in.close();

    }

    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}