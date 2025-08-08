/*
Day4_Program1


You’re working with a train station log, which records the station IDs visited by a train in the exact order they were passed. This log is given as an array of integers.

You are tasked with simulating a scanner that slides over this log with a window of size K, and for every such window, you must count how many unique stations appear in that segment.

Input Format:
-------------
Line-1: An integer N — number of stations in the log.
Line-2: A line with N space-separated integers representing station IDs.
Line-3: An integer K — window size.

Output Format:
--------------
Line-1: Print N - K + 1 space-separated integers — each representing the count of unique stations in the corresponding window.

Sample Input-1:
---------------
7  
1 2 1 3 4 2 3  
4

Sample Output-1:
----------------
3 4 4 3

Sample Input-2:
---------------
5  
5 5 5 5 5  
3

Sample Output-2:
----------------
1 1 1


Constraints:
------------
-> 1 ≤ N ≤ 10⁵
-> 1 ≤ K ≤ N
-> Station IDs are integers and may repeat.

*/

import java.util.*;
import java.util.stream.Collectors;

class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of stations
        int N = sc.nextInt();
        int[] stations = new int[N];
        
        // Read station IDs
        for (int i = 0; i < N; i++) {
            stations[i] = sc.nextInt();
        }
        
        // Read window size
        int K = sc.nextInt();
        
        // To store the result counts
        List<Integer> result = new ArrayList<>();
        
        // Map to count occurrences of station IDs in the current window
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Initialize the first window
        for (int i = 0; i < K; i++) {
            countMap.put(stations[i], countMap.getOrDefault(stations[i], 0) + 1);
        }
        
        // Add the count of unique stations in the first window
        result.add(countMap.size());
        
        // Slide the window across the log
        for (int i = K; i < N; i++) {
            // Remove the element going out of the window
            int outgoingStation = stations[i - K];
            countMap.put(outgoingStation, countMap.get(outgoingStation) - 1);
            if (countMap.get(outgoingStation) == 0) {
                countMap.remove(outgoingStation);
            }
            
            // Add the new element coming into the window
            int incomingStation = stations[i];
            countMap.put(incomingStation, countMap.getOrDefault(incomingStation, 0) + 1);
            
            // Add the current unique count to result
            result.add(countMap.size());
        }
        
        // Print the result as space-separated integers
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}