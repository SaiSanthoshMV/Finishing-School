// You are working in a toy factory where marbles of three different colors—Red, White, 
// and Blue—are being packed into boxes. However, the marbles have been randomly mixed up 
// in a production batch.

// Your job is to sort the marbles in-place so that all marbles of the same color are 
// grouped together in the following order:

// Red marbles (0)
// White marbles (1)
// Blue marbles (2)

// Task:
// ------
// Write a function to rearrange the marbles in-place in a given array so that they 
// follow the correct color order.

// Constraints & Requirements:
// ----------------------------
// ->You cannot use any built-in sorting functions.
// ->You must modify the array directly (in-place), without using extra storage.
// ->Aim for an efficient solution, ideally with O(n) time complexity.

// Input Format:
// -------------
// Line 1: An integer n, representing the size of the array.
// Line 2: n space-separated integers representing the array nums, where each 
// element is either 0 (red), 1 (white), or 2 (blue).

// Output Format:
// --------------
// Line-1: Print the sorted array as n space-separated integers.

// Sample Input-1:
// ---------------
// 6
// 2 0 2 1 1 0

// Sample Output-1:
// ----------------
// 0 0 1 1 2 2

// Sample Input-2:
// ---------------
// 3
// 2 0 1

// Sample Output-2:
// ----------------
// 0 1 2

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zeroCnt = 0, oneCnt = 0, twoCnt = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int num : arr) {
            if (num == 0)
                zeroCnt++;
            else if (num == 1)
                oneCnt++;
            else
                twoCnt++;
        }
        // System.out.println(zeroCnt+" "+oneCnt+" "+twoCnt);
        // int[] res=new int[n];
        for (int i = 0; i < zeroCnt; i++) {
            arr[i] = 0;
        }
        for (int j = zeroCnt; j < oneCnt + zeroCnt; j++) {
            arr[j] = 1;
        }
        for (int k = oneCnt + zeroCnt; k < n; k++) {
            arr[k] = 2;
        }
        System.out.println(Arrays.toString(arr));
    }
}