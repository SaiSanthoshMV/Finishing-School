/*
8.ELECTRIC WIRE GRID



You are given an integer array A of size N. where each element represents the current in a wire segment. 
You can invert (multiply by -1) up to X segments, but two consecutive segments cannot be inverted together due to 
stability constraints. Your task is to find and return an integer value representing the maximum possible net current
after applying the best inversions. if no valid inversion can be made, return the sum of the original array. 


input specification:
--------------------

input1:An integer value N representing the number of segments.

input2:An integer value X representing the maximum inversion of segment. 

input3:An integer array A representing the current values.

Output specification:
---------------------

Return an integer value representing the maximum possible net current after applying the best inversions.
if no valid inversion can be made, return the sum of original array.


Example 1:
---------

input1: 5
input2: 2
input3:(-3,-6,7,-8,5)

output :23

Explanation:
------------

here, there are 5 segments with current values as (-3,-6,7,-8,5) and X=2.we can find the maximum possible net
current as below:

-> invert -6 -->6

-> invert -8 -->8(skipping adjacent -6 and -8 to satisfy constraints)

The maximum net current will be (-3) + 6 + 7 + 8 + 5 = 23.Hence 23 is returned as the output.



Example 2:
----------

input1: 3
input2: 2
input3: (-13,-19,-5)


output: 1

Explanation:
-------------

Here, there are 3 segments with current values as (-13,-19,-5) and X=2. we can find the maximum possible net 
current as below:
	invert -19 --> 19 
	
The maximum net current will be (-13) + 19 + (-5) = 1. Hence , 1 is returned as the output.


*/

#include <bits/stdc++.h>
using namespace std;

int maxNetCurrent(int n, int x, vector<int>& A) {
    int originalSum = 0;
    for (int val : A) originalSum += val;

    vector<pair<int, int>> gains; 

    for (int i = 0; i < n; ++i) {
        if (A[i] < 0) {
            int gain = -2 * A[i]; 
            gains.push_back({gain, i});
        }
    }

    // Sort by highest gain
    sort(gains.rbegin(), gains.rend());

    vector<bool> used(n, false);
    int usedCount = 0;
    int totalGain = 0;

    for (int i = 0; i < gains.size(); ++i) {
        int gain = gains[i].first;
        int idx = gains[i].second;
        if (usedCount == x) break;

        if ((idx > 0 && used[idx - 1]) || (idx < n - 1 && used[idx + 1]))
            continue;

        used[idx] = true;
        totalGain += gain;
        usedCount++;
    }

    return originalSum + totalGain;
}

int main() {
    int n, x;
    cin >> n >> x;
    vector<int> A(n);
    for (int i = 0; i < n; ++i) cin >> A[i];
    cout << maxNetCurrent(n, x, A) << endl;
    return 0;
}
