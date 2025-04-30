// You are given an undirected graph represented by n nodes numbered from 0 to n-1, and a list of e edges, where each edge connects two nodes.

// Your task is to implement a program that calculates the total number of connected components in the graph. 
// A connected component is a group of nodes such that there is a path between any two nodes with in the group
// and no node in the group is connected to any node outside of it.

// Your program should use Breadth-First Search (BFS) to explore the graph.

// Input Format:
// ------------

// - The first line contains two integers n and e — the number of nodes and edges.
// - The next e lines each contain two integers u and v, indicating that there is an undirected edge between node u and node v.

// Output Format:
// --------------
// - Output a single integer — the number of connected components in the graph.

// Constraints:
// ------------
// - 1≤ n ≤10000 
// - 0≤ e ≤100000 
// - 0≤ u,v <n

// Example Input:
// -------------
// 6 4
// 0 1
// 1 2
// 3 4
// 4 5

// Example Output:
// --------------
// 2

// Explanation:
// ------------
// There are two connected components in the graph:

// - Component 1: {0, 1, 2}
// - Component 2: {3, 4, 5}

import java.util.*;

public class Program2 {
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
                bfs(mp, visited, i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(Map<Integer, List<Integer>> adj, boolean[] visited, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (adj.containsKey(curr)) {
                for (int v : adj.get(curr)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
        }
    }
}