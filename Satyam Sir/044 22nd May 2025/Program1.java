// Mr Robert is working with strings.
// He selected two strings S1 and S2, may differ in length,
// consists of lowercase alphabets only.

// Mr Robert has to update the strings S1, S2 to meet any one of the criteria:
// 	- All the alphabets in S1 should be less than all the alphabets in S2.
// 	- All the alphabets in S2 should be less than all the alphabets in S1.
// 	- Both S1 and S2 should have only one distinct alphabet in it.
// To Achieve, one of the criteria, you are allowed to replace any one letter in 
// the string with any other lowercase alphabet.

// Your task is to help Mr Robert, to find the minimum replacements to be done to 
// update the strings S1 and S2 to meet one of the criteria mentioned above.


// Input Format:
// -------------
// Two space separated strings S1 and S2.

// Output Format:
// --------------
// Print an integer, minimum number of replacements.


// Sample Input-1:
// ---------------
// apple ball

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// Consider the best way to make the criteria true:
// - Update S2 to "baaa" in 2 replacements, and Update S1 to "cpple" in 1 replacement
// then every alphabet in S2 is less than every alphabet in S1.
//         (OR)
// - Update S1 to "ppppp" in 3 replacements, then every alphabet in S2 is less 
// than every alphabet in S1.


// Sample Input-2:
// ---------------
// kmit kmec

// Sample Output-2:
// ----------------
// 2

import java.util.*;

public class Program1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n = s1.length();
        int m = s2.length();
        int ans = Integer.MAX_VALUE;
        for (char i = 'a'; i <= 'z'; i++) {
            int cnt1 = 0;
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) >= i) {
                    cnt1++;
                }
            }
            int cnt2 = 0;
            for (int j = 0; j < m; j++) {
                if (s2.charAt(j) <= i) {
                    cnt2++;
                }
            }
            ans = Math.min(ans, cnt1 + cnt2);
        }

        for (char i = 'a'; i <= 'z'; i++) {
            int cnt1 = 0;
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) <= i) {
                    cnt1++;
                }
            }
            int cnt2 = 0;
            for (int j = 0; j < m; j++) {
                if (s2.charAt(j) >= i) {
                    cnt2++;
                }
            }
            ans = Math.min(ans, cnt1 + cnt2);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            int cnt1 = 0;
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) != i) {
                    cnt1++;
                }
            }
            int cnt2 = 0;
            for (int j = 0; j < m; j++) {
                if (s2.charAt(j) != i) {
                    cnt2++;
                }
            }
            ans = Math.min(ans, cnt1 + cnt2);
        }

        System.out.println(ans);    
    }
}