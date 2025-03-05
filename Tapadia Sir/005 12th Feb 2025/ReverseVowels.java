/*Given a string s, reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Sample Input-1:
---------------
hello

Sample Output-1:
----------------
holle

Sample Input-2:
----------------
Keshavmemorial

Sample Output-2:
----------------
Kashivmomerael
 */

import java.util.*;
class ReverseVowels{
    public static char[] solve(String s){
        List<Character> al=List.of('a','e','i','o','u','A','E','I','O','U');
        
        char [] arr=s.toCharArray();
        
        
        
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(al.contains(arr[i]) && al.contains(arr[j])){
                char temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }else if(al.contains(arr[i]) && !al.contains(arr[j])){
                j--;
            }else{
                i++;
            }
        }
       
        
        return arr;
        
       
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s=sc.next();
        
        char[] arr=new char[s.length()];
        
        arr=solve(s);
        
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        
    }
}