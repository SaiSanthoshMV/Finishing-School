// You are controlling a battlefield represented by an m x n grid.Each cell on this grid can be one of the following:

// -A reinforced barrier('B'),blocking your laser.-An enemy drone('D'),your target.-An open cell('0'),where you can position your robot to fire.

// When your robot fires its powerful laser from an open cell,the beam destroys all enemy drones in the same row and column until the beam hits a barrier('B').The barrier completely stops the laser,protecting anything behind it.

// Your goal is to identify the best position(open cell)to place your robot so that firing the laser destroys the maximum number of enemy drones in a single shot.Return this maximum number.

// Input format:-------------Line 1:Two space separated integers,represents m&n Next M lines:each row of battlefield

// Output format:--------------An integer,maximum number of enemy drones destroyed in a single shot.

// Example 1:----------input=3 4 
// 0 D 0 0 D 0 B D 0 D 0 0

// Output=3

// Explanation:placing robot at battlefield[1][1]destroys 3 enemy drones in a single shot.

// Example 2:----------3 3 B B B 0 0 0 D D D

// Output=1

// Constraints:-1<=m,n<=500-battlefield[i][j]is either'B','D',or'0'.
import java.util.*;

public class Program2 {

    public static void dfs1(char[][] grid, int i, int j, int[] count) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 'B')
            return;

        if (grid[i][j] == 'D')
            count[0]++;

        char temp = grid[i][j];
        grid[i][j] = 'B';

        dfs1(grid, i + 1, j, count);
        dfs1(grid, i - 1, j, count);

        grid[i][j] = temp; 
    }

    public static void dfs2(char[][] grid, int i, int j, int[] count) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 'B')
            return;

        if (grid[i][j] == 'D')
            count[0]++;

        char temp = grid[i][j];
        grid[i][j] = 'B'; 

        dfs2(grid, i, j + 1, count);
        dfs2(grid, i, j - 1, count);

        grid[i][j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); 
        int n = sc.nextInt();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    int[] t = new int[1]; 
                    int ct = 0;

                    dfs1(grid, i, j, t);
                    ct += t[0];

                    t[0] = 0;
                    dfs2(grid, i, j, t);
                    ct += t[0];

                    ans = Math.max(ans, ct);
                }
            }
        }

        System.out.println(ans);
    }
}
