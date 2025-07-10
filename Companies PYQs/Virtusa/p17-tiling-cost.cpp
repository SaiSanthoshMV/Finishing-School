/*
17.TILING COST



Bob has bought a complete basement for warehousing. He wants to tile its entire floor which is X units in 
length and Y units in breadth. He has a mathematical function (X, Y) to find the tiling cost for the flooring:

1. f(X,Y) = 0, if X=0 or Y=0
2. f(X,Y) = X*y*h(X,Y), if X=1 or Y=1
3. f(X,Y) = f(X-2,Y-2) + (2X + 2Y - 4) *h (X,Y), otherwise.
where h (X,Y) = (2*X) + (3*Y) + 5

Your task is to help Bob find and return an integer value representing the total cost of tiling the floor 
using the mathematical function f (X,Y).

input Specification:
--------------------
input1 : An integer value X, representing the length of the floor to be tiled.
input2: An integer value Y, representing the breadth of the floor to be tiled.

Output Specification:
---------------------
Retum an integer value representing the total cost of tiling the floor using mathematical function f (X,Y).

Example 1: 
----------

input1 : 3
input2 : 5

Output : 360

Explanation:
------------

HEre, we are given the length of the basement X=3 and the breadth of the basement Y=5 . 
The cost of tiling basement will be:

f(X,Y) = f(X-2,Y-2)+(2X+2Y-4)*h(X,Y)
f(3,5) = f(1,3)+(2*3+2*5-4)*h(3,5)
where h(3,5)=2*3+3*5+5=26

f(3,5) = (1*3)*h(1,3) + (6+10-4)*26
f(3,5) = 3*(2*1+3*3+5)+12*26
f(3,5)=360
Hence,360 is returned as the output.



Example 2:
----------

input1: 1000
input2: 1

Output : 2008000

Explanation:
------------

Here we are given the length of the basement X=1000 and the breadth of the basement Y=1. 
The cost of tiling the basement will be:
f(X,Y) =X*Y*h(X,Y)
f(1000,1)=1000*1*h(1000,1)
where h(1000,1)=2*1000+3*1+5=2008
f(1000,1) =1000*1*2008
f(1000,1)=2008000
Hence,2008000 is returned as the output.

*/

#include <iostream>
#include <unordered_map>
using namespace std;

unordered_map<string, long long> memo;

long long h(int X, int Y) {
    return 2LL * X + 3LL * Y + 5;
}

string getKey(int X, int Y) {
    return to_string(X) + "," + to_string(Y);
}

long long f(int X, int Y) {
    if (X == 0 || Y == 0) return 0;

    if (X == 1 || Y == 1) return (long long)X * Y * h(X, Y);

    string key = getKey(X, Y);
    if (memo.find(key) != memo.end()) {
        return memo[key];
    }

    // Recursive case
    long long cost = f(X - 2, Y - 2) + (2LL * X + 2LL * Y - 4LL) * h(X, Y);
    memo[key] = cost;
    return cost;
}

int main() {
    int X, Y;
    cin >> X >> Y;

    cout << f(X, Y) << endl;
    return 0;
}
