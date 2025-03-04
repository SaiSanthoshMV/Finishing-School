// In the kingdom of Lexiconia, a wizard found magical cubes, each with a letter inscribed on it.
// Using these cubes, he could form non-empty words of lengths ranging from 1 to the total number of cubes.

// Each arrangement of letters created a distinct word, where order mattered. Given a string S representing the letters on the cubes
// the wizard's challenge was to determine the total number of unique words he could form.

// Can you help him find the answer?

// Input Format:
// -------------
// A string S, consist of A-Z letters only.

// Output Format:
// --------------
// Print an integer, number of possible non-empty distinct words.


// Sample Input-1:
// ---------------
// EGG

// Sample Output-1:
// ----------------
// 8

// Explanation:
// --------------
// The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


// Sample Input-2:
// ---------------
// MADAM

// Sample Output-2:
// ----------------
// 89 

import java.util.*;
public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(distinctWords(s));
    }

    private static int distinctWords(String s) {
        Set<String> st = new HashSet<>();
        st.add(s);
        char[] ch = s.toCharArray();
        boolean[] used = new boolean[s.length()];
        for (int i = 1; i <= s.length(); i++) {
            backtrack(ch, st, s, new StringBuilder(), i,used);
        }
        System.out.println(st);
        return st.size();
    }
    private static void backtrack(char[] ch,Set<String>st,String s,StringBuilder sb,int targetInd,boolean[] used){
        if (sb.length() == targetInd) {
            st.add(sb.toString());
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(ch[i]);
                backtrack(ch, st, s, sb, targetInd, used);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
}
