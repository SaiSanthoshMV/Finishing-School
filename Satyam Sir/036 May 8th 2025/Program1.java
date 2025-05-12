// You are navigating a spaceship through a galaxy represented as an m x n space map.  
// The spaceship starts from the top-left sector (sector[0][0]) and its mission is 
// to safely reach the bottom-right sector (sector[m-1][n-1]).

// Each sector on the map can either be clear (0) or blocked by an asteroid field (1).  
// The spaceship can only move right or downward at any moment.  
// It cannot pass through sectors with asteroid fields.

// Find the total number of distinct safe routes the spaceship can take to reach 
// its destination at the bottom-right corner.


// Input format:
// -------------
// 2 space seperated integers, m & n
// next m lines representing the Map 

// Output format:
// --------------
// An integer, the total number of distinct safe routes



// Example 1:
// ----------
// Input:
// 3 3
// 0 0 0
// 0 1 0
// 0 0 0

// Output:
// 2

// Explanation:  
// There’s one asteroid field blocking the center of the 3×3 map.  
// Two possible safe navigation visited:
// - Move → Move → Down → Down
// - Down → Down → Move → Move

// Example 2:
// ---------
// Input:
// 2 2
// 0 1
// 0 0

// Output:
// 1


// Constraints:
// - m == sectorMap.length
// - n == sectorMap[i].length
// - 1 <= m, n <= 100
// - sectorMap[i][j] is either 0 (clear) or 1 (asteroid field)
import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(findPathsBFS(grid,m,n));
    }

    private static int findPathsBFS(int[][] grid,int m,int n) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return 0;
        int[][] visited = new int[m][n];
        visited[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        int[][] directions = { { 0, 1 }, { 1, 0 } };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : directions) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                    visited[x][y] += visited[row][col];
                    if (visited[x][y] == visited[row][col]) {
                        q.offer(new int[] { x, y });
                    }
                }
                
            }
        }

        return visited[m - 1][n - 1];
    }
}