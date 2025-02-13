// Cob is working an Group of numbers.
// His teacher gave him to print the Maximum product of the 'k' consiqutive numbers. 

// The first line of input contains the group size followed by group numbers followed by k


// sample input 1 :
// ----------------
// 5
// 1 5 3 2 10
// 3
// sample output 1 :
// -----------------
// 60

// sample input 2 :
// ----------------
// 7
// 8 7 1 8 2 9 1
// 2
// sample output 2:
// ----------------
// 56
import java.util.*;

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxProd = 0, prod = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        if (n < k) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i <= n - k; i++) {
            prod = product(arr, k, i);
            maxProd = Math.max(prod, maxProd);
        }
        System.out.println(maxProd);
    }

    private static int product(int[] arr, int k, int i) {
        int res = 1;
        for (int j = i; j < i + k; j++) {
            res *= arr[j];
        }
        return res;
    }
}