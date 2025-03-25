// In the bustling city of Lexicon, a renowned detective, Alex, was known for his uncanny ability to decipher hidden messages within seemingly ordinary texts. 
// One day, he received a cryptic note containing two strings: a long, seemingly random sequence of letters (the "source string") and a shorter,
// enigmatic word (the "pattern string").

// The note hinted at hidden clues scattered throughout the source string, each clue being an anagram of the pattern string. 
// Alex knew that to crack the case, he had to identify the starting positions of these anagrams within the source string.

// Your Task:

// You are Alex's trusted assistant, tasked with developing a program to automate this process.

// 1.  Write a function that takes two strings, s (the source string) and p (the pattern string), as input.
// 2.  Implement an algorithm to find all starting indices in s where an anagram of p exists.
// 3.  Return an array (or list) containing these starting indices in any order.

// Constraints:

// * The input strings s and p will consist of lowercase English letters.
// * The length of s will be greater than or equal to the length of p.

// Example 1:

// Input:
// s = "cbaebabacd"
// p = "abc"

// Output:
// [0, 6]

// Explanation:
// The substrings "cba" (starting at index 0) and "bac" (starting at index 6) are anagrams of "abc".

// Example 2:

// Input:
// s = "abab"
// p = "ab"

// Output:
// [0, 1, 2]

// Explanation:
// The substrings "ab" (starting at index 0), "ba" (starting at index 1), and "ab" (starting at index 2) are all anagrams of "ab".

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(findAnagramInd(s, p));
    }

    private static List<Integer> findAnagramInd(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        for (char ch : p.toCharArray()) {
            pCnt[ch - 'a']++;
        }
        int pLen = p.length();
        for (int i = 0; i < pLen; i++) {
            sCnt[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCnt, pCnt)) {
            result.add(0);
        }
        for (int i = pLen; i < s.length(); i++) {
            sCnt[s.charAt(i - pLen) - 'a']--;
            sCnt[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCnt, pCnt)) {
                result.add(i - pLen + 1);
            }
        }
        return result;
    }
}