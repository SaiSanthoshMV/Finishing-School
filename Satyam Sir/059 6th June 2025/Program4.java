/*
    
Day1_Program3_OpenText_3


Mr.Woods, an electrician for Timberland city, has made some faulty connections on 
eight street lights.
The errors cause a street light to go OFF if the street lights adjacent to that 
light were both ON (represented as 1) or both OFF (represented as 0) on the previous night. 

Otherwise, the light will go ON as normal. The two street lights at the end of 
the road have only a single adjacent street light, so the light at the end can 
be assumed to be always OFF. 
The state of the lights on a particular day is considered for the following day, 
not for the same day.

Because of this fault, people are having difficulty driving on the road at night.
They have filed a complaint to the head of the highway administration. 
Based on this complaint the head has ordered a report of the state of street lights 
after M days.


Write an algorithm to output the state of the street lights after the given M days

Input Format:
------------
Line-1: An integer-currentState_ size, representing the number of street lights (N).
Line-2: N space-separated integers -currentState, representing the current state of the street lights(i.e.,either 0 or 1).
Line-3: An integer-days, representing the number of days (M).

Output Format:
--------------
Line-1: N space-separated integers representing the state of the street lights after M days.

Constraints
------------
1 <= days <= 10^6

Sample Input-1:
---------------
8
1 1 1 0 1 1 1 1
2

Sample Output-1:
----------------
0 0 0 0 0 1 1 0


Explanation:
------------
Adjacent to the street light at position 0 are street lights 0 ( assumption) and 1. So on the next day, it will be 1.
Explanation: The street light at position 1 has its adjacent street lights both 1. So on the next day, it will be 0.
The street light at position 2 had as one of its adjacent street lights 0 and the other one 1 . 
So the next day , it will be 1.
The street light at position 3 is 0 and both its adjacent street lights are 1 .So the next day the street light 
at position 3 will be 0 only similarly , we can find the state of the remaining street lights for the next day. 
So the state of the street lights after the first day is 1 0 1 0 1 0 0 1.
after two days , the state of the street lights is 0 0 0 0 0 1 1 0.


 */
import java.util.*;

 public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read size of first list
        int N1 = sc.nextInt();
        int[] list1 = new int[N1];
        
        // Read elements of first sorted list
        for (int i = 0; i < N1; i++) {
            list1[i] = sc.nextInt();
        }
        
        // Read size of second list
        int N2 = sc.nextInt();
        int[] list2 = new int[N2];
        
        // Read elements of second sorted list
        for (int i = 0; i < N2; i++) {
            list2[i] = sc.nextInt();
        }
        
        // Read target sum
        int X = sc.nextInt();
        
        // Initialize variables to find the closest pair
        int closestSum = Integer.MAX_VALUE;
        int closestA = 0, closestB = 0;
        
        // Two pointers approach
        int left = 0, right = N2 - 1;
        
        while (left < N1 && right >= 0) {
            int sum = list1[left] + list2[right];
            
            // Check if this is closer to the target sum
            if (Math.abs(sum - X) < Math.abs(closestSum - X)) {
                closestSum = sum;
                closestA = list1[left];
                closestB = list2[right];
            }
            
            // Move pointers based on the comparison with target sum
            if (sum < X) {
                left++;
            } else {
                right--;
            }
        }
        
        // Print the result as a comma-separated pair
        System.out.println(closestA + "," + closestB);
    }
 }