/*AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false 
*/

import java.util.*;

public class PalindromePermutation {
    public static boolean solve(String s) {

        int mask=0,i=0;
        while(i<s.length()) {
            mask = mask^(1<<(s.charAt(i)-'a'));
            i++;
        }
        if(mask==0 || (mask&(mask-1))==0) return true;
        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solve(s));
        }

}