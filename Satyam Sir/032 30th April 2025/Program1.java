// You are given an undirected graph with n nodes labeled from 0 to n - 1 and a list of e edges where each edge connects two nodes. 
// Your task is to determine the number of connected components in the graph.

// A connected component is a set of nodes such that there is a path between any two nodes in this set
// and the set is not connected to any other node outside it.

// Input Format:
// -----------
// - An integer n representing the number of nodes in the graph.
// - An integer e representing the number of edges.
// - e lines follow, each containing two integers u and v representing an undirected edge between node u and node v.

// Output Format:
// -------------
// - A single integer representing the number of connected components in the graph.

// Constraints:
// -------------
// - 1 <= n <= 2000
// - 0 <= e <= n * (n - 1) / 2
// - 0 <= u, v < n
// - No duplicate edges or self-loops.

// Sample Input:
// -------------
// 5
// 3
// 0 1
// 1 2
// 3 4

// Sample Output:
// --------------
// 2

// Explanation:
// -------------
// - Component 1: Nodes 0, 1, 2 are connected.
// - Component 2: Nodes 3 and 4 are connected.
// - Node 5 is not part of any edge and forms its own component if n were larger.

import java.util.*;
public class Program1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] arr = new int[e][2];
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] ele : arr) {
            int u = ele[0];
            int v = ele[1];
            mp.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(mp, visited, i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int source) {
        visited[source] = true;
        if (adj.containsKey(source)) {
            for (int v : adj.get(source)) {
                if (!visited[v]) {
                    dfs(adj, visited, v);
                }
            }
        }
    }
}