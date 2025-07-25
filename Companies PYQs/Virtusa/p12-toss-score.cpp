/*
12.TOSS AND SCORE


You are playing a game of Toss and Score in the Hillwood City Mall with your friends.
The following are the rules of the game:

  Toss an unbiased coin multiple times.

  For each heads you get 2 points and for each tails you lose 1 point.

  The game ends as soon as you get 3 heads in a row, or you toss the coin throughout the length of string S.

You have been given a string S consisting of letters H (for heads) and T (for tails) denoting the sequence of 
results you get on the toss of a coin N times. Your task is to find and return an integer value representing the 
final score you get when the game ends.

Note: The final score can be negative too.

Input Specification:
--------------------

input1: A string S, representing the sequence of results you get on the toss of a coin N times.

Output Specification:
---------------------
Return an integer value representing the final score you get when the game ends.

Example 1:
---------

input1: HHT
Output : 3

Explanation:
------------
Here in this example, the sequence of results is HHT.

  +4 points for two heads

  -1 point for one tails

  The final score is 4 - 1 = 3

Hence, 3 is returned as the output.

Example 2:
----------

input1 : THHHH
Output : 5

Explanation:
--------------
Here in this example, the sequence of results is THHHH.

  -1 point for one tails

  +6 points for three heads in a row

  The last heads does not contribute to the score because the game ends immediately on getting three heads in a row

  The final score is -1 + 6 = 5

Hence, 5 is returned as the output.


*/

#include <iostream>
#include <string>
using namespace std;

int tossAndScore(string S) {
    int score = 0;
    int consecHeads = 0;

    for (char c : S) {
        if (c == 'H') {
            score += 2;
            consecHeads++;
        } else if (c == 'T') {
            score -= 1;
            consecHeads = 0;
        }

        if (consecHeads == 3) {
            break;
        }
    }

    return score;
}

int main() {
    string S;
    cin >> S;
    cout << tossAndScore(S) << endl;
    return 0;
}
