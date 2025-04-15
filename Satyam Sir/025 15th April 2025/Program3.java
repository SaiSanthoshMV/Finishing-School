// A Ramanujan number is a number that is equal to the sum of the factorials of its digits.

// For example:

// 145 is a Ramanujan number because:
// 1!+4!+5!=1+24+120=145

// Write a program that accepts:

// An integer n — the number of integers to check.
// A list of n numbers, and for each number, check whether it is a Ramanujan number.

// For each test case:

// If the number is a Ramanujan number, output "Yes".
// If the number is not a Ramanujan number, output "No".

// Input:
// -------
// A single integer n (1 ≤ n ≤ 100).

// n integers (1 ≤ each integer ≤ 100000) — the numbers you want to check.

// Output:
// --------
// For each number, output "Yes" if it's a Ramanujan number, otherwise output "No".

// Each result should be printed on a new line.



// input:
// ------
// 4
// 1 2 145 123

// output:
// ------
// Yes  
// Yes  
// Yes  
// No

import java.util.*;
public class Program3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int ele : arr) {
            if (isRamanujan(ele))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    private static boolean isRamanujan(int ele) {
        int num = ele;
        int sum = 0;
        while (num > 0) {
            sum += factorial(num % 10);
            num = num / 10;
        }
        return sum == ele;
    }

    private static int factorial(int n) {
        int res=1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}