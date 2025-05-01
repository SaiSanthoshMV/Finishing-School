//  In an undirected adj, a bridge (also known as a cut-edge) is an edge that, when removed, increases the number of connected components in the adj. 
// In other words, removing a bridge disconnects part of the adj.

// You are given an undirected adj with V vertices and E edges.
// Your task is to identify and print all the bridges in the adj using Depth-First Search (DFS).

// Input Format:
// ------------
// - The first line contains two integers V and E — the number of vertices and edges.
// - The next E lines each contain two integers u and v, denoting an undirected edge between vertex u and vertex v.

// Output Format:
// --------------
// - Print the edges that are bridges in the adj.
// - Each bridge should be printed as a pair of vertices: u v.
// - If there are no bridges, the output should be empty.
// - Order of output does not matter.

// Constraints:
// -------------
// - 1≤ V ≤10000 
// - 0≤ E ≤100000 
// - 0≤ u,v <V
// - The adj may be disconnected.
// - No multiple edges or self-loops.

// Example Input 1:
// ----------------
// 5 5
// 1 0
// 0 2
// 2 1
// 0 3
// 3 4

// Example Output 1:
// ----------------
// 3 4
// 0 3

// Explanation:
// -------------
// Removing edge 3 4 disconnects node 4. Similarly, removing edge 0 3 disconnects node 3. These are bridges.
// However, edges like 1 0, 0 2, and 2 1 are not bridges because there are alternative paths to maintain connectivity.

// Note:
// -----
// - The program uses Tarjan’s Algorithm for bridge detection, which uses discovery cnts and low values during DFS traversal.
// - The edge list in the output does not need to be sorted.
import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++)
            for (int j = 0; j < 2; j++)
                edges[i][j] = sc.nextInt();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int[] el : edges) {
            mp.computeIfAbsent(el[0], k -> new ArrayList<>()).add(el[1]);
            mp.computeIfAbsent(el[1], k -> new ArrayList<>()).add(el[0]);
        }

        boolean[] visited = new boolean[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, cnt = 0; i < n; i++)
            if (!visited[i])
                dfs(i, -1, cnt, visited, disc, low, mp, res);
        
        for (List<Integer> b : res)
            System.out.println(b.get(0) + " " + b.get(1));
    }


    private static void dfs(int u, int parent, int cnt, boolean[] visited, int[] disc,int[] low, Map<Integer, List<Integer>> mp, List<List<Integer>> res) {
        visited[u] = true;
        disc[u] = low[u] = ++cnt;
        if (mp.containsKey(u)) {
            for (int v : mp.get(u)) {
                if (v == parent)
                    continue;
                if (!visited[v]) {
                    dfs(v, u, cnt, visited, disc, low, mp, res);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u]) {
                        res.add(Arrays.asList(u,v));
                    }
                } 
                else
                    low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}