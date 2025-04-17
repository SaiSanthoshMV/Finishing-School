// In a mysterious land of numbers, a special number is called a "Mirror Tail" number. 

// A number earns this title if, after squaring it, the last few digits of the square are 
// identical to the number itself.

// Sample Example:
// input: 
// -----
// 5
// 1 5 6 25 76 

// output:
// -------
// YES 
// YES 
// YES 
// YES 
// YES

// Example:
// 5  -> 5² = 25 -> ends with 5 
// 6 - >6² = 36 -> ends with 6
// 76 -> 76² = 5776 ->  ends with 76
// 25 -> 25² = 625 -> ends with 25 

// If it is a Mirror Tail Print "YES" , else Print "NO" 

import java.util.*;

public class Program1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        for(long ele:arr){
            if(checkMagical(ele))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    private static boolean checkMagical(long ele){
        if(ele==0)
            return true;
        long square=ele*ele;
        int len=(int)Math.log10(ele)+1;
        long res=square%(int)Math.pow(10,len);
        return res==ele;
    }
}