
/*
Lets say we are in the DFS, looking through the edges starting from vertex (v). 
The current edge (v, to) is a bridge if and only if none of the vertices (to) and its descendants 
in the DFS traversal tree has a back-edge to vertex (v) or any of its ancestors. 
Indeed, this condition means that there is no other way from (v) to (to) except for edge (v, to)

1. Initially all Vertices(V) of Graph(G) are set to 'False'(implies as not visited). 
Now we start by traversing to a particular vertex u (start) and its value is set to 'True'(implies as visited).

2. Also its respective details like discovery time and low value are updated 
with the current time(for each iteration this time is incremented by 1).

3. At this stage to check for connectivity, we recursively find the all the vertices v adjacent to u (start).

4. If vertex v is not visited, we update the parent value for vertex v as vertex u and Goto Step 1.

4a. Also check if the subtree rooted with v has a connection to one of the ancestors of u (start), 
find the minimum low value like: low[u] = min(low[u],low[v]).

4b. Check if the lowest vertex reachable from subtree under v is under u in DFS, 
then the edge u-v is a bridge.

5. If vertex v is visited and it is not the current parent, we need to update 
the low value of u vertex, low[u] = min(low[u], disc[v]).

Sample Input:
---------------
5 5
1 2
1 3
3 4
1 5
2 5

2
1 3
2 4
2 5
*/

import java.io.*;
import java.util.*;
 
class FindingBridgesGraph
{
	static List<Integer>[] graph;
    static int[] parent, disc, low;
    static boolean[] vis;
    static int n, m;
	static int[][] edges;
	static int edgeCount;

    public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		graph = new ArrayList[n+1];
		parent = new int[n+1];
		disc = new int[n+1];
		low = new int[n+1];
		vis = new boolean[n+1];
		edges = new int[m][2];
			
		for(int i = 1 ; i <= n; i++)
		{
			graph[i] = new ArrayList<>();
			parent[i] = -1;
			vis[i] = false;
		}		
		
		for(int i = 1; i <= m; i++) 
		{
			int u = in.nextInt(), v = in.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		} 
		
        findBridgesDFS(n, 0);
		printBridges();
    }
 
    static void findBridgesDFS(int start, int time) 
	{
        vis[start] = true;
        disc[start] = low[start] = ++time;
 		System.out.println("\n\nstart " + start + " time " + time + " disc[start] " + disc[start] + " low[start] " + low[start]);

        for(int v : graph[start]) 
		{
			System.out.println("parent " + start + " child " + v);
            if(!vis[v]) 
			{
                parent[v] = start;
                findBridgesDFS(v, time);
				System.out.println("After findBridgesDFS start " + start + " low[start] " + low[start] + " v " + v + " low[v] " + low[v]);
                low[start] = Math.min(low[start], low[v]);
                
				// If start is not root and low value of one of its child is more than discovery value of start
                if(low[v] > disc[start])
				{ 
					edges[edgeCount][0] = start;
					edges[edgeCount][1] = v;
					edgeCount++;
					System.out.println("edgeCount " + edgeCount);
                } 
            }
			// Update low value of start 
            else if(parent[start] != v) // Not the current parent
			System.out.println("Else if v " + v + " disc[v] " + disc[v] + " start " + start + " low[start] " + low[start]);
                low[start] = Math.min(disc[v], low[start]);
            
        }
    }

	static void printBridges()
	{
		System.out.println("\n\nCount of bridges " + edgeCount);           

		System.out.println("The bridge edges are");
		for(int i = 0 ; i < m; i++) 
			System.out.println("Vertex " + edges[i][0] + " vertex " + edges[i][1]);
	}

}