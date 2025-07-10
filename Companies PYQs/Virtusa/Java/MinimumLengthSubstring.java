/*
7.MINIMUM LENGTH 


You are given a string S ,You need to find a substring of string  S such that there is at least one character whose 
frequency is equal in both the original string S and its substring . Your task is to find and return an integer value
representing the minimum length of the substring that satisfies the given condition.


input specification:
--------------------

input1: A string value S.

Output specification:
---------------------

Return an integer value representing the minimum length of the substring that satisfies the given condition.


Example 1:
----------

input 1:  abcadbcd

output : 4


Explanation:
-----------

Here, the given string is "abcadbcd" . Here are all the possible substrings with minimum length that have at least 
one character whose occurrence is the same in both the substring and the string S.

-> Substring "abca" of length 4 and the given string have the same occurrence of 'a'.

-> Substring "bcadb" of length 5 and the given string have the same occurrence of 'b'.

-> Substring "cadbc" of length 5 and the given string have the same occurrence of 'c'.

-> Substring "dbcd" of length 4 and the given string have the same occurrence of 'd'.


The substrings "abca" and "dbcd" have a minimum length of 4 , so  4 is returned as the output.


Example 2:
----------

input 1: xxyy

output: 2

Explanation:
------------

Here , the given string is "xxyy". Here are all the possible substrings with minimum length that have at least one
character whose occurrence is the same in both substring and the string S:

-> Substring "xx" of length 2 and the given string have the same occurrence x.

-> Substring "yy" of length 2 and the given string have the same occurrence y.

The substrings "xx" and "yy" have a minimum length of 2, so 2 is returned as an output.

*/
import java.util.*;

public class MinimumLengthSubstring {
    public static int minLength(String s) {
        Map<Character, Integer> totalFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            totalFreq.put(c, totalFreq.getOrDefault(c, 0) + 1);
        }

        int n = s.length();
        int minLen = n;

        for (int start = 0; start < n; start++) {
            Map<Character, Integer> subFreq = new HashMap<>();

            for (int end = start; end < n; end++) {
                char c = s.charAt(end);
                subFreq.put(c, subFreq.getOrDefault(c, 0) + 1);

                // Check if any character matches the full-string frequency
                for (char key : subFreq.keySet()) {
                    if (totalFreq.get(key).equals(subFreq.get(key))) {
                        minLen = Math.min(minLen, end - start + 1);
                        break; // No need to check further for this substring
                    }
                }
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(minLength("abcadbcd"));  // Output: 4
        System.out.println(minLength("xxyy"));      // Output: 2
    }
}
