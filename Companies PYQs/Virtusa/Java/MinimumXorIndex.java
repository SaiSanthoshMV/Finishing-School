/*
14.MINIMUM INDEX



You are given an integer array A. You need to find a special index in the array such that the XOR of all the
elements from the start till the special index is greater than the XOR of all elements after that special index. 
Your task is to find and return an integer value representing the special index in the array.
Return -1 if no special index is found.

NOTE:
  The number at the special index will also be included for the XOR operation with the elements that are 
  before that special index.

  The XOR of the first and last element will be performed which 0.

  There can be multiple possible special indices, so return the number with minimum index.

Input Specification:
--------------------
input1: An integer value, representing the size of the array.
input2 : An integer array A.

Output Specification:
---------------------
Return an integer value representing the special index in the array. Return -1 if no special index is found.

Example 1: 
----------

input1: 6
input2 : (4,2,5,7,1,3)

output: 0

Explanation:
------------
Here, the given array is (4,2,5,7,1,3). At index 0: The XOR of elements
(4) is 4, and the XOR of elements (2,5,7,1,3) is 2. As 4 is greater than 2, the number at the special index(0) is 4.
Hence, 0 is returned as the output.


Example 2:
----------
input1: 4
input2 : (4,3,2,9}

Output: 3

Explanation:
------------
Here, the given array is (4,3,2,9).

  At index 0: The XOR of elements (4) is 4, and the XOR of elements (3,2,9) is 8.

  At index 1: The XOR of elements (4,3) is 7, and the XOR of elements (2,9) is 11.

  At index 2: The XOR of elements (4,3,2) is 5, and the XOR of elements (9) is 9.

  At index 3: The XOR of elements (4,3,2,9) is 12, and the XOR of elements () is 0.

*/
public class MinimumXorIndex {

    public static int findSpecialIndex(int N, int[] A) {
        int[] prefixXor = new int[N];
        prefixXor[0] = A[0];

        for (int i = 1; i < N; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ A[i];
        }

        int totalXor = prefixXor[N - 1];

        for (int i = 0; i < N; i++) {
            int leftXor = prefixXor[i];
            int rightXor = (i == N - 1) ? 0 : totalXor ^ leftXor;

            if (leftXor > rightXor) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findSpecialIndex(6, new int[]{4, 2, 5, 7, 1, 3})); // Output: 0
        System.out.println(findSpecialIndex(4, new int[]{4, 3, 2, 9}));       // Output: 3
    }
}
