// Ibrahim is an interior designer wants to color wall of size M*N. 
// He plans to color the wall and put lights of two different colors

// The designer can lit the wall using M*N lights.The lights are Blue or pink
// in color. Blue colored lights represented with digit-1 and pink colored lights 
// represented with digit-0.

// The Blue colored lights forms different shapes, that are connected 4 directonally.
// The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
// count the number of shapes formed by blue colored lights.

// You will be given the decorated wall as a matrix wall[][].
// Your task is to help Ibrahim to count the number of shapes by the lights.

// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the wall.
// Next M lines: N space separated integers, either 0 or 1.

// Output Format:
// --------------
// Print an integer, Number of distinct shapes formed by Blue Lights.


// Sample Input-1:
// ---------------
// 4 5
// 1 1 0 1 1
// 1 1 0 0 1
// 0 0 0 0 0
// 1 1 0 0 0

// Sample Output-1:
// ----------------
// 3


// Sample Input-2:
// ---------------
// 5 5
// 1 1 0 1 1
// 1 0 0 0 1
// 0 0 0 0 0
// 1 0 0 0 1
// 1 1 0 1 1

// Sample Output-2:
// ----------------
// 4

// Note: 
// -------
// The shapes, 
// 1 1  		  1 1
// 1      and      1

import java.util.*;

public class Program1 {
    static int[][] parent;
    static int[][] rank;

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
        parent = new int[m][n];
        rank = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                parent[i][j] = i * n + j; 
                rank[i][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i > 0 && grid[i - 1][j] == 1) {
                        union(i * n + j, (i - 1) * n + j);
                    }
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        union(i * n + j, (i + 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        union(i * n + j, i * n + (j - 1));
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        union(i * n + j, i * n + (j + 1));
                    }
                }
            }
        }

        Set<Integer> uniqueShapes = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    uniqueShapes.add(find(i * n + j));
                }
            }
        }

        System.out.println(uniqueShapes.size());
    }

    private static int find(int x) {
        int row = x / parent[0].length;
        int col = x % parent[0].length;
        if (parent[row][col] != x) {
            parent[row][col] = find(parent[row][col]);
        }
        return parent[row][col];
    }

    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            int xRow = xRoot / parent[0].length;
            int xCol = xRoot % parent[0].length;
            int yRow = yRoot / parent[0].length;
            int yCol = yRoot % parent[0].length;

            if (rank[xRow][xCol] > rank[yRow][yCol]) {
                parent[yRow][yCol] = xRoot;
            } else if (rank[xRow][xCol] < rank[yRow][yCol]) {
                parent[xRow][xCol] = yRoot;
            } else {
                parent[yRow][yCol] = xRoot;
                rank[xRow][xCol]++;
            }
        }
    }
    // DFS to count no of islands
    private static void dfs(int[][] grid, int m, int n, int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0)
            return;
        grid[i][j] = 0;
        dfs(grid, m, n, i+1, j);
        dfs(grid, m, n, i-1, j);
        dfs(grid, m, n, i, j+1);
        dfs(grid, m, n, i, j-1);
    }
}