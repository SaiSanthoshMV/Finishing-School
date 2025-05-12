// A group of researchers is analyzing satellite imagery of agricultural fields, 
// represented by a grid of land sections. Each section is marked either as 
// fertile (1) or infertile (0). To efficiently plan crop planting, the researchers 
// need to identify the largest rectangular area consisting exclusively of fertile 
// land sections.

// Given a binary grid representing the land (1 for fertile and 0 for infertile), 
// your task is to compute the area of the largest rectangle consisting entirely 
// of fertile land sections.

// Input Format:
// -------------
// Line-1: Two integers rows(r) and columns(c) of grid.
// Next r lines: c space separated integers, each row of the grid.

// Output Format:
// --------------
// Print an integer, area of the largest rectangle consisting entirely of fertile land sections.

// Example:
// --------
// input=
// 4 5
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0

// output=
// 6
import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c];

        // Read the grid
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(maximalRectangle(grid));
    }

    private static int maximalRectangle(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int r = grid.length;
        int c = grid[0].length;
        int[] heights = new int[c];
        int maxArea = 0;

        for (int i = 0; i < r; i++) {
            // Update heights
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;

        while (i < heights.length) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int height = heights[stack.pop()];
                int width = stack.empty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        while (!stack.empty()) {
            int height = heights[stack.pop()];
            int width = stack.empty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}