/*
1. PAIR PROBLEM 


Lucy has an integer array A of size N , All the elements in the array are distinct.
She can perform the following operation any number of times.
-> choose two numbers i and j in such a way that the product of the LCM(i,j) and HCF(i,j) is present in array A.

your task is to help Lucy find and return an integer Value, representing the maximum number of valid(i,j) pairs 
which satisfy the given conditions.

note
-----
-> the least common multiple (LCM) of two numbers is the smaller number which is a multiple of both.

-> the highest common factor(HCF) is the greatest number which divider each of the two or more numbers.

-> the pair of (x,y) is different from the pair (y,x).

input specification:
-------------------

input1: An integer value N.
input2: An integer array A.

output specification:
---------------------

Return an integer value, representing the maximum number of valid(i,j) pairs which satisfy the given condition.

Example 1:
----------

input1: 5 
input2: (1,2,3,4,5)

output: 10


explanation:
------------

Here , there are 5 elements (1,2,3,4,5) in the integer array A.
the possible valid pairs after performing the above operation are:

---------------------------------------------
Pairs    LCM       HCF     Product(LCM*HCF)
---------------------------------------------
(1,1)     1        1         1
(1,2)     2        1         2
(2,1)     2        1         2
(1,3)     3        1         3
(3,1)     3        1         3
(1,4)     4        1         4
(4,1)     4        1         4
(2,2)     2        2         4
(1,5)     5        1         5
(5,1)     5        1         5
---------------------------------------------

The above 10 pairs are the maximum number of valid pairs since the products of their LCM and HCF are present in array A.
Hence, 10 is returned as the output.


Example 2
----------

input1: 2
input2: (10,2)

output: 6


explanation:
-------------

Here , there are 2 elements (10,2) in the integer array A. The possible valid pairs after performing the above 
operation are:

------------------------------------------------------
Pairs          LCM       HCF         product(LCM*HCF)
------------------------------------------------------
(5,2)           10        1            10
(1,2)           2         1             2
(2,1)           2         1             2
(1,10)          10        1            10
(10,1)          10        1            10
(2,5)           10        1            10
------------------------------------------------------


The above 6 pairs are the maximum number of valid pairs since the 
products of their LCM and HCF are present in array A. Hence,6 is returned as the output.

*/
#include<bits/stdc++.h>
using namespace std;
int pairs(vector<int> &nums, int n){
    set<int> st;
    for(auto x: nums){
        st.insert(x);
    }
    int ans = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            if(st.count(i*j)){
                ans++;
            }
        }
    }
    return ans;
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    int maxi = INT_MIN;
    for(int i = 0; i < n; i++){
        cin >> nums[i];
        maxi = max(maxi,nums[i]);
    }
    cout << pairs(nums,maxi) << endl;
}