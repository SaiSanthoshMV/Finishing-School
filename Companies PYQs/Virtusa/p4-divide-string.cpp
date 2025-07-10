/*
4.DIVIDE STRING



You are given a string S, You have to divide the string into subsequences such that every character of S is present in 
only one subsequence and every subsequence has the same set of characters . Your task is to find and return the maximum
possible number of subsequences into which you can divide the given string.



NOTE: Every subsequence will have same set of characters but their frequency can vary.


input specification:
--------------------

input1: A string value S


output specification
--------------------
Return an integer value representing the maximum possible number of subsequences into which you can divide the given 
string.


Example 1:
-----------

input 1: abcabcab

Output : 2


Explanation:
------------

Here , the given string is " abcabcab ", We can divide the string into two subsequences "abca",and "bcab". 
Both have the same sets of characters,i.e,,['a','b','c'].
Therefore,, 2 is returned as the output.


Example 2:
----------

input2: aaabbbccca

output: 3

Explanation:
------------

Here , the given string is " aaabbbccca", We can divide the string into three subsequences "abca", "abc", and "abc".
All have the same sets of characters i.e.['a','b','c']
Therefore, 3 is returned as the output.

*/

#include<bits/stdc++.h>
using namespace std;
int main(){
    string str;
    cin >> str;
    map<char,int> mpp;
    for(auto x: str){
        mpp[x]++;
    }
    int ans = INT_MAX;
    for(auto x: mpp){
        if(x.second <ans){
            ans = x.second;
        }
    }
    cout << ans << endl;
}