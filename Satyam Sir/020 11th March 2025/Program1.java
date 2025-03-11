// Imagine you have a row of treasure chests, each containing a certain amount of gold coins. 
// However, some chests might contain the same amount of gold as others.

// Your goal is to find a sequence of consecutive chests where no two chests have the same amount
// of gold. Once you identify such a sequence, you must collect the maximum possible gold from one
// of these unique sets.

// Find the highest amount of gold you can gather by picking exactly one such sequence of chests 
// and collecting all the coins inside.

// Input Format:
// -------------
// Line-1: An integer N, representing the Total number of treasure chest .
// Line-2: Space-separated integers, representing the amount of gold in each treasure chest.

// Output Format:
// --------------
// Line-1: A single integer, representisxxng the maximum sum of a contiguous subarray with all 
// unique elements.

// Sample Input-1:
// ---------------
// 5  
// 4 2 4 5 6  

// Sample Output-1:
// ----------------
// 17

// Explanation:
// -------------
// The longest unique maximum gold is [2, 4, 5, 6] with a sum of 2 + 4 + 5 + 6 = 17.
// This is the maximum possible sum that can be obtained.


// Sample Input-2:
// ---------------
// 6  
// 1 2 3 1 2 3  

// Sample Output-2:
// ----------------
// 6


// Explanation:
// ------------
// The longest unique maximum gold is [1, 2, 3] with a sum of 1 + 2 + 3 = 6.
// This sum cannot be improved by choosing another unique subarray.

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // System.out.println(maxGoldCount(arr, n)); //Brute-Force Solution:-TC-O(N^2)
        // System.out.println(maxGoldCount2(arr,n)); //Optimized Solution:-TC-O(N)
        System.out.println(maxGoldCount3(arr, n)); //Optimized Solution Using HashMap:-TC-O(N)
    }

    private static int maxGoldCount(int[] arr, int n) {
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (st.contains(arr[j])) {
                    break;
                }
                st.add(arr[j]);
                cnt += arr[j];
                maxCnt = Math.max(cnt, maxCnt);
            }
            System.out.println(st + " " + cnt);
        }
        return maxCnt;
    }

    private static int maxGoldCount2(int[] arr, int n) {
        int left = 0, right = 0;
        int sum = 0, maxSum = 0;
        Set<Integer> st = new HashSet<>();
        while (right < n) {
            while (st.contains(arr[right])) {
                st.remove(arr[left]);
                sum -= arr[left];
                left++;
            }
            st.add(arr[right]);
            sum += arr[right];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    private static int maxGoldCount3(int[] arr, int n) {
        Map<Integer, Integer> mp = new HashMap<>(); // Map to store frequency of elements
        int sum = 0, maxSum = 0;
        int left = 0, right = 0;

        while (right < n) {
            sum += arr[right];
            mp.put(arr[right], mp.getOrDefault(arr[right], 0) + 1);
            while (mp.get(arr[right]) > 1) {
                mp.put(arr[left], mp.get(arr[left]) - 1);
                sum -= arr[left];
                if (mp.get(arr[left]) == 0) {
                    mp.remove(arr[left]);
                }
                left++;
            }
            maxSum = Math.max(sum, maxSum);
            right++; 
        }
        return maxSum;
    }
}