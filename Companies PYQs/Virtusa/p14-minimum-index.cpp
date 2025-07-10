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

#include <iostream>
#include <vector>
using namespace std;

int findSpecialIndex(int n, vector<int>& A) {
    vector<int> prefixXOR(n);
    prefixXOR[0] = A[0];

    for (int i = 1; i < n; ++i) {
        prefixXOR[i] = prefixXOR[i - 1] ^ A[i];
    }

    int totalXOR = prefixXOR[n - 1];

    for (int i = 0; i < n; ++i) {
        int leftXOR = prefixXOR[i];
        int rightXOR = totalXOR ^ prefixXOR[i];

        if (leftXOR > rightXOR) {
            return i;
        }
    }

    return -1;
}

int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for (int i = 0; i < n; ++i) cin >> A[i];
    cout << findSpecialIndex(n, A) << endl;
    return 0;
}
