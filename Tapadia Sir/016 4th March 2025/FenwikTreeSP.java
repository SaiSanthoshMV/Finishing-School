/*Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of N numbers, and asked the students 
to perform the operations listed below:
1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
2. update(ind, val) - update the value at the index 'ind' to 'val'.

Your task is to solve this problem using Fenwick Tree concept.

Input Format:
-------------
Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
Line-2: N space separated integers.
next Q lines: Three integers option, start/ind and end/val.

Output Format:
--------------
An integer result, for every sumRange query.


Sample Input-1:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		//sumRange
1 0 7		//sumRange
2 2 18	//update
2 4 17	//update
1 2 7		//sumRange

Sample Output-1:
----------------
75
86
80



Sample Input-2:
---------------
8 5
1 2 13 4 25 16 17 8
1 2 6		
1 0 7		
2 2 18	
2 4 17	
1 0 7

Sample Output-2:
----------------
75
86
83
 */

import java.util.*;

class Solution {
    int nums[];
    int bits[];
    int n;
    public Solution(int n) {
        nums = new int[n];
        bits = new int[n+1];
        this.n = n;
    }
    public void init(int num,int i) {
        i++;
        while(i<=n) {
            bits[i]+=num;
            i+=(i&-i);
        }
    }
    public int getSum(int i) {
        i++;
        int sum=0;
        while(i>0) {
            sum+=bits[i];
            i-=(i&-i);
        }
        return sum;
    }
    public void update(int i, int num) {
        int dif = num-(getSum(i)-getSum(i-1));
        init(dif,i);
    }

}

public class FenWickTree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        Solution fwt = new Solution(n);
        for(int i=0;i<n;i++) {
            fwt.init(sc.nextInt(),i);
        }
        while(q-- > 0) {
            int k = sc.nextInt();
            int i = sc.nextInt();
            int j = sc.nextInt();
            if(k==1) {
                System.out.println(fwt.getSum(j)-fwt.getSum(i-1));
            }
            if(k==2) {
                fwt.update(i,j);
            }
        }
    }

}