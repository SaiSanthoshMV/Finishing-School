/*
9.COUNT SUBSETS


You are given an integer array of N positive number. Your task is to find and return an integer value representing 
the minimum number of subarrays needed to arrange the elements in such a way that each element is positioned at an 
index where its value is greater than or equal to its index.

NOTE:
   -> you are allowed to rearrange the elements as required>
   
   -> Assume ! based indexing
   
   
   
input specification:
--------------------

input1:An integer value N , representing the number of array elements.

input2: An integer array.


Output specification:
---------------------

Return an integer value representing the minimum number of subarrays needed in arrange the elements in such a way
that each element is positioned at an index where its value is greater than or equal to its index.

example 1:
----------

input1: 5
input2: (5,5,5,1,2)

output:1


Explanation:
------------

Here,,the given array is(5,5,5,1,2) . The array can be arranged as (1,2,5,5,5) ,where the value of each element is
greater than or equal to its corresponding index. Since the count of the subarray is 1, 1 is returned as the output.


Example 2:
----------

input1: 8
input2: (6,1,6,1,3,2,6,1)

output: 3

*/
import java.util.*;

public class CountSubsets {

    public static int countSubsets(int N, int[] A) {
        Arrays.sort(A);  // Sort to group smallest values first
        int count = 0;
        int index = 1;   // 1-based index within a subarray

        for (int i = 0; i < N; ) {
            int elementsUsed = 0;
            index = 1;

            // Try to form a valid subarray from current position
            while (i + elementsUsed < N && A[i + elementsUsed] >= index) {
                index++;
                elementsUsed++;
            }

            count++;
            i += elementsUsed;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubsets(5, new int[]{5, 5, 5, 1, 2}));       // Output: 1
        System.out.println(countSubsets(8, new int[]{6, 1, 6, 1, 3, 2, 6, 1})); // Output: 3
    }
}
