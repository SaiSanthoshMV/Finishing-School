// There are n courses — course 0 to n-1. Some of them have prerequisites. For example, courses 
// A and B must be completed before course C can be taken (in other words, course C depends 
// on A and B). 
// ➢ Find and return an order in which all the given courses can be taken, while satisfying all the 
// prerequisites. If there exists more than one such order, any one of them would be a correct 
// answer. If no such order exists, return a special value: [-1]. 
 
// Example: 
// Notes: 
// ➢ Function accepts two arguments: The number of courses n and the list of prerequisites. 
// ➢ Prerequisites are given in the form of a two-dimensional array (or a list of lists) of 
// integers. Each inner array has exactly two elements — it is essentially a list of pairs. 
// Each pair [X, Y] represents one prerequisite: Course Y must be completed before X, X 
// depends on Y). 
// ➢ Function must return an array (list) of integers. 
// ➢ If all given courses can be taken while satisfying all given prerequisites, the returned 
// array must contain a possible ordering (if more than one such ordering exists, any one 
// must be returned). Otherwise, the function must return an array (list) with one element -1 in it. 
// Input: n=4, List of prerequisites L = 4 
// prerequisites= 
// 1 0 
// 2 0 
// 3 1 
// 3 2 
// Output:  
// According to the input:  
// ➢  Course 0 must be done before both 1 and 2 
// ➢ Courses 1 and 2 must be done before course 3 
// There are two orders in which one can take all four courses: [0, 1, 2, 3] and  
// [0, 2, 1, 3]. Both are correct answers. 
  
//  Approach: 
// ➢ This is a Topological Sort problem. We’ll cover two efficient sample solutions: one uses DFS, 
// while the second keeps track of the in-degree of the graph nodes. They have the same time and 
// space complexity in the Big-O notation in terms of the number of courses and the number of 
// prerequisites. 
// ➢ Both algorithms need a directed graph to work with. So, let us build one.  
// a. Courses become graph nodes. 
// b. Prerequisites become directed edges: for each “course A must be completed before B 
// can be taken,” we add an edge from A->B. In other words, an incoming edge means 
// that another course must be completed before this one. 
// For example, if n=4 and prerequisites= [[1, 0], [2, 0], [3, 1], [3, 2]], the graph would look like this: 
 
// ➢ The correct answer to the problem will be a topological order of the nodes. The two sample 
// solutions discussed below are essentially two different implementations of the topological sort 
// algorithm. 
// ➢ Topological ordering doesn’t exist if the graph has a cycle. Both sample solutions detect cycles 
// in their respective ways and return the special value in that case.
import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            mp.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int[] indegree = new int[n];
        for (Map.Entry<Integer, List<Integer>> m : mp.entrySet()) {
            for (int v : m.getValue()) {
                indegree[v]++;
                cnt++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            if (mp.containsKey(curr)) {
                for (int v : mp.get(curr)) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        q.offer(v);
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt != n ? res : new ArrayList<>(Arrays.asList(-1)));
    }
}