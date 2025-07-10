/*
3. FROG IN THE POND



Near your house there is a pond that has N lily pads arranged in sequence . An integer array A contains the count 
of fallen fresh petals on each lily pad. A happy frog wants to gather as many petals as possible by jumping from one
lily pad to the next adjacent lily pad in either direction.


The frog can begin gathering petals from any lily pad, but can only jump a maximum of N-2 times.
Your task is to find and return an integer value representing the maximum number of petals that the frog can
collect in a maximum of N-2 jumps.

NOTE:

 -> Assume 1-based indexing
  
 -> if the frog lands on a lily pad, it will collect all the petals on the pad.
 
 -> The frog can begin collecting petals from any lily pad it desires.
 
 -> N is always greater than 2.
 
 
input specification:
-------------------

input1: An integer value N , representing the number of lily pads.

input2: An integer array A , containing the count of fallen petals on N lily pads.


Output specification:
----------------------

Return an integer value representing the maximum number of petals that the frog can collect in a maximum of N-2 jumps.



Example 1
---------

input1 : 3
input2 :(2,3,1)

Output : 5

Explanation:
------------

Here in this example , there are 3 lily pads and the number of fresh petals on each lily pad is as (2,3,1). 
The maximum number of jumps that the frog can make is N-2 =3-2 =1. The frog will begin from the 2nd lily pad ,
collecting 3 petals. Then he will jump to the lily pad at position 1, collecting 2 petals. The total number of 
petals collected is 3+2 =5 .Hence, 5 is returned as the output.


 Example 2:
 ----------
 
 input 1: 4
 input 2: (1,3,6,2)
 
 output: 11
 
 Explanation:
 ------------
 
 
 Here in this example, there are 4 lily pads and the number of fresh petals on each lily pad is (1,3,6,2). 
 The maximum number of jumps that the frog can make is N-2 =4-2 =2. The frog will begin from the 2nd lily pad,
 collecting 3 petals. Then he will jump to the lily pad at position 3, collecting 6 petals. Lastly , 
 he will jump to the lily pad at position 4 , collecting 2 petals. The total number of petals collected is 3+6+2 =11.
 Hence ,11 is returned as the output.
 
*/
public class OddFrequencyElement {
    public static int findOddFrequency(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num; // XOR cancels out elements that appear even number of times
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3, 1, 3};
        System.out.println(findOddFrequency(arr));  // Output: 3
    }
}
