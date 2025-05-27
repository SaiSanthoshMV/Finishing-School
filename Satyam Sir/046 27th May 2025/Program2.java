// In a faraway galaxy, interstellar explorers have mapped N planets, numbered from 
// 0 to N-1, interconnected through space routes represented by the given 'routes'. 
// Each element routes[i] = [ai, bi] denotes a direct space route between planet 
// 'ai' and planet 'bi'.

// A Critical Gateway Planet  is a special 
// planet whose removal  increases the number of 
// disconnected Galactic Regions, thereby isolating groups of planets from each other.

// Given the number of planets (N), number of routes (M) and a list of direct space 
// routes (routes), identify and list all the Critical Gateway Planets within this galaxy.

// Input Format:
// -------------
// Line-1: Two space separated integers N and M, number of planets and routes
// Next M lines: Two space separated integers ai and bi.
 
// Output Format:
// --------------
// Print an integer, number of disconnected Galactic Regions.

// Example 1:
// ----------
// Input=
// 5 5
// 0 1
// 1 2
// 2 0
// 1 3
// 3 4

// Output=
// [1, 3]

// Explanation:
// Removing planet 1 disconnects the galaxy into two separate regions: {0,2} and {3,4}.
// Removing planet 3 isolates planet 4, increasing the number of Galactic Regions.


// Example 2:
// -----------
// Input=
// 4 3
// 0 1
// 1 2
// 2 3

// Output=
// [1, 2]

// Explanation:
// Removing planet 1 or 2 increases the Galactic Regions from 1 to 2.


// Constraints:
// - 1 <= n <= 2000
// - 1 <= routes.length <= 5000
// -  routes[i].length == 2
// - 0 <= ai <= bi < n
// - ai != bi
// - No repeated space routes exist (routes).

import java.util.*;

public class Program2 {
    public static int timer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] relations = new int[e][2];
        for (int i = 0; i < e; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] a : relations) {
            adj.computeIfAbsent(a[0], k -> new ArrayList<>()).add(a[1]);
            adj.computeIfAbsent(a[1], k -> new ArrayList<>()).add(a[0]);
        }
        List<Integer> res = new ArrayList<>();
        boolean[] mark = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, visited, time, low, mark, res);
            }
        }
        for (int i = 0; i < n; i++) {
            if (mark[i]) {
                res.add(i);
            }
        }
        System.out.println(res);
    }

    private static void dfs(int sourceNode, int parent, Map<Integer, List<Integer>> adj, boolean[] visited, int[] time,
            int[] low, boolean[] mark, List<Integer> res) {
        visited[sourceNode] = true;
        time[sourceNode] = low[sourceNode] = ++timer;
        int child = 0;
        if (adj.containsKey(sourceNode)) {
            for (int v : adj.get(sourceNode)) {
                if (v == parent)
                    continue;
                if (!visited[v]) {
                    dfs(v, sourceNode, adj, visited, time, low, mark, res);
                    low[sourceNode] = Math.min(low[sourceNode], low[v]);
                    if (low[v] >= time[sourceNode] && parent != -1) {
                        mark[sourceNode]=true;
                    }
                    child++;
                } else {
                    low[sourceNode] = Math.min(low[sourceNode], time[v]);
                }
            }
        }
        if (child > 0 && parent == -1) {
            mark[sourceNode] = true;
        }
    }
}
