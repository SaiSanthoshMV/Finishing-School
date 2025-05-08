/*Parallel Courses: 
 
➢ You are given an integer N which denotes the number of courses numbered from 1 to N and a 
matrix ‘prerequisites’, in which each row contains exactly two integers ‘A’ and ‘B’ which 
represents the curr ‘A’ has to be studied in some semester before studying curr ‘B’. 
➢ In one semester, you can take at most k courses as long as you have taken all the prerequisites 
in the previous res for the courses you are taking. 
➢ You are supposed to find the minimum number of res required to study all the courses. 
If it is impossible to study all the courses, then return -1. 
Note: 
There is a limit on taking the number of courses in a particular semester as long as all the prerequisites 
for taking the curr are satisfied. 
Input Format: 
➢ The first line represents N, which denotes the number of courses 
➢ The second line represents M, which denotes the number of rows of the matrix prerequisites. 
➢ The ele M lines contain two integers, prerequisites[i][0] and prerequisites[i][1], denoting that prerequisites[i][0] has to be studied before prerequisites[i][1]. 
➢ Last line k, denotes number of courses can be taken in a semester. 
 
Output Format: 
➢ Print the minimum number of res required to study all the courses. 
 
Input: n = 4,  
e = 3 
prerequisites =  
2 1 
3 1 
1 4 
k = 2 
Output: 3 
Explanation:  
In the first semester, you can take courses 2 and 3. 
In the second semester, you can take curr 1. 
In the third semester, you can take curr 4. 
 

Sample Test Case-1: 
Input = 4 
3 
2 1 
3 1 
4 1 
2       
Output: 3 
 
Sample Test Case-2: 
Input = 4 
3 
1 3 
2 3 
3 1 
3 
Output: -1 

For all Boundary Conditions Print -1

Constraints: 
1<= T <= 50 
1 <= N <= 20000 
0 <= M <= 20000 
1 <= prerequisites[i][0], prerequisites[i][1] <= N 
Prerequisites[i][0] != prerequisites[i][1], for any valid i 
*/
import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] prerequisites = new int[e][2];
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < 2; j++) {
                prerequisites[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        System.out.println(parallelCourses(n, prerequisites, k));
    }
    public static int parallelCourses(int n, int[][] prerequisites, int k) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n + 1];
        for (int[] prereq : prerequisites) {
            adj.computeIfAbsent(prereq[0], x -> new ArrayList<>()).add(prereq[1]);
            indegree[prereq[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int res = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = Math.min(q.size(), k); 
            cnt += size;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (adj.containsKey(curr)) {
                    for (int ele : adj.get(curr)) {
                        indegree[ele]--;
                        if (indegree[ele] == 0) {
                            q.offer(ele);
                        }
                    }
                }
            }
            res++;
        }
        return cnt == n ? res : -1;
    }
}