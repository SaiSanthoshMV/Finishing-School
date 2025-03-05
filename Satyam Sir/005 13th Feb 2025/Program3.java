// package A2.005 13th Feb 2025;

// public A tenth standard student has been given a task to analyze a set of P subject marks.

// Given an integer I,student needs to determine the I-th least sum among all possible contiguous subarrays of the marks list.

// Input Format:--------------Line-1:Two space-separated integers,P(number of subjects)and I(the required index in the sorted sums list).Line-2:P space-separated integers,representing the marks in each subject.

// Output Format:--------------Line-1:Print a single integer,which is the I-th least sum among all possible contiguous subarrays.

// Sample Input-1:--------------3 4 3 2 4

// Sample output-1:---------------5

// Explanation:------------The subarrays of 3 2 4 are:1 st subarray:3 the sum is 3 2 nd subarray:2 the sum is 2 3 rd subarray:4 the sum is 4 4 th subarray:3,2 the sum is 5 5 th subarray:2,4 the sum is 6 6 th subarray:3,2,4 the sum is 9

// The 4 th smallest is 5

// Sample Input-2:---------------4 7 2 2 4 4

// Sample output-2:----------------8

// Explanation:------------The subarrays of 2 2 4 4 are

// 1 st subarray:2 the sum is 2 2 nd subarray:2 the sum is 2 3 rd subarray:4 the sum is 4 4 th subarray:4 the sum is 4 5 th subarray:2,2 the sum is 4 6 th subarray:2,4 the sum is 6 7 th subarray:4,4 the sum is 8 8 th subarray:2,2,4 the sum is 8 9 th subarray:2,4,4 the sum is 10 10 th subarray:2,2,4,4 the sum is 12

// The 7 th smallest is 8 {
    
// }


// It is a brute force approach ,Similar question was also given in A1 (check in A1 folder)
import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> sumArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                sumArr.add(sum);
            }
        }
        Collections.sort(sumArr);
        System.out.println(sumArr.get(k - 1));
    }
}