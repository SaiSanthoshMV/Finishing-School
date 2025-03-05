
// A Kid built a structure using building blocks, by placing the building-blocks adjacent to each other.

// A building-block is a vertical alignment of blocks.
// 	                                ___
// here one block each represents  as |___|.

// The following structure made up of using building blocks

//                           ___
//                       ___|___|    ___
//                      |___|___|_w_|___|___              ___
//                   ___|___|___|___|___|___| w   _w_  w |___| 
//               ___|___|___|___|___|___|___|_w__|___|_w_|___|____________
    
//                0  1   3   4   2   3    2   0   1   0   2

// Once the structure is completed, kid pour water(w) on it.

// You are given a list of integers, heights of each building-block in a row.
//  Now your task How much amount of water can be stored by the structure.

//  Input Format:
//  -------------
//  Space separated integers, heights of the blocks in the structure. 

// Output Format:
//  --------------
//  Print an integer, 
  
// Sample Input:
// -------------
//  0 1 3 4 2 3 2 0 1 0 2
    
// Sample Output:
// --------------
// 6
    
// Explanation:
//  -----------
// In the above structure,  6 units of water (w represents the water in the structure)
// can be stored.



import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        // System.out.println(Arrays.toString(str));
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        // System.out.println(Arrays.toString(arr));
        System.out.println(trappingWater(arr));
    }

    private static int trappingWater(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int leftMax = prefix[i];
            int rightMax = suffix[i];
            if (arr[i] < leftMax && arr[i] < rightMax) {
                sum += Math.min(leftMax, rightMax) - arr[i];
            }
        }
        return sum;
    }
}