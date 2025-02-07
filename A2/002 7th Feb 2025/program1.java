// Mr. Bob is a Military Encoders. 
//  Mr. Bob writes a word as shown below and then merges them. 
//  Help Bob to write the code. 
  
//  Mr. Bob will be given a word 'w' and a number 'n' 
  
// Sample Test Case - 1
// input = 
// ABCDE
//  2
// output = ACEBD
    
    
// This is How Bob writes the letters of the word 
// A C E
//  B D
    
// Now concatenate the two rows and ignore spaces in every row. We get ACEBD
    
    
// Sample Test Case - 2
// input = system
// 3
// output = seytms
    
//  s   e
//   y t m
//    s

// Now concatenate the 3 rows we get seytms

import java.util.*;
public class program1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();
        System.out.println(zigZagRes(str, n));
        sc.close();
    }
    public static String zigZagRes(String str,int n){
        if(n==1 || n>=str.length()){
            return str;
        }
        StringBuilder[] strArray=new StringBuilder[n];
        for(int i=0;i<n;i++){
            strArray[i]=new StringBuilder();
        }
        StringBuilder res=new StringBuilder();
        int ind=0;
        boolean flag=false;
        for(char ch:str.toCharArray()){
            strArray[ind].append(ch);
            if(ind==0 || ind==n-1){
                flag=!flag;
            }
            if(flag){
                ind+=1;
            }
            else{
                ind-=1;
            }
        }
        for(StringBuilder ch:strArray){
            res.append(ch);
        }
        return res.toString();
        
    }
}