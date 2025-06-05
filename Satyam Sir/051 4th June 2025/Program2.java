// Given an array of integers nums and an integer target, retum indices of the two numbers such that they add up to target. 
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// example:
// input:
// 4 //size of the array
// 2 7 11 15  // list of integers
// 9 //target sum

// output:
// 0 1 //indexes

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(Arrays.toString(twoSum(arr, n, target)));
    }

    private static int[] twoSum(int[] arr, int n, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rem = target - arr[i];
            if (mp.containsKey(rem)) {
                return new int[] {  mp.get(rem),i };
            }
            mp.put(arr[i], i);
        }
        return new int[] { -1, -1 };
    }
}