// A company has n offices,each initially isolated.A list of m proposed network cables between pairs of offices is provided.Your task is to determine the minimum number of cables needed to connect all offices together(i.e.,make the network fully connected).

// Each cable connects two distinct offices.Implement a function that returns the number of cables used to form the full connection or-1 if it'simpossible.

// Input Format:-------------The first line contains two integers:n and m The next m lines each contain two integers a and b—representing a cable between office a and office b

// Output Format:---------------A single integer:number of cables used to connect all offices,or-1 if not possible

// Example:

// Input:-----4 3 0 1 1 2 2 3

// Output:--------3

// Explanation:-------------n=4 offices:{0,1,2,3}m=3 cables

// Cables:(0-1),(1-2),(2-3)

// These cables can fully connect all 4 offices(via successful 3 unions)

// Hence,Output=3
import java.util.*;

public class Program2 {
    static int[] rank;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] queries = new int[e][2];
        for (int i = 0; i < e; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
        System.out.println(getCount(n, e, queries));
    }

    private static int getCount(int n, int e, int[][] queries) {
        int cnt = 0;
        int comp = n;
        for (int[] q : queries) {
            if (find(q[0]) != find(q[1])) {
                union(q[0], q[1]);
                cnt++;
                comp--;
            }
        }
        return comp == 1 ? cnt : -1;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int x_Parent = find(x);
        int y_Parent = find(y);
        if(x_Parent==y_Parent)
            return;
        if (rank[x_Parent] > rank[y_Parent]) {
            parent[y_Parent] = x_Parent;
        }
        else if (rank[x_Parent] < rank[y_Parent]) {
            parent[x_Parent] = y_Parent;
        }
        else {
            parent[y_Parent] = x_Parent;
            rank[x_Parent]++;
        }
    }
}
