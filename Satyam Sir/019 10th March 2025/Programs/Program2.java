// Alex, an adventurous mountaineer, loves exploring mountain ranges. 
// While on a trek, he recorded the altitude of different points along his journey. 
// However, his trip wasn’t a straight climb—some sections went uphill, reached a peak, and then descended.

// Now, Alex wants to find the longest stretch of his journey that forms a perfect mountain shape—an increasing climb to a peak followed by a steady descent.

// The Challenge
// Given an array representing the altitudes recorded during the trek, help Alex determine the longest continuous mountain segment in his journey.

// Rules of a Mountain Segment:
// It must start with an increasing sequence.
// It must reach a single peak (highest altitude).
// It must end with a decreasing sequence.
// If no such mountain exists, return 0.

// Test Case -1 
// Input = 2 2 2
// Output = 0
// Explanation: The altitudes do not form any mountain-shaped segment.

// Test Case-2
// Input = 1 3 1 4 5 6 7 8 9 8 7 6 5
// Output = 11
// Explanation: The longest mountain segment is [1, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5], with a length of 11.

// Your Task
// Help Alex analyze his trek and find the longest mountain segment in his recorded journey!

import java.util.*;

// Can use the same approach as Container with most water
public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ip = sc.nextLine().split(" ");
        int[] arr = new int[ip.length];
        for (int i = 0; i < ip.length; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        System.out.println(longestMountain(arr));
    }

    private static int longestMountain(int[] arr) {
        if(arr.length==0)
            return 0;
        for(int i=0;i<arr.length-1;i++)
            if(arr[i]==arr[i+1])
                return 0;
        
        int res = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                while(left>0 && arr[left]>arr[left-1])
                    left--;
                while(right<arr.length-1 && arr[right]>arr[right+1])
                    right++;
                int len = right - left + 1;
                res = Math.max(len, res);
            }
        }
        return res;
    }
}