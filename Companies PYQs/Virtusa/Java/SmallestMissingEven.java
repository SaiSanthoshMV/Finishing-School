/*
13.SMALLEST MISSING EVEN NUMBER


You are given an integer array A of length N, and your task is to find and return an integer value representing
the smallest missing even number from the array A. If all even numbers up to the maximum value 
in the array are present, return the next even number after the largest even number in the array.

Input Specification:
--------------------
input1: An integer value N, representing the size of the given array.
input2: An integer array A, representing positive integers.

Output Specification:
----------------------
Return an integer value representing the smallest missing even number from the array A. 
If all even numbers up to the maximum value in the array are present, return the next even number after the 
largest even number in the array


Example 1
----------
input1.: 5
input2: (2,4,6,8,12)

Output : 10

Explanation:
------------
Here, N = 5 and the A = (2,4,6,8,12). The even numbers in the array are (2,4,6,8,12). 
The smallest missing even number in this range is 10.
Hence, 10 is returned as output.

Example 2:
---------
input1: 4
input2 : (4,10,6,2}

Output : 8

Explanation:
------------
Here, N = 4 and the A = (4,10,6,2). The even numbers in the array are = (2,4,6,10}.
The smallest missing even number in this range is 8. 
Hence, 8 is returned as output.


*/
import java.util.*;

public class SmallestMissingEven {

    public static int findSmallestMissingEven(int N, int[] A) {
        Set<Integer> evenSet = new HashSet<>();
        int maxEven = -1;

        for (int num : A) {
            if (num % 2 == 0) {
                evenSet.add(num);
                maxEven = Math.max(maxEven, num);
            }
        }

        if (maxEven == -1) return 2; // No even number at all

        for (int i = 2; i <= maxEven; i += 2) {
            if (!evenSet.contains(i)) {
                return i;
            }
        }

        return maxEven + 2;
    }

    public static void main(String[] args) {
        System.out.println(findSmallestMissingEven(5, new int[]{2, 4, 6, 8, 12})); // Output: 10
        System.out.println(findSmallestMissingEven(4, new int[]{4, 10, 6, 2}));    // Output: 8
    }
}
