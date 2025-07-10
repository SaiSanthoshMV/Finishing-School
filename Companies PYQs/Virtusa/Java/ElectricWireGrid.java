/*
8.ELECTRIC WIRE GRID



You are given an integer array A of size N. where each element represents the current in a wire segment. 
You can invert (multiply by -1) up to X segments, but two consecutive segments cannot be inverted together due to 
stability constraints. Your task is to find and return an integer value representing the maximum possible net current
after applying the best inversions. if no valid inversion can be made, return the sum of the original array. 


input specification:
--------------------

input1:An integer value N representing the number of segments.

input2:An integer value X representing the maximum inversion of segment. 

input3:An integer array A representing the current values.

Output specification:
---------------------

Return an integer value representing the maximum possible net current after applying the best inversions.
if no valid inversion can be made, return the sum of original array.


Example 1:
---------

input1: 5
input2: 2
input3:(-3,-6,7,-8,5)

output :23

Explanation:
------------

here, there are 5 segments with current values as (-3,-6,7,-8,5) and X=2.we can find the maximum possible net
current as below:

-> invert -6 -->6

-> invert -8 -->8(skipping adjacent -6 and -8 to satisfy constraints)

The maximum net current will be (-3) + 6 + 7 + 8 + 5 = 23.Hence 23 is returned as the output.



Example 2:
----------

input1: 3
input2: 2
input3: (-13,-19,-5)


output: 1

Explanation:
-------------

Here, there are 3 segments with current values as (-13,-19,-5) and X=2. we can find the maximum possible net 
current as below:
	invert -19 --> 19 
	
The maximum net current will be (-13) + 19 + (-5) = 1. Hence , 1 is returned as the output.


*/
import java.util.*;

public class ElectricWireGrid {

    public static int maxNetCurrent(int N, int X, int[] A) {
        List<int[]> gains = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (A[i] < 0) {
                gains.add(new int[]{-2 * A[i], i}); // gain = -2 * A[i] if inverted
            }
        }

        // Sort by gain in descending order
        gains.sort((a, b) -> Integer.compare(b[0], a[0]));

        boolean[] inverted = new boolean[N];
        int count = 0;

        for (int[] gain : gains) {
            int idx = gain[1];

            // Check for adjacency
            if ((idx > 0 && inverted[idx - 1]) || (idx < N - 1 && inverted[idx + 1])) {
                continue;
            }

            if (count < X) {
                A[idx] = -A[idx];
                inverted[idx] = true;
                count++;
            } else {
                break;
            }
        }

        int total = 0;
        for (int val : A) total += val;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxNetCurrent(5, 2, new int[]{-3, -6, 7, -8, 5})); // Output: 23
        System.out.println(maxNetCurrent(3, 2, new int[]{-13, -19, -5}));     // Output: 1
    }
}
