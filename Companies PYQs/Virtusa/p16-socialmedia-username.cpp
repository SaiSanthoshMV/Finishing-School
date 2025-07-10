/*
16.SOCIAL MEDIA USERNAME


You are analyzing usernames on a social media platform where each username is made up of unique lowercase letters.
You want to compare two usernames M and N to see how many characters are in common between them but are located at 
different positions .Your task is to find and return an integer value representing the count of positions.
Your task is to find and return an integer value representing the count if distinct characters that occur in both
usernames but not at the same positions


input specifications:
--------------------

input1: A strong value M , representing the first username.
inputt2: A string value N, representing the second username


output specification:
---------------------

Return an integer value representing the number of istinct characters that occur in both usernames but not at the 
same positions.


Example 1:
----------

input1: abcde
input2: edcba

output : 4

Explanation :
-------------
Here , the username M is "abcde" and N is "edcba". The common characters in both strings are:

	-> 'a','b','c','d' and 'e'.

all 5 characters exist in both strings. Their positions are all different except for 'c'.

Hence , 4 is returned as the output.

Example 2:
----------

input1: helo
input2: heol

output : 2

Explanation:
------------

Here, the username M is "helo" and N is "heol". The common characters in both strings are:
	-> 'h','e','l' and 'o'.
	
Among the common characters ,'i' and 'o' are present in both but at different positions.
Hence ,2 is returned as the output.

*/

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int countMismatchCommonChars(string M, string N) {
    unordered_map<char, int> posM, posN;

    for (int i = 0; i < M.length(); ++i) {
        posM[M[i]] = i;
    }

    for (int i = 0; i < N.length(); ++i) {
        posN[N[i]] = i;
    }

    int count = 0;

    for (auto& pair : posM) {
        char ch = pair.first;
        if (posN.find(ch) != posN.end() && posM[ch] != posN[ch]) {
            count++;
        }
    }

    return count;
}

int main() {
    string M, N;
    cin >> M >> N;
    cout << countMismatchCommonChars(M, N) << endl;
    return 0;
}
