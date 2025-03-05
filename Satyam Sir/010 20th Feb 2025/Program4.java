// You are given an array nums of size n+1, 
// where each element is an integer between 1 and n (inclusive). 

// The array contains exactly one duplicated number, which appears at least twice, while all other numbers appear exactly once.

// Your task is to find and return the repeated number without modifying the array and using only constant extra space.

// Input Format:
// -------------
// Line-1: An integer N, size of array
// Line-2: N space separated integer

// Output Format:
// --------------
// Line-1: An integer, duplicate value

// Sample Input-1:
// ---------------
// 5
// 1 3 4 2 2

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 5
// 3 1 3 4 2

// Sample Output-2:
// ----------------
// 3
 

// Constraints:
// -> 1 ≤ n ≤ 10⁵
// -> nums.length = n + 1
// -> 1 ≤ nums[i] ≤ n
// -> All numbers appear exactly once except for one number which appears at least twice.

import java.util.*;

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 1 || arr[i] > n) {
                System.out.println("-1");
                System.exit(0);
            }
        }
        // Arrays.sort(arr);
        System.out.println(solve(arr));
        // System.out.println(solve1(arr));
    }

    private static int solve(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}