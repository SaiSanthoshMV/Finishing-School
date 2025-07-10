
// P-2 special matrice

/*
Venkatesh is a maths teacher.
He is teaching matrices concept to his students.
He is given a matrix of size m*n, and it contains only positive numbers.
He has given a task to his students to find the number of special matrices 
in the given matrix A[m][n].

A special matrix has following property:
	- The size of matrix should be 3*3,
	- The sum of elements in each row, each column and 
	  the two diagonals are equal.
	- The 3*3 matrix should contains all the numbers from 1 to 9.
	
Your task is to help the students to find the number of special matrices
in the given matrix.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the matrix.
Next M lines: N space separated integers m and n.

Output Format:
--------------
Print an integer, number of the special matrices.


Sample Input-1:
---------------
4 5
6 8 1 6 8
7 3 5 7 3
2 4 9 2 4
6 8 1 6 8

Sample Output-1:
----------------
1

Explanation:
------------
The special square is:
8 1 6
3 5 7
4 9 2


Sample Input-2:
---------------
3 5
2 7 6 7 2
9 5 1 5 9
4 3 8 3 4

Sample Output-2:
----------------
2

Explanation:
------------
The special squares are:
-----
2 7 6
9 5 1
4 3 8
-----
6 7 2
1 5 9
8 3 4
*/

// checking 1st rowsum with remaining rows
// first colsum with remaining cols
#include<bits/stdc++.h>
using namespace std;
bool check(vector<vector<int>> &grid, int x, int y){
    set<int>st;
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            st.insert(grid[x+i][y+j]);
        }
    }
    if(st.size() != 9)
        return false;
    int rsum = 0;
    for(int j = 0; j < 3; j++){
        rsum += grid[x][y+j];
    }
    for(int i = 1; i < 3; i++){
        int sum = 0;
        for(int j = 0; j < 3; j++){
            sum += grid[x+i][y+j];
        }
        if(sum != rsum)
            return false;
    }
    int csum = 0;
    for(int i = 0; i < 3; i++){
        csum += grid[x+i][y];
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    for(int j = 1; j < 3; j++){
        int sum = 0;
        for(int i = 0; i < 3; i++){
            sum += grid[x+i][y+j];
        }
        if(sum != csum)
            return false;
    }
    int d1 = grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2];
    int d2 = grid[x+2][y] + grid[x+1][y+1] + grid[x][y+2];
    if(d1 != d2)
        return false;
    return true;
}
int main(){
    int m,n;
    cin >> m >> n;
    vector<vector<int>> grid(m, vector<int>(n));
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cin >> grid[i][j];
        }
    }
    int ans = 0;
    for(int i = 0; i < m-2; i++){
        for(int j = 0; j < n-2; j++){
            if(check(grid,i,j))
                ans++;
        }
    }
    cout << ans << endl;
}

