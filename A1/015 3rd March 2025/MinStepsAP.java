/*Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n-1 .
Return the minimum number of operations needed for n to become 1.

Sample Input-1:
---------------
8


Sample Output-1: 
----------------
3

Explanation: 8 -> 4 -> 2 -> 1

Sample Input-2:
---------------
7

Sample Output-2: 
----------------
4

Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1 */
import java.util.*;
class MinStepsAP{
    public static void main(String args[] ){
        
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int temp=n;

    int count=0,count1=0;
    while(n > 1){
        if ((n & 1) == 0){
            n = n >> 1;
            count++;
        } else {
            count++;
            int a,b;
            a= n - 1;
            b=n+1;
            if(((a/2)&1)==0){
                n=a;
            }
            else n=b;
        }


        }
        
    System.out.println(count);
    }
    
}'