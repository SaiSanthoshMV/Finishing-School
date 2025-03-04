/*4You are given an integer array nums of length n and an integer target. 
Your task is to find three integers in nums such that their sum is closest to the given target.

Return the sum of these three integers.

You may assume that each input would have exactly one solution.

Input Format:
-------------
Line-1: An integer n, the size of the array.
Line-2: n space-separated integers representing the elements of the array nums.
Line-3: A single integer target.

Output Format:
--------------
Line-1: Print a single integer, representing the sum of three integers closest to the target.

Sample Input-1:
---------------
4
-1 2 1 -4
1

Sample Output-1:
----------------
2

Sample Input-2:
---------------
3
0 0 0
1

Sample Output-2:
----------------
0

 */


import java.util.*;

class ThreeSumClosest {


    public static int solve(List<Integer> l, int s) {


        int n = l.size();
        Collections.sort(l);
        
        int closestSum = Integer.MAX_VALUE; 
        
        for (int i = 0; i < n - 2; i++) {

            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sum = l.get(i) + l.get(j) + l.get(k);
                
                if (Math.abs(sum - s) < Math.abs(closestSum - s)) {
                    closestSum = sum;
                }
                
                if (sum == s) {
                    return sum;
                }
                
                if (sum < s) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return closestSum; 
    }
    
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            l.add(sc.nextInt());
        }
        
        int s = sc.nextInt(); 
        System.out.println(solve(l, s)); 
    }

}