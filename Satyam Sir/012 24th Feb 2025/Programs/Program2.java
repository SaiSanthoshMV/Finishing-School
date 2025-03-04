// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), 
// ans[i] is the number of 1's in the binary representation of i.

 

// Example 1:
// input =2
// output =0 1 1
// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// Example 2:

// input =5
// output =0 1 1 2 1 2

// Explanation:
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // String[] arr=new String[n+1];
        for (int i = 0; i <= n; i++) {
            System.out.print(countOnes(i) + " ");
        }

    }

    private static int countOnes(int ele) {
        int cnt = 0;
        // int num=Integer.parseInt(ele);
        while (ele > 0) {
            cnt++;
            ele = ele & (ele - 1);
        }
        return cnt;
    }
}