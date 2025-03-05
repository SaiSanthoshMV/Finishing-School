/*Mr.Ram is a sales manager of Dmart, for his analysis he has to monitor 
sales of Dmart every day. He need to send report of maximum sales 
of every K consecutive days from given N number of days sales.
Write a java program to do his task easy.

Input Format:
-------------
Line-1: Two space separated integers, N and K
Line-2: N space separated integers, sales[].

Output Format:
--------------
Print maximum sales of every K consecutive days


Sample Input 1:
---------------
9 3
1 2 3 1 4 5 2 3 6

Sample output 1:
----------------
3 3 4 5 5 5 6

Explanation: 
------------
Maximum of subarray {1, 2, 3} is 3
Maximum of subarray {2, 3, 1} is 3
Maximum of subarray {3, 1, 4} is 4
Maximum of subarray {1, 4, 5} is 5
Maximum of subarray {4, 5, 2} is 5
Maximum of subarray {5, 2, 3} is 5
Maximum of subarray {2, 3, 6} is 6
*/
 */


import java.util.*;
class MaxOfAllSubarraysOfSizeK{

    public static List<Integer> large(int[] arr,int k) {

        List<Integer> l = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++) {

            max = Math.max(max,arr[i]);
        }
        l.add(max);
        int lo=0;
        for(int j=k;j<arr.length;j++) {

            if(arr[lo]==max) {


                max=Integer.MIN_VALUE;
                for(int x=lo+1;x<lo+k+1;x++) {
                    max = Math.max(max,arr[x]);
                }
            }
            else {
                max = Math.max(max,arr[j]);
            }
            l.add(max);
            lo++;
        }
        return l;
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int k = sc.nextInt();
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> l = large(arr,k);
        for(int i:l) System.out.println(i+" ");
        }
    }