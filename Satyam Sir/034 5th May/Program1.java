// given a graph(V) and N Edges print the Topolical Order of the Graph



// The first line of input contains the Number of Vertices followed by the Number of Edges and Edges between the Vertices 

// input = 
// 5 7
// 0 2
// 0 3
// 1 0
// 1 3
// 2 4
// 3 2
// 3 4
// output = 
// 1 0 3 2 4

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v1 = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v1);
        }
        int[] indegree = new int[v];
        for (List<Integer> neighbors : adj.values()) {
            for (int ele : neighbors) {
                indegree[ele]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            if (adj.containsKey(curr)) {
                for (int ele : adj.get(curr)) {
                    indegree[ele]--;
                    if (indegree[ele] == 0) {
                        q.offer(ele);
                    }
                }
            }
        }
        System.out.println(res.size()==v?res:-1);
    }
}