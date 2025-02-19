// Given a string s and an abbreviation abbr, determine whether abbr correctly 
// represents s by following the abbreviation rules.

// A valid abbreviation replaces consecutive characters in s with a number 
// representing the count of omitted characters while maintaining the sequence of the 
// remaining letters.

// For instance, the string "word" can be abbreviated in the following valid ways:
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

// Any abbreviation that deviates from this pattern is considered invalid.

// Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

// Input Format:
// -------------
// Line-1: A string, S contains only lowercase letters
// Line-2: A string, abbr contains lowercase letters and digits

// Output Format:
// --------------
// Line-1: A boolean value.
// Sample Input-1:
// ---------------
// internationalization
// i12iz4n

// Sample Output-1:
// ---------------
// true

// Sample Input-2:
// ---------------
// apple
// a2e

// Sample Output-2:
// ---------------
// false

// Time Complexity: O(n) where n=max(len(word),len(abbr))
// Auxiliary Space:  O(1).

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(isValidAbbr(s1, s2));
    }

    private static boolean isValidAbbr(String s1, String s2) {
        int l1 = 0, l2 = 0;
        while (l1 < s1.length() && l2 < s2.length()) {
            if (Character.isDigit(s2.charAt(l2))) {
                int num = 0;
                while (l2 < s2.length() && Character.isDigit(s2.charAt(l2))) {
                    num = num * 10 + Character.getNumericValue(s2.charAt(l2));
                    l2++;
                }
                l1 += num;
            } else {
                if (s1.charAt(l1) != s2.charAt(l2)) {
                    return false;
                }
                l1++;
                l2++;
            }
        }
        return l1 == s1.length() && l2 == s2.length();
    }
}