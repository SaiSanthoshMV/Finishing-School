// There are N cities, and M routes[], each route is a path between two cities.
// routes[i] = [city1, city2], there is a travel route between city1 and city2.
// Each city is numbered from 0 to N-1.
 
// There are one or more Regions formed among N cities. 
// A Region is formed in such way that you can travel between any two cities 
// in the region that are connected directly and indirectly.
 
// Your task is to findout the number of regions formed between N cities. 
 
// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of cities and routes
// Next M lines: Two space separated integers city1, city2.
 
// Output Format:
// --------------
// Print an integer, number of regions formed.
 
 
// Sample Input-1:
// ---------------
// 5 4 
// 0 1
// 0 2
// 1 2
// 3 4
 
// Sample Output-1:
// ----------------
// 2
 
 
// Sample Input-2:
// ---------------
// 5 6
// 0 1
// 0 2
// 2 3
// 1 2
// 1 4
// 2 4
 
// Sample Output-2:
// ----------------
// 1

import java.util.*;

public class Program1 {
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            union(edges[i][0], edges[i][1]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int x_ptr = find(x);
        int y_ptr = find(y);
        if(x_ptr==y_ptr)
            return;
        if (rank[x_ptr] < rank[y_ptr]) {
            parent[y_ptr] = x_ptr;
        }
        else if (rank[x_ptr] > rank[y_ptr]) {
            parent[x_ptr] = y_ptr;
        }
        else {
            parent[y_ptr] = x_ptr;
            rank[x_ptr]++;
        }
    }
}