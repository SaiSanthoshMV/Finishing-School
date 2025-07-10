/*

6.QUEST FOR THE HIDDEN CODE


In a remote village, there existed two mystical strings S1 and S2. in these strings was hidden a secret encoded in 
their characters.

Your task is to find and return an integer value representing the encoded secret of the strings by finding the sum of 
the ASCII values of the characters in the longest common substring between these two strings . Return o if there is no 
common substring.


NOTE:

-> String S1 and S2 contain English alphabets in lower case only.

-> if there are multiple longest common substrings , then return the ASCII sum of the substring that occurs first.


Input specification:
--------------------

input1: A string value S1
input2: A string value S2


Output specification:
---------------------

Return an integer value Representing the encoded secret of the strings by finding the sum of the ASCII values of the 
characters in the longest common substring between these two strings.




Example 1:
----------

input1: adventure
input2:future


Output: 448

Explanation:
------------
Here , the string S1 is "adventure" and S2 is "future" .The longest common substring between S1 and S2 is "true"
with their ASCII values summing up to 448 (116 + 117+114+101).Therefore, 448 is returned as the output.


Example 2:
----------

input1: mystery
input2: legend

Output: 101

Explanation:
------------

Here, the string S1 is "mystery" and S2 is "legend" .The longest common substring between S1 and S2 is "e", 
with its ASCII value summing up to 101, Therefore, 101 is returned as the output.


*/

#include <iostream>
#include <vector>
using namespace std;

int findEncodedSecret(string s1, string s2) {
    int n = s1.size(), m = s2.size();
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

    int maxLength = 0;
    int endIndex = -1;

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = 1 + dp[i - 1][j - 1];

                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    endIndex = i - 1;
                }
            }
        }
    }

    if (maxLength == 0) return 0;

    string longestCommon = s1.substr(endIndex - maxLength + 1, maxLength);

    int asciiSum = 0;
    for (char c : longestCommon) {
        asciiSum += int(c);
    }

    return asciiSum;
}

int main() {
    string s1, s2;
    cin >> s1 >> s2;
    cout << findEncodedSecret(s1, s2) << endl;
    return 0;
}
