/*
// number to words

Imagine a system that can "speak" numbers. Your task is to build this system for the range of zero to nine hundred and ninety-nine. 
Given an integer within this scope, the system should articulate its value in standard English words.
If a number falls outside this speaking range, the system should indicate its inability to translate.

Input:
------
A single integer num such that 0 <= num < 1000.

Output:
-------
A string representing the English words for the number.

If the number is not in range, output: "Out of range"

Example 1:
-------
Input:
219

Output:
Two Hundred and Nineteen

Example 2:
-----------
Input:
1001

Output:
Out of range
*/


import java.util.*;
class test{
    static String helper(int n){
        switch(n){
            case 1:
                return "One";
            case 2:
                return "Two" ;
            case 3:
                return "Three" ;
            case 4:
                return "Four" ;
            case 5:
                return "Five" ;
            case 6:
                return "Six" ;
            case 7:
                return "Seven" ;
            case 8:
                return "Eight" ;
            case 9:
                return "Nine" ;
            case 10:
                return "Ten" ;
            case 11:
                return "Eleven" ;
            case 12:
                return "Twelve" ;
            case 13:
                return "Thirteen" ;
            case 14:
                return "Fourteen" ;
            case 15:
                return "Fifteen" ;
            case 16:
                return "Sixteen" ;
            case 17:
                return "Seventeen" ;
            case 18:
                return "Eighteen" ;
            case 19:
                return "Nineteen" ;
            case 20:
                return "Twenty" ;
            case 30:
                return "Thirty" ;
            case 40:
                return "Fourty" ;
            case 50:
                return "Fifty" ;
            case 60:
                return "Sixty" ;
            case 70:
                return "Seventy" ;
            case 80:
                return "Eighty" ;
            case 90:
                return "Ninety" ;
            case 100:
                return "Hundred";
            default:
                return "";
        }
    }
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
	    int ones = n % 10;
        if(n <= 20 || ones == 0){
            System.out.println(helper(n));
        }
        else{
            int tens = n / 10;
            System.out.println(helper(tens * 10) + " " + helper(ones));
        }
    }
}

/*
Time Complexity: O(1)
Space Complexity: O(1)
 */