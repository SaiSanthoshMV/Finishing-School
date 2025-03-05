// Rotational Challenge

// Shyam loves playing with numbers, and today he has a list of integers. 
// His challenge is to rotate the list multiple times and find the largest possible sum based on a unique formula.

// The sum is calculated by multiplying each number with its position in the list and adding up the results. 
// However, every time he rotates the list clockwise, the positions of the numbers change, which affects the sum.

// He needs your help to determine the maximum sum possible after trying all possible rotations.



// Assume arrk to be an array obtained by rotating nums by k positions clock-wise. 

// We define the rotation function F on nums as follow:

// Max(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
// Return the maximum value of Max(0), Max(1), ..., Max(n-1).

// The test cases are generated so that the answer fits in a 32-bit integer.

// Example 1:
// Input: 4 
//  4 3 2 6
// Output: 26

// Explanation:
// Max(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
// Max(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
// Max(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
// Max(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

// So the maximum value of Max(0), Max(1), Max(2), Max(3) is Max(3) = 26.

// Example 2:
// Input: 1
// 100
// Output: 0

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxRotatedValue(arr));
    }

    private static int maxRotatedValue(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            currSum += i * arr[i];
        }
        int maxSum = currSum;
        for (int k = 1; k < n; k++) {
            currSum += sum - n * arr[n - k];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

   
}
