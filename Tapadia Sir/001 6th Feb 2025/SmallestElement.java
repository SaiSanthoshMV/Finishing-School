/*    You are given an array consisting of N integers, and an integer, K. 
Your task is to determine the minimum element in subarrays of size K.

Sample Input1:
--------------
5
10 12 14 11 15
3

Sample Output1:
---------------
10 11 11

Sample Input2:
--------------
5
5 2 1 1 1
4

Sample Output2:
---------------
1 1

 */

import java.util.*;

public class SmallestElement {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {

            arr[i] = sc.nextInt();
        }
        
        int K = sc.nextInt();
        
        findMinInSubarrays(arr, N, K);
    }

    public static void findMinInSubarrays(int[] arr, int N, int K) {


        for (int i = 0; i <= N - K; i++) {

            int min = arr[i];
            
            for (int j = 1; j < K; j++) {

                if (arr[i + j] < min) {

                    min = arr[i + j];
                }
            }
            System.out.print(min + " ");
        }
    }
}