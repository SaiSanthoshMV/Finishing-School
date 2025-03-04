// You are given an array people where people[i] is the weight of the ith person, 
// and an infinite number of boats where each boat can carry a maximum weight of limit. 
// Each boat carries at most two people at the same time, 
// provided the sum of the weight of those people is at most limit.

// Return the minimum number of boats to carry every given person.

// Example 1:

// Input: 2
// 1 2
// 3
// Output: 1
// Explanation: 1 boat (1, 2)
// Example 2:

// Input:4
// 3 2 2 1
// 3
// Output: 3
// Explanation: 3 boats (1, 2), (2) and (3)
// Example 3:

// Input:4
// 3 5 3 4
// 5
// Output: 4
// Explanation: 4 boats (3), (3), (4), (5)
 
import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Arrays.sort(arr);
        System.out.println(checkCount(arr, n, k));
    }

    private static int checkCount(int[] arr, int n, int k) {
        int left = 0, right = n - 1;
        int cnt = 0;
        while (left <= right) {
            if (arr[left] + arr[right] <= k) {
                cnt++;
                left++;
                right--;
            } else {
                // int cap=arr[right]-arr[left];
                cnt++;
                right--;
                // arr[left+1]+=cap;
            }

        }
        return cnt;
    }
}