// Given an array, rotate the array to the right by k steps, where k is non-negative. For example, if 
// our input array is [a, b, c, d, e] and k is 2, then the output should be [d, e, a, b, c].
// We can solve this by having two loops again which will make the time complexity O(n^2) or by 
// using an extra, temporary array, but that will make the space complexity O(n).

// example
// input=5
// a b c d e
// 2
// output=d e a b c

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        int k = sc.nextInt();
        rotateArray(arr, n, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateArray(char[] arr, int n, int k) {
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start <= end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}