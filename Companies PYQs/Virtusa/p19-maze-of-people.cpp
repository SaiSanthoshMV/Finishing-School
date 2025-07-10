/*
19.MAZE OF PEOPLE


You are standing in a long line to enter the maze of trails . the line is endless and only two people can enter 
the maze every second . 

The process follows these rules

-> Every second , the 1st and 3rd people in the line enter the maze
-> The person who was 2nd before, they will move to the 1st position
-> This keeps happening every second, with the 1st 3rd people always entering and leaving.

At the start, you are at the Nth position in the line. Your task is to find and return as integer value 
representing how many seconds it will take for you to enter the maze

Input Specification:
--------------------.
input1: An integer value N representing your position in the line.

Output Specification:
--------------------
Return an integer value representing how many seconds it will take for you to enter the maze.


Example 1:
---------
input1 : 5

output : 2


Explanation:
-----------

Here, you are standing in the 5th position in the line , According to the rules the 1st and 3rd person will get 
in the maze in the 1st second. The 2nd and 5th person will get in in the 2nd second. IT took you 2 seconds to get 
in the maze, here 2 is returned as output.


Example 2:
----------
input1 : 3

output : 1

====================================================================================================================



*/

#include <iostream>
#include <deque>
using namespace std;

int timeToEnterMaze(int N) {
    deque<int> line;
    
    for (int i = 1; i <= N + 10; ++i) {
        line.push_back(i);
    }

    int seconds = 0;

    while (true) {
        seconds++;
        int first = line[0];
        int second = line[1];
        int third = line[2];

        if (first == N || third == N)
            return seconds;

        line.erase(line.begin() + 2);
        line.erase(line.begin());     

        int temp = line.front();
        line.pop_front();
        line.push_front(temp);
    }
}

int main() {
    int N;
    cin >> N;
    cout << timeToEnterMaze(N) << endl;
    return 0;
}
