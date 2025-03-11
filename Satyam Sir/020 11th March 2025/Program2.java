// Imagine you are analyzing the popularity of different songs on a music streaming platform. 
// Each song has been played a certain number of times, and you have a list of song IDs representing 
// these plays.

// Your task is to identify the top k most played songs based on their frequency. 
// If two songs have been played the same number of times, the song with the higher ID should be prioritized.

// Challenge:

// Given a list of song IDs representing plays and an integer k, determine the k most popular songs, 
// sorted in descending order of play count. If multiple songs have the same number of plays, 
// the song with the higher ID should appear first.

// Are you ready to rank the top hits?

// Input Format:
// -------------
// Line-1: An integer N, representing the number of elements in the array.
// Line-2: A line with N space-separated integers representing the elements of the array.
// Line-3: An integer k, representing the number of most frequent elements to return.

// Output Format:
// --------------
// Line-1: An array, comma-separated integers in descending order of frequency. 
// If two elements have the same frequency, the higher number should appear first.


// Sample Input-1:
// --------------
// 6
// 1 1 1 2 2 3
// 2

// Sample Output-1:
// ----------------
// [1, 2]


// Sample Input-2:
// --------------
// 1
// 1
// 1

// Sample Output-2:
// ----------------
// [1]

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(getTopSongs(arr, n, k));
    }

    private static List<Integer> getTopSongs(int[] arr, int n, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : arr) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey() - b.getKey() : a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> m: mp.entrySet()) {
            pq.add(m);
            if (pq.size() > k) {
                pq.poll(); 
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(0,pq.poll().getKey()); 
        }
        return res;
    }
}