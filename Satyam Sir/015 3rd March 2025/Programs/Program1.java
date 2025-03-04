// The Smallest Number Challenge

// Shyam a third
// class boyt
// has been
// given a
// large number, he
// can remove
// a few
// digits to
// make it
// as small
// as possible.

// The goal
// is to
// carefully choose
// which digits
// to remove
// so that
// the remaining
// number is
// the smallest
// possible.

//         You must
// remove exactly
// k digits.The
// final number cannot
// have unnecessary

// leading zeros (unless it becomes "0").
// If removing k digits removes all the digits, the result should simply be "0".
// Can you figure out the best way to help shyam to  remove the digits and get the smallest possible number?
// If the result is an empty string, return 0 instead.

// input = 1432219  
// 3  
// output =1219

// Explanation:
// By removing the digits 4, 3, and 2, the smallest possible number is 1219

// Input=10200 
// 1  
// Output=200

// Explanation:
// Removing "1" results in "0200", which simplifies to "200" after removing the leading zero.

// Input="10"  
// 2  
// Output=0

// Explanation:
// All digits are removed, so the result is "0"

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(generateSmallestNumber(s, k));
    }

    private static String generateSmallestNumber(String s, int k) {
        if (k >= s.length())
            return "0";
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        backtrack(s, res, new StringBuilder(), k, used, 0);
        Collections.sort(res);
        String ans = res.get(0);
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans = ans.substring(1);
        }
        return ans.length() > 0 ? ans : "0";
    }

    private static void backtrack(String s, List<String> res, StringBuilder sb, int k, boolean[] used, int index) {
        if (sb.length() == s.length() - k) {
            res.add(sb.toString());
            return;
        }
        if (index >= s.length())
            return;
        // Pick Case
        if (!used[index]) {
            used[index] = true;
            sb.append(s.charAt(index));
            backtrack(s, res, sb, k, used, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            used[index] = false;
        }
        // No Pick Case
        if (s.length() - index > sb.length())
            backtrack(s, res, sb, k, used, index + 1);
    }
}