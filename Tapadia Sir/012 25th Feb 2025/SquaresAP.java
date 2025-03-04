/*Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.

Input Format:
-------------
Line-1: An integer N
Line-2: N space seperated integers

Output Format:
--------------
Line-1: A list of integers

Sample Input-1:
---------------
5
-4 -1 0 3 10

Sample Output-1: 
----------------
[0, 1, 9, 16, 100]

 */

import java.util.*;
class squares{
    public static int[] solve(int arr[]){
        int ans[]=new int[arr.length];
        int left=0;
        int right=arr.length-1;
        
        int k=arr.length-1;
        
        while(left<=right){
            int l=arr[left]*arr[left];
            int r=arr[right]*arr[right];
            if(l>r){
                ans[k]=l;
                left++;
            }else if(r>l){
                ans[k]=r;
                right--;
            }else if(r==l &&left!=right){
                ans[k]=r;
                ans[k+1]=l;
                left++;
                right--;
            }else if(r==l && left==right){
                ans[k]=r;
                left++;
                right--;
            }
            k--;
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        System.out.println(Arrays.toString(solve(arr)));
    }
}
