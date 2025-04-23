// In the heart of a dense and ancient forest, a group of explorers stumbles upon a mysterious stone tablet. 
// Inscribed on it is a puzzle that must be solved to reveal the path to a hidden treasure.
// The tablet contains a list of n magical numbers — some positive, some negative, and some neutral — scattered across its surface. 
// These numbers are known to react to a mystical energy frequency called the Target.
// To activate the treasure map, the explorers must find exactly three numbers from the tablet such that their combined energy is as close as
// possible to the Target frequency.
// > "Only one combination of three numbers exists," reads a line on the stone, "whose total will come closest to the energy I seek."

// Can you help the explorers find the closest sum of three numbers that awakens the ancient path?

// ---

//  Input
//  ------

//  A list of integers carved into the stone: nums, where 3 <= nums.length <= 500.
// An integer target representing the mystical frequency.

//  Goal
//  -----
// Find three numbers from nums whose sum is closest to target. Return that sum.

// Example 1:
// ----------

// Stone Numbers: [-1, 2, 1, -4]  
// Target Frequency: 1  
// Output: 2  
// > The sum closest to the target is 2 (from -1 + 2 + 1).

// ---
// Example 2:
// ----------

// Stone Numbers: [0, 0, 0]  
// Target Frequency: 1  
// Output: 0  
// > Even though the target is 1, the only possible sum is 0, which is the closest.

// ---
// Constraints
// ------------

//  -1000 <= nums[i] <= 1000  
//  -10⁴ <= target <= 10⁴

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(threeSumCloset(arr, n, target));
        System.out.println(threeSumCloset2(arr, n, target));
    }

    static int threeSumCloset(int[] arr, int n, int target) {
        int minSum = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; j < n; j++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (Math.abs(sum - target) < Math.abs(minSum - target))
                        minSum = sum;
                }
            }
        }
        return minSum;
    }
    static int threeSumCloset2(int[] arr, int n, int target) {
        Arrays.sort(arr);
        int sum = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int currsum = arr[l] + arr[r] + arr[i];
                if (Math.abs(currsum - target) < Math.abs(sum - target)) {
                    sum = currsum;
                }
                if (currsum < target)
                    l++;
                else if (currsum > target)
                    r--;
                else
                    return currsum;

            }
        }
        return sum;
    }
}