// A string is good if there are no repeated characters.
// Given a string s, return the number of good substrings of length three in s.
// Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
// A substring is a contiguous sequence of characters in a string.

// Sample Input-1:
// ---------------
// xyzzaz

// Sample Output-1:
// ----------------
// 1

// Explanation: 
// ------------
// There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
// The only good substring of length 3 is "xyz".

// Sample Input-2:
// ---------------
// aababcabc

// Sample Output-2:
// ----------------
// 4

// Explanation: 
// ------------
// There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
// The good substrings are "abc", "bca", "cab", and "abc".

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = 0;
        String s = sc.next();
        char[] str = s.toCharArray();
        List<String> res1 = new ArrayList<>();
        for (int i = 0; i <= str.length - 3; i++) {
            String st = findSubStrings(str, i);
            res1.add(st);
        }
        for (String stri : res1) {
            if (eleEqual(stri))
                res++;
        }
        System.out.println(res);
    }

    public static String findSubStrings(char[] str, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < i + 3; j++) {
            sb.append(str[j]);
        }
        return sb.toString();
    }

    public static boolean eleEqual(String s) {
        Set<Character> st = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!st.add(c))
                return false;
        }
        return true;
    }
}