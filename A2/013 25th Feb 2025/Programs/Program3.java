// In the village of Alphaville, where the houses are arranged in a grid pattern like a big crossword puzzle,
// the local children love playing a game called "Word Hunt." 

// In this game, a 2D grid is drawn on the ground, each cell filled with a single English letter. 

// The goal is to find specific words in the grid that can be formed by connecting letters horizontally or vertically. 
// Words can be read left to right, right to left, top to bottom, or bottom to top.

// One sunny day, the children decide to challenge you to this game. 
// They provide you with a grid filled with letters and a word to find. 

// Your task is to determine if the word exists anywhere in the grid 
// according to the game's rules.

// Test Case 1
// Input = 3 4
// a b c s 
// s f c e 
// a d e e 
// see
// output = true

// Test Case 2
// Input = 4 4 
// x y z t 
// w x y z 
// p q r t 
// z o o z 
// zoom
// output = false

import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] arr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }
        String s = sc.next();
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == false)
            System.out.println(false);
        else
            System.out.println(true);

    }
}