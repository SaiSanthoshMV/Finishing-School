// In a popular convention center, multiple event sessions are scheduled, and attendees have registered for time slots to enter and 
// collect exclusive event goodies. Each session slot has a specific entry fee, which varies based on demand and timing,
// and is clearly marked on the registration pass.

// A total of N time slots have been booked for different attendees. Some attendees have booked multiple slots—sometimes consecutively, 
// sometimes scattered. After all registrations are complete, the event organizers introduce the following policies:

// -An attendee is permitted to attend only one session, and not two consecutive sessions.
// -Each attendee is identified by a unique lowercase letter.
// -The registration fees for unused or invalid slots will be refunded to the attendees.

// You are given:

//  A string representing the sequence of registered slots with attendee IDs.
//  A list of fees associated with each slot, aligned with the attendee sequence.

// Your task is to help the organizers compute the minimum total refund amount that needs to be issued to attendees due to unused 
// consecutive bookings.


// Input Format:
// -------------
// Line-1: A string S.
// Line-2: S.length() space separated integers, penalty[] points.

// Output Format:
// --------------
// Print an integer, the minimum amount to be refund.


// Sample Input-1:
// ---------------
// abcccb
// 3 5 2 7 4 3

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// There are two slots which are not used by customer-c 
// and the cost of immediate slots booked by customer-c are [2,7,4].
// So, minimum refund is 2 + 4= 6


// Sample Input-2:
// ---------------
// pqrs
// 3 2 5 2

// Sample Output-2:
// ----------------
// 0


// Sample Input-3:
// ---------------
// llmjjkjj
// 5 2 4 6 2 6 4 7

// Sample Output-3:
// ----------------
// 8

// Explanation:
// ------------
// There is one slot not used by customer-l
// There is two slots not used by customer-j
// The cost of the slots booked by customer-l are [5,2]
// The cost of the slots booked by customer-j are [6,2], [4,7]
// So, minimum refund is 2 + 2 + 4 = 8

import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // System.out.println(minCost(arr, str));
    }

    // private static minCost(int[] arr,String str){
        
    // }
}