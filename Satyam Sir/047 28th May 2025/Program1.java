// You are managing a social media platform with n users. Each user initially belongs to their own social group. 
// Over time, users form friendships, and each friendship connects two users into the same group. 
// Your task is to process a list of friendship connections, and then answer a series of queries asking whether two users are in the same 
// group.

// Friendships form before any queries are made. After all friendships are processed, for each query, 
// return whether the two queried users are in the same group.

// Input Format:
// -------------
// The first line contains an integer n — the number of users (0-indexed).

// The second line contains an integer c — the number of friendship connections.

// The next c lines each contain two integers a and b — indicating a friendship between user a and user b.

// The next line contains an integer q — the number of queries.

// The following q lines each contain two integers u and v — a query asking whether users u and v are in the same group.

// Output Format:
// ---------------
// For each query, print "Yes" if the two users are in the same group, otherwise print "No".

// Example Input:
// --------------
// 5
// 3
// 0 1
// 1 2
// 3 4
// 3
// 0 2
// 1 4
// 3 4

// Example Output:
// --------------
// Yes
// No
// Yes


// Constraints:
// -------------
// 1 <= n <= 10^5
// 0 <= a, b, u, v < n

// -Friendship connections are undirected
// -No self-loops in connections or queries
// -Efficient solution required (use DSU with path compression)

// Note:
// ----
// -Use Disjoint Set Union (Union-Find) to merge users into the same group during the connection phase.
// -Only use find() during query processing to check if two users belong to the same root (group).
import java.util.*;

public class Program1 {
    static int[] rank;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        rank=new int[n];
        parent=new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
        System.out.println(getResult(n, e, edges, queries));
    }

    private static List<String> getResult(int n, int e, int[][] edges, int[][] queries) {
        List<String> res = new ArrayList<>();
        for (int[] edge : edges) {
            if (parent[edge[0]] != parent[edge[1]]) {
                union(edge[0], edge[1]);
            }
        }
        for (int[] q : queries) {
            if (parent[q[0]] == parent[q[1]]) {
                res.add("Yes");
            }
            else {
                res.add("No");
            }
        }
        return res;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int x_Rank = find(x);
        int y_Rank = find(y);
        if(x_Rank==y_Rank)
            return;
        if (rank[x_Rank] < rank[y_Rank]) {
            parent[x_Rank] = y_Rank;
        }
        else if (rank[x_Rank] > rank[y_Rank]) {
            parent[y_Rank] = x_Rank;
        }
        else {
            parent[y_Rank] = x_Rank;
            rank[x_Rank]++;
        }
    }
}