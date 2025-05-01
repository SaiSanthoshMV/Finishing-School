// Given an undirected, connected mp, identify all articulation points in the mp.

// An articulation point (or cut vertex) is a vertex that, when removed along with its associated edges, 
// increases the number of connected components in the mp. These vertices are critical for maintaining the connectivity of the mp.

// Input Format:
// ------------
// - The first line contains two integers V and E — the number of vertices and edges in the mp.
// - The next E lines contain two integers u and v — representing an undirected edge between vertex u and vertex v.
// Vertices are numbered from 0 to V - 1.

// Output Format:
// --------------
// - Print a list of articulation points in increasing order.
// - If there are no articulation points, print an empty list [].

// Constraints:
// -------------
// - 1≤ V ≤10^4
// - 0≤ E ≤10^5
// - No self-loops or multiple edges.

// Example Input 1:
// ----------------
// 5 5
// 1 0
// 0 2
// 2 1
// 0 3
// 3 4

// Example Output 1:
// ------------------
// [0, 3]

// Explanation: 
// -------------
// Removing vertex 0 disconnects 3 and 4 from the rest of the mp.  
// Removing 3 disconnects 4. So both are articulation points.

// Example Input 2:
// -----------------
// 4 3
// 0 1
// 1 2
// 2 3

// Example Output 2:
// -----------------
// [1, 2]

// Notes:
// -------
// - The mp may contain multiple components.
// - The result should be based on DFS traversal using Tarjan’s algorithm for finding articulation points efficiently.

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] arr=new int[E][2];
        for(int i=0;i<E;i++){
            for(int j=0;j<2;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int []edge:arr){
            int u=edge[0];
            int v=edge[1];
            mp.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            mp.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V]; 
        Set<Integer> result = new HashSet<>();
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, visited, disc, low, mp, result,time);
            }
        }

        System.out.println(result);
    }

    private static void dfs(int u, int parent, boolean[] visited, int[] disc, int[] low,
            Map<Integer, List<Integer>> mp, Set<Integer> result,int time) {
        visited[u] = true;
        disc[u] = low[u] = time++;
        int children = 0;
                
        if (mp.containsKey(u)) {
            for (int v : mp.get(u)) {
                if (!visited[v]) {
                    children++;
                    dfs(v, u, visited, disc, low, mp, result, time);
                    low[u] = Math.min(low[u], low[v]);

                    if (parent != -1 && low[v] >= disc[u]) {
                        result.add(u);
                    }
                } else if (v != parent) {
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }
        if (parent == -1 && children > 1) {
            result.add(u);
        }
    }
}
