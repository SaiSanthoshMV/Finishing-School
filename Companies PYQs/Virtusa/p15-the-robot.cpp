/*
15.The Robot


Tom is a carpenter, and he recently bought a robot that can help him in driving N nails on the wooden planks.
Each of the N nails are of S inches, and in each beat, the nail goes X inch inside the plank.
The robot can operate in 2 modes:

  Single mode: Here the robot can target each nail at a time with X beats per minute.

  Dynamic mode: The robot can target all the N nails 1 beat per minute.

Your task is to program the robot to find and return an integer value representing the optimum time to drive all
 the nails in the plank.

Input Specification:
--------------------
input1: An integer value N, representing the number of nails.
input2 : An integer value X, representing the number of beats the robot can make per minute in a single mode.
input3 : An integer array S, representing the size of each nail.

Output Specification:
---------------------
Return an integer value representing the optimum time to drive all the nails in the plank.



Example 1:
----------
input1: 5
input2: 4
input3 :{2,2,4,1,1}

Output : 4

Explanation:
------------
Here, there are N = 5 nails, X = 4 and S is {2,2,4,1,1}. We can find the optimum time as
below.

In single mode,
  It will take 1 minute to put S[1] completely into the plank, since X = 4 which is greater than S[1] = 2.
  Similarly, S[2], S[3], S[4] and S[5] will also be completed in next 4 minutes as X> S[2], S[3], S[4] and S[5].
  So, in total 5 minutes, all the nails can be pushed in the plank.

In Dynamic mode,
  In the first minute, the robot will hit all the nails 1 beat, this will make S as
{1,1,3,0,0}.
  In the second minute, the robot again will hit all the nails 1 beat, this will make S as (0,0,2,0,0).

  Similarly, in the third minute S becomes (0.0,1,0,0)

Example 2:
----------

input1: 3
input2: 10
input3: {7,8,9}

Output : 3

Explanation:
------------
Here, there are N = 3 nails, X = 10 and S is {7,8,9}. We can find the optimum time as below:
In single mode:
  It will take 1 minute to put S[1] completely into the plank, since X = 10 which is
greater than S[1] = 7.
  Similarly, S[2] and S[3] will also be completed in next 2 minutes as X > S[2] and S[3].
So, in total 3 minutes, all the nails can be pushed in the plank.

Dynamic mode:
  In the first minute, the robot will hit all the nails 1 beat, this will make S as (6,7,8).
  In the second minute, the robot will hit all the nails 1 beat, this will make S as (5,6,7).
  Similarly, in the third minute S becomes (4,5,6).
  In the fourth minute, S becomes (3,4,5).
  In the fifth minute, 5 becomes (2,3,4).
  In the sixth minute, S becomes (1,2,3).
  In the seventh minute, S becomes (0, 1,2).
  In the eighth minute, S becomes (0,0, 1).
  In the ninth minute, S becomes (0,0,0).
  So, in total 9 minutes, all the nails can be pushed in the plank.

The better approach will be Single mode which does the task in 3 minutes

Therefore, 4 is returned as the output.

*/

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int minTimeToNail(int N, int X, vector<int>& S) {
    int singleModeTime = 0;
    int maxNailSize = 0;

    for (int i = 0; i < N; ++i) {
        singleModeTime += (S[i] + X - 1) / X;  // ceil(S[i]/X)
        if (S[i] > maxNailSize) {
            maxNailSize = S[i];
        }
    }

    int dynamicModeTime = maxNailSize;

    return min(singleModeTime, dynamicModeTime);
}

int main() {
    int N, X;
    cin >> N >> X;
    vector<int> S(N);
    for (int i = 0; i < N; ++i) cin >> S[i];

    cout << minTimeToNail(N, X, S) << endl;
    return 0;
}
