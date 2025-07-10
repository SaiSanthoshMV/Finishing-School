/*
7.MINIMUM LENGTH 


You are given a string S ,You need to find a substring of string  S such that there is at least one character whose 
frequency is equal in both the original string S and its substring . Your task is to find and return an integer value
representing the minimum length of the substring that satisfies the given condition.


input specification:
--------------------

input1: A string value S.

Output specification:
---------------------

Return an integer value representing the minimum length of the substring that satisfies the given condition.


Example 1:
----------

input 1:  abcadbcd

output : 4


Explanation:
-----------

Here, the given string is "abcadbcd" . Here are all the possible substrings with minimum length that have at least 
one character whose occurrence is the same in both the substring and the string S.

-> Substring "abca" of length 4 and the given string have the same occurrence of 'a'.

-> Substring "bcadb" of length 5 and the given string have the same occurrence of 'b'.

-> Substring "cadbc" of length 5 and the given string have the same occurrence of 'c'.

-> Substring "dbcd" of length 4 and the given string have the same occurrence of 'd'.


The substrings "abca" and "dbcd" have a minimum length of 4 , so  4 is returned as the output.


Example 2:
----------

input 1: xxyy

output: 2

Explanation:
------------

Here , the given string is "xxyy". Here are all the possible substrings with minimum length that have at least one
character whose occurrence is the same in both substring and the string S:

-> Substring "xx" of length 2 and the given string have the same occurrence x.

-> Substring "yy" of length 2 and the given string have the same occurrence y.

The substrings "xx" and "yy" have a minimum length of 2, so 2 is returned as an output.

*/
#include <iostream>
#include <unordered_map>
#include <string>
#include <climits>
using namespace std;

int minLengthSubstring(string s) {
    int n = s.size();
    unordered_map<char, int> fullFreq;

    for (char ch : s)
        fullFreq[ch]++;

    int minLen = INT_MAX;

    for (int start = 0; start < n; ++start) {
        unordered_map<char, int> windowFreq;
        for (int end = start; end < n; ++end) {
            char ch = s[end];
            windowFreq[ch]++;

            if (fullFreq[ch] == windowFreq[ch]) {
                minLen = min(minLen, end - start + 1);
                break;
            }
        }
    }

    return minLen;
}

int main() {
    string s;
    cin >> s;
    cout << minLengthSubstring(s) << endl;
    return 0;
}
