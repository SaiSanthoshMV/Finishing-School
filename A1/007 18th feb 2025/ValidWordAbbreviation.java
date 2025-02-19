/*Given a non-empty string s and an abbreviation abbr, 
return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Notice that only the above abbreviations are valid abbreviations of the string "word". 
Any other string is not a valid abbreviation of "word".

Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Input Format:
-------------
Line-1: A string, S contains only lowercase letters
Line-2: A string, abbr contains lowercase letters and digits

Output Format:
--------------
Line-1: A boolean value.
Sample Input-1:
---------------
internationalization
i12iz4n

Sample Output-1:
---------------
true

Sample Input-2:
---------------
apple
a2e

Sample Output-2:
---------------
false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1). */



import java.util.*;
class ValidWordAbbreviation{
    public static boolean solve(String s1,String s2){
        int i=0;
        int j=0;
        
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
             
            }
            else if(s2.charAt(j)>='0' &&  s2.charAt(j)<='9'){
                String s = "";
                s+=s2.charAt(j);
                j++;
                while(j<s2.length() && Character.isDigit(s2.charAt(j))){
                    s+=s2.charAt(j);
                    j++;
                }
                
                int x=Integer.parseInt(s);
                
                i+=x;
                
                
            }else{
                return false;
            }
            
        }
        
        return i==s1.length() && j==s2.length();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        
        System.out.println(solve(s1,s2));
    }
}