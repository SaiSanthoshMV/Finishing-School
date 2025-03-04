// Given a string s, reverse only all the vowels in the 
// string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
// appear in both lower and upper cases, more than once.

// Sample Input-1:
// ---------------
// hello

// Sample Output-1:
// ----------------
// holle

// Sample Input-2:
// ----------------
// Keshavmemorial

// Sample Output-2:
// ----------------
// Kashivmomerael

import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] str = s.toCharArray();
        System.out.println(reverseVowel(str));
    }

    private static String reverseVowel(char[] s) {
        // char[] arr={};
        List<Character> checkVowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        // checkVowel.add('a')
        int left = 0, right = s.length - 1;
        while (left < right) {
            while (left < right && !checkVowel.contains(s[left]))
                left++;
            while (left < right && !checkVowel.contains(s[right]))
                right--;
            if (left < right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
        return new String(s);
    }
}