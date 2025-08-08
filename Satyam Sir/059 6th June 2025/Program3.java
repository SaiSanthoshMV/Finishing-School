/*
 

Day4_Program3



You are analyzing sunrise data stored in a special calendar app. Originally, the sunrise times for each day were recorded in ascending order, but due to a software update, the array of times got rotated at an unknown point.

Now, the earliest sunrise (the minimum value) might appear in the middle or at the end of the list — but you are guaranteed that no sunrise time is duplicated.

Your task is to help the app recover and display the earliest sunrise time from this rotated list.

Input Format:
-------------
Line-1: An integer N — the number of days (length of the rotated list).
Line-2: A line with N space-separated integers, representing the sunrise times in a rotated ascending array.

Output Format:
--------------
Line-1: Print a single integer — the minimum sunrise time in the rotated calendar.

Sample Input-1:
---------------
7  
30 40 50 10 20 25 28

Sample Output-1:
----------------
10

Explanation:
-------------
The list was originally [10 20 25 28 30 40 50], rotated at some point.
The minimum sunrise time is 10.

Sample Input-2:
---------------
5  
10 20 30 40 50

Sample Output-2:
----------------
10

Explanation:
-------------
The array was not rotated at all. The first element is the minimum.

Constraints:
------------
-> 1 ≤ N ≤ 10⁵
-> All sunrise times are distinct
-> The original list was sorted in ascending order and then rotated



 */

import java.util.*;
class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of days
        int N = sc.nextInt();
        int[] sunriseTimes = new int[N];
        
        // Read sunrise times
        for (int i = 0; i < N; i++) {
            sunriseTimes[i] = sc.nextInt();
        }
        
        // Find the minimum sunrise time in the rotated array
        int minSunriseTime = findMinInRotatedArray(sunriseTimes);
        
        // Print the result
        System.out.println(minSunriseTime);
    }
    
    private static int findMinInRotatedArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is greater than right, meaning the minimum is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else { // Otherwise, the minimum is in the left half or at mid
                right = mid;
            }
        }
        
        return arr[left]; // or arr[right], both are the same at this point
    }
}