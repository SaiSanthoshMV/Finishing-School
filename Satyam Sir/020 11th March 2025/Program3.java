// A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. 

// He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

// You are given a string answerKey, where answerKey[i] is the original answer to the ith question. 

// In addition, you are given an integer k, the maximum number of times you may perform the following operation:

// Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
// Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.

 

// Example 1:
// Input  = TTFF
// 2
// Output = 4

// Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
// There are four consecutive 'T's.

// Example 2:
// Input  = TFFT
// 1
// Output = 3

// Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
// Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
// In both cases, there are three consecutive 'F's.


// Example 3:
// Input = TTFTTFTT
// 1
// Output = 5
// Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
// Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT". 
// In both cases, there are five consecutive 'T's.

import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(getMaxT_or_F(s, k));
    }

    private static int getMaxT_or_F(String s, int k) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> mp = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                char curr = s.charAt(j);
                mp.put(curr, mp.getOrDefault(curr, 0) + 1);
                int cnt1 = mp.getOrDefault('T',0);
                int cnt2 = mp.getOrDefault('F',0);
                int tOrF = Math.min(cnt1, cnt2); 
                if (tOrF > k) 
                    break;
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}