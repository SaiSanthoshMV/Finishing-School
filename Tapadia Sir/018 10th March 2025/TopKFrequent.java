/*You are given an integer array containing numbers, and an integer k. 
Your task is to return the k most frequent elements in the array.

If multiple elements have the same frequency, the element with the higher value should be prioritized.
The output should be printed in descending order of frequency.

Input Format:
-------------
Line-1: An integer N, representing the number of elements in the array.
Line-2: A line with N space-separated integers representing the elements of the array.
Line-3: An integer k, representing the number of most frequent elements to return.

Output Format:
--------------
Line-1: An array, comma-separated integers in descending order of frequency. 
If two elements have the same frequency, the higher number should appear first.


Sample Input-1:
--------------
6
1 1 1 2 2 3
2

Sample Output-1:
----------------
[1, 2]


Sample Input-2:
--------------
1
1
1

Sample Output-2:
----------------
[1] */

import java.util.*;

public class TopKfrequent {
    public static ArrayList<Integer> getTopFrequent(int[] arr, int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            int valueCompare = Integer.compare(b[1], a[1]);
            if (valueCompare != 0) {
                return valueCompare;
            }
            return Integer.compare(b[0], a[0]);});
    
        for(int i=0;i<n;i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        
        for(int i=0;i<k;i++) {
            al.add(pq.poll()[0]);
        }
        return al;
    }
    
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(getTopFrequent(arr,n,k));
        }

}