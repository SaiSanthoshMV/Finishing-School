// In a distant galaxy, there exists an ancient space station covered in a vast 
// array of digital codes. These codes are believed to hold the key to unlocking 
// powerful alien technology. The interstellar explorers call these codes "prime 
// sequences."

// The prime-sequence beauty of the digital str is defined as the number of prime 
// sequences that meet the following conditions:
//     -The prime sequence has a length of k.
//     -The prime sequence is a divisor of the entire digital str.
//     -The prime sequence is a prime number.

// Given the digital str on the space station, represented as an integer str, and
// the length of the prime sequences k, return the prime-sequence beauty of the str.

// Note:
// -----
// Leading zeros in prime sequences are allowed.
// 0 is not a divisor of any value.
// A prime sequence is a contiguous sequence of characters in the main digital str.

// Input Format:
// -------------
// Line-1: space separated String and integer, str and K

// Output Format:
// -------------
// An integer, the prime-sequence beauty of the str.


// Sample Input-1:
// ---------------
// 239246 2 

// Sample Output-1:
// ----------------
// 1 

// Explanation:
// ------------
// The following are the prime sequences of length k:
//     "23" from "239246": 23 is a divisor of 239246 and is a prime number.
//     "39" from "239246": 39 is not a divisor.
//     "92" from "239246": 92 is not a divisor.
//     "24" from "239246": 24 is is not a divisor 239246.
//     "46" from "239246": 46 is a divisor of 239246 but is not a prime number.
//     Therefore, the prime-sequence beauty is 1.

// Sample Input-2:
// ---------------
// 24224 1

// Sample Output-2:
// ----------------
// 3
// KMIT-ONE ONLINE: case=1
// input=239246 2
// output=1

// case=2
// input=235711 1
// output=1

// case=3
// input=77777 1
// output=5

// case=4
// input=4567123 3
// output=0

// case=5
// input=717171 2
// output=3

// case=6
// input=121 1
// output=0

// case=7
// input=110110 2
// output=2

// case=8
// input=22424 1
// output=3 

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        char[] arr = str.toCharArray();
        int n = arr.length;
        System.out.println(primeSequences(arr, n, k, str));
    }

    private static int primeSequences(char[] arr, int n, int k, String fullStr) {
        int cnt = 0;
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        long str = Long.parseLong(fullStr);
        while (right < n) {
            sb.append(arr[right]);
            if (right - left + 1 == k) {
                int num = Integer.parseInt(sb.toString());
                if (str % num == 0 && isPrime(num)) {
                    cnt++;
                }
                sb.deleteCharAt(0); 
                left++;
            }
            right++;
        }

        return cnt;
    }

    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
