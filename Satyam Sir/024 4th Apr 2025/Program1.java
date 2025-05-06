// You are given a sequence of numbers representing data points recorded in a system.
// A specific number (or numbers) appears the most times in this sequence,
// and we call its frequency the "peak frequency."

// Your goal is to determine the length of the smallest continuous segment of this 
// sequence that maintains the same peak frequency as the entire sequence.

// Input Format:
// -------------
// Line 1: An integer N, representing the number of data points in the sequence.

// Line 2: N space-separated integers, representing the recorded data.

// Output Format:
// --------------
// Print a single integer, which is the length of the smallest continuous segment 
// that retains the peak frequency found in the full sequence.

// Constraints:
// ------------
// 1≤N≤50000
// 0≤s[i]≤49999

// Sample Input-1:
// ---------------
// 5
// 3 2 3 4 5

 
// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// Maximum repeated number is 3  and the count=2.
// The continuous segment with the same count are [3 2 3 4 5],[3 2 3 4], [3 2 3].
// the least size is 3 with subset[3 2 3].
 
// Sample Input-2:
// ---------------
// 5
// 5 6 6 7 5

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// Maximum repeated numbers are 5 and 6  and the count=2.
// The continuous segment with the same count are [5 6 6 7 5],
// [5 6 6 7], [6 6 7 5],[5 6 6] [6 6 7] [6 6].
// The least size is 2 with subset[6 6].

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getMinLengthWithPeakFrequency(arr));
    }

    private static int getMinLengthWithPeakFrequency(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, int[]> indexMap = new HashMap<>(); 

        int maxFreq = 0;

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];

            // Update frequency
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(val));

            // Update first and last indices
            if (!indexMap.containsKey(val)) {
                indexMap.put(val, new int[]{i, i}); 
            } else {
                indexMap.get(val)[1] = i;
            }
        }

        int minLen = Integer.MAX_VALUE;

        // Loop through keys with max frequency
        for (int key : freqMap.keySet()) {
            if (freqMap.get(key) == maxFreq) {
                int[] range = indexMap.get(key);
                int len = range[1] - range[0] + 1;
                minLen = Math.min(minLen, len);
            }
        }

        return minLen;
    }
}
