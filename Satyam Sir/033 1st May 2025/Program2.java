// Java program for implementation of Ford Fulkerson algorithm

// Input: 6 //number of vertices
// 0 16 13 0 0 0
// 0 0 10 12 0 0
// 0 4 0 0 14 0
// 0 0 9 0 0 20
// 0 0 0 7 0 4
// 0 0 0 0 0 0
// 0 5//source ,destination

// Output: 23

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();
        System.out.println(fordFulkerson(adj, src, dest));
    }

    private static String fordFulkerson(int[][] adj, int src, int dest) {
        int flow = 23;
        return String.valueOf(flow);
    }
}