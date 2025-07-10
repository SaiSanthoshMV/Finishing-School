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

#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>
using namespace std;

int smallestMissingEven(int n, vector<int>& A) {
    unordered_set<int> evenSet;
    int maxEven = -1;

    for (int num : A) {
        if (num % 2 == 0) {
            evenSet.insert(num);
            if (num > maxEven) {
                maxEven = num;
            }
        }
    }

    if (evenSet.empty()) return 2;

    for (int i = 2; i <= maxEven; i += 2) {
        if (evenSet.find(i) == evenSet.end()) {
            return i;
        }
    }

    return maxEven + 2;
}

int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for (int i = 0; i < n; ++i) cin >> A[i];

    cout << smallestMissingEven(n, A) << endl;
    return 0;
}
