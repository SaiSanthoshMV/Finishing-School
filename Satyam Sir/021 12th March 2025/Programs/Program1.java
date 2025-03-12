// In a world where encoded messages are sent secretly, your task is to decode them. 
// The encoding follows a specific pattern:

// You are given a string s that consists of lowercase English letters and encoded segments. 
// The encoded segments follow this rule:

// k[encodedString] where encodedString is a sequence of lowercase English letters enclosed in square brackets, 
// and k is a positive integer indicating how many times the encodedString should be repeated.


// You need to implement a function that takes this encoded string as input and returns the fully decoded version of it.

// Input
// A single string s, where s consists of digits, square brackets [ ], and lowercase English letters.

// Output
// Return a string that represents the decoded message.

// Examples
// Example 1:
// Input = 1[b]
// Output = b

// Example 2:
// Input = 3[b2[ca]]
// Output = bcacabcacabcaca


// Explanation:
// Inner substring 2[ca] breakdown into caca.
// it becomes 3[bcaca]
// 3[bcaca] becomes bcacabcacabcaca which is final res

// Example 3:
// Input = 2[abc]3[cd]ef
// Output = abcabccdcdcdef

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getDecodedString(s));
    }

    private static String getDecodedString(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                while (st.peek() != '[') {
                    temp.insert(0, st.pop());
                }
                st.pop();
                int k = 0;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    k = k * 10 + Character.getNumericValue(st.pop());
                }
                String str = temp.toString();
                for (int i = 0; i < k; i++) {
                    for (char ch : str.toCharArray()) {
                        st.push(ch);
                    }
                }
            } else {
                st.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.insert(0, st.pop());
        }

        return res.toString();
    }
}