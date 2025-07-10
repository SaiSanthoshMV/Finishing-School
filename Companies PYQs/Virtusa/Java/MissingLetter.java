/*
4.DIVIDE STRING



You are given a string S, You have to divide the string into subsequences such that every character of S is present in 
only one subsequence and every subsequence has the same set of characters . Your task is to find and return the maximum
possible number of subsequences into which you can divide the given string.



NOTE: Every subsequence will have same set of characters but their frequency can vary.


input specification:
--------------------

input1: A string value S


output specification
--------------------
Return an integer value representing the maximum possible number of subsequences into which you can divide the given 
string.


Example 1:
-----------

input 1: abcabcab

Output : 2


Explanation:
------------

Here , the given string is " abcabcab ", We can divide the string into two subsequences "abca",and "bcab". 
Both have the same sets of characters,i.e,,['a','b','c'].
Therefore,, 2 is returned as the output.


Example 2:
----------

input2: aaabbbccca

output: 3

Explanation:
------------

Here , the given string is " aaabbbccca", We can divide the string into three subsequences "abca", "abc", and "abc".
All have the same sets of characters i.e.['a','b','c']
Therefore, 3 is returned as the output.

*/
import java.util.*;

public class MissingLetter {
    public static char findMissingLetter(String s) {
        boolean[] seen = new boolean[26]; // for 'a' to 'z'

        for (char ch : s.toCharArray()) {
            seen[ch - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            if (!seen[i]) {
                return (char) ('a' + i);
            }
        }

        return '-'; // indicates all letters are present
    }

    public static void main(String[] args) {
        String s1 = "thequickbrownfxjmpsvlazydg";
        char result1 = findMissingLetter(s1);
        System.out.println(result1 == '-' ? "-1" : result1);  // Output: 'c'

        String s2 = "abcdefghijklmnopqrstuvwxyz";
        char result2 = findMissingLetter(s2);
        System.out.println(result2 == '-' ? "-1" : result2);  // Output: -1
    }
}
