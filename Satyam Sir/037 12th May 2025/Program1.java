// Hulk and Thor become best friends now. 
// Hulk lives in the P-th house while Thor lives in the N-th house. 
// Hulk has decided to meet Thor every day. After going for many days, 
// he notices that there are few streets such that he passes every time 
// he goes to meet Thor, no matter which path he takes.

// You have been given a grid of N houses in the form of undirected graph. 
// Houses are numbered from 1 to N.
// For each I-th query, you have been given P (Hulk's house). 
// You have to say how many streets are there which he encnters in every path 
// he takes to go from P to N. If there is no such street, print "-1".
// Also, note P can be equal to N.

// Input Format:
// -------------
// Line-1: Two space separated integers N and M, Number of houses, number of streets.
// Next M lines: contain two space-separated integers u and v, 
// 		denoting a street between house-u and house-v.
// Next line: contains an integer P.

// Output Format:
// --------------
// Print an integer, number of streets in that path.


// Sample Input-1:
// ---------------
// 4 3
// 1 2
// 1 3
// 2 4
// 1

// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// There is only one path 1->2->4. so answer = 2


// Sample Input-2:
// ---------------
// 4 3
// 1 2
// 1 3
// 2 4
// 4

// Sample Output-2:
// ----------------
// -1

// Explanation:
// ------------
// There is no path as they both live in the same house 4.
// So answer = -1.

import java.util.*;

public class Program1 {
    static int time;
    static List<int[]> bridges;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        // Create adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int p = sc.nextInt();

        // If start and end are same
        if (p == n) {
            System.out.println(-1);
            return;
        }

        // Find all bridges
        time = 0;
        bridges = new ArrayList<>();
        int[] disc = new int[n + 1];
        int[] low = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(disc, -1);

        // Run DFS to find bridges
        dfs(p, -1, adj, disc, low, visited);

        // Count bridges that must be used
        int mandatoryBridges = 0;
        Set<Integer> reachableNodes = new HashSet<>();

        // First DFS from P to mark reachable nodes without using bridges
        dfsWithoutBridges(p, adj, new boolean[n + 1], reachableNodes, bridges);

        // If N is reachable without using bridges
        if (reachableNodes.contains(n)) {
            System.out.println(0);
            return;
        }

        // Count bridges that must be used
        for (int[] bridge : bridges) {
            // Remove bridge temporarily
            adj.get(bridge[0]).remove(Integer.valueOf(bridge[1]));
            adj.get(bridge[1]).remove(Integer.valueOf(bridge[0]));

            // Check if N is still reachable from P
            Set<Integer> temp = new HashSet<>();
            dfsNormal(p, adj, new boolean[n + 1], temp);

            if (!temp.contains(n)) {
                mandatoryBridges++;
            }

            // Add bridge back
            adj.get(bridge[0]).add(bridge[1]);
            adj.get(bridge[1]).add(bridge[0]);
        }

        System.out.println(mandatoryBridges > 0 ? mandatoryBridges : -1);
    }

    static void dfs(int u, int parent, Map<Integer, List<Integer>> adj, int[] disc, int[] low, boolean[] visited) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == parent)
                continue;

            if (!visited[v]) {
                dfs(v, u, adj, disc, low, visited);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    bridges.add(new int[] { u, v });
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static void dfsWithoutBridges(int u, Map<Integer, List<Integer>> adj, boolean[] visited,
            Set<Integer> reachable, List<int[]> bridges) {
        visited[u] = true;
        reachable.add(u);

        for (int v : adj.get(u)) {
            if (!visited[v] && !isBridge(u, v, bridges)) {
                dfsWithoutBridges(v, adj, visited, reachable, bridges);
            }
        }
    }

    static void dfsNormal(int u, Map<Integer, List<Integer>> adj, boolean[] visited, Set<Integer> reachable) {
        visited[u] = true;
        reachable.add(u);

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfsNormal(v, adj, visited, reachable);
            }
        }
    }

    static boolean isBridge(int u, int v, List<int[]> bridges) {
        for (int[] bridge : bridges) {
            if ((bridge[0] == u && bridge[1] == v) || (bridge[0] == v && bridge[1] == u)) {
                return true;
            }
        }
        return false;
    }
}