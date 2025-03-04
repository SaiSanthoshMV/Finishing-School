/* 
You are given an m x n grid where each cell can have one of three values:
-> 0 representing an empty cell,
-> 1 representing a fresh orange, or
-> 2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1.


Input Format:
-------------
Line-1: Two integers, m and n, represents grid[] sizes
Line-2 to m: n Space separated integers, represents grid[i][j]

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation: 
-------------
The orange in the bottom left corner (row 2, column 0) is never rotten, 
because rotting only happens 4-directionally.

Sample Input-3:
---------------
1 1
0 2

Sample Output-3:
----------------
0

Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
------------
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/
import java.util.*;
class RottingOranges{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int grid[][] = new int[m][n];
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                grid[i][j]=sc.nextInt();
            }
        }
        int res = solve(grid);
        System.out.print(res);
    }
    public static int solve(int grid[][]){

        int m=grid.length;
        int n=grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        int fresh=0;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.offer(new int[]{i,j});
            }
        }
        
        int dirx[]={1,0,-1,0};
        int diry[]={0,1,0,-1};
        
        if(fresh==0) return 0;
        int time = 0;
        while(!q.isEmpty()){
            int size=q.size();
            time++;
            for(int i=0 ; i<size ; i++){
                int[] current = q.poll();
                int x=current[0]; int y=current[1];
                for(int j=0 ; j<=3 ; j++){

                    int newx= x + dirx[j]; int newy = y+diry[j];
                    if(newx>=0 && newy>=0 && newx<m && newy<n && grid[newx][newy]==1){
                        grid[newx][newy]=2;
                        q.offer(new int[]{newx,newy});
                        fresh--;
                    }
                }
                if(fresh==0) return time;
            }
        }
        
        return -1;
        }
    }