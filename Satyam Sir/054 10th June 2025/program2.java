
// P-2 Flowers

/*
Emma owns a boutique and decides to design a new gown. She wants to design the gown by printing some flowers over it. 
There are X printing blocks in total, and each block consists of some number of flowers.

your task is to Help Emma find and return the maximum number of flowers that cannot be printed on the gown, using the X printing blocks.

Any block can be used any number of times.

Note: The number of flowers on any two blocks is co-prime.

Input Specification:

 input1: An integer value X, representing the total number of blocks available
 input2: An integer array representing the number of flowers on each printing block

Output Specification:

 Return an integer value representing the maximum number of flowers that cannot be printed on the gown.

Example 1:
----------
input1: 2  
input2: [3, 5]  

Output: 7  

Explanation:
------------
Emma has two blocks: one of 3 flowers, one of 5 flowers. 
She cannot print 1, 2, 4, and 7 flowers using the given blocks but can print any higher integral.

Since 7 is the maximum number of flowers that cannot be printed, 
therefore 7 is returned as the output.

Example 2:
----------
input1: 2  
input2: [2, 5]  

Output: 3  

Explanation:
------------
Emma has two blocks:
one has 2 flowers and the other has 5 flowers.
she cannot print 1 flower and 3 flowers using these blocks but can print any higher integral.
since 3 is the maximum number of flowers that cannot be printed.
therefore 3 is returned as output.*/

/*
#include<bits/stdc++.h>
using namespace std;
bool iscomb(int sum, vector<int>&nums, int i){
    if(sum == 0){
        return true;
    }
    if(sum < 0 || i >= nums.size()){
        return false;
    }
    if(iscomb(sum-nums[i],nums,i)){
        return true;
    }
    return iscomb(sum,nums,i+1);
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    int ans = 0;
    for(int i = 0; i < 90; i++){
        if(!iscomb(i,nums,0)){
            ans = i;
        }
    }
    cout << ans << endl;
}
*/

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt(); 
        int[] blocks = new int[X];
        for (int i = 0; i < X; i++) {
        blocks[i] = sc.nextInt();
}

        int ans = maxUnprintableFlowers(blocks);
        System.out.println(ans);
    }
    private static int maxUnprintableFlowers(int[] a) {
        Arrays.sort(a);
        int smallest     = a[0];
        int secondSmallest = (a.length > 1) ? a[1] : a[0];
        int limit = smallest * secondSmallest - smallest - secondSmallest;
        if (limit < 0) return 0;

        boolean[] reachable = new boolean[limit + 1];
        reachable[0] = true;    
        for (int i = 1; i <= limit; i++) {
            for (int size : a) {
                if (size > i) break;    
                if (reachable[i - size]) {
                    reachable[i] = true;
                    break;
                }
            }
        }
        for (int i = limit; i >= 1; i--) {
            if (!reachable[i]) return i;
        }
        return 0; 
    }
}

