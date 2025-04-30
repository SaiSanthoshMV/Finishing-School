// You are given a completed 4x4 Sudoku board. Your task is to write a program that determines whether the board is valid.

// A valid 4x4 Sudoku board must meet the following conditions:

// 1. Each row must contain all the numbers from 1 to 4 exactly once.
// 2. Each column must contain all the numbers from 1 to 4 exactly once.
// 3. Each of the four 2x2 subgrids (top-left, top-right, bottom-left, bottom-right) must contain all the numbers from 1 to 4 exactly once.

// Input
// -----
// - The program should read 16 integers from the standard input.
// - These integers represent the 4x4 Sudoku board in row-major order (i.e., row by row).
// - Each integer should be between 1 and 4 (inclusive).

// Output
// ------
// - Output `true` if the Sudoku board is valid.
// - Output `false` otherwise.



// Example-1:
// ----------
// Input:

// 1 2 3 4
// 3 4 1 2
// 2 1 4 3
// 4 3 2 1


// Output
// -------
// true


// Example-2
// ---------
// Input :

// 1 2 3 4
// 3 4 1 2
// 2 1 1 3
// 4 3 2 1


// Output
// ------
// false

package Programs;


import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(isValidSudoku(board));
    }

    private static boolean isValidSudoku(int[][] board) {
        for (int i = 0; i < 4; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                int num = board[i][j];
                if (num < 1 || num > 4 || !hs.add(num)) {
                    return false;
                }
            }
            if (hs.size() != 4)
                return false;
        }
        for (int j = 0; j < 4; j++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                int num = board[i][j];
                if (num < 1 || num > 4 || !hs.add(num)) {
                    return false;
                }
            }
            if (hs.size() != 4)
                return false;
        }
        for (int row = 0; row < 4; row += 2) {
            for (int col = 0; col < 4; col += 2) {
                HashSet<Integer> hs = new HashSet<>();
                for (int i = row; i < row + 2; i++) {
                    for (int j = col; j < col + 2; j++) {
                        int num = board[i][j];
                        if (num < 1 || num > 4 || !hs.add(num)) {
                            return false;
                        }
                    }
                }
                if (hs.size() != 4)
                    return false;
            }
        }
        return true;
    }
}