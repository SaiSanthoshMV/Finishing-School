/*
5. COUNT WRAPPED ITEMS



You are given a string S consisting of lowercase English letters and digits, where the letters represent items and the
digits represent packaging lines. You have to count how many items are wrapped by packing lines, i.e., how many letters
have a digit on the left and a digit on the right in the string . Your task is to find and return an integer value 
representing the number of items wrapped in packaging lines.



input specification:
--------------------

input 1: A string S containing only lowercase English letters and digits (0-9).



Output specification:
---------------------

Return an integer value representing the number of items wrapped in packaging lines.



Example 1:
--------- 

input1: 1a2b3c4d5

output: 4


Explanation:
------------


Here, the string S is " 1a2b3c4d5 " . We can find the wrapped items as below.

-> 'a' between 1 and 2
-> 'b' between 2 and 3
-> 'c' between 3 and 4
-> 'd' between 4 and 5

The count of such items is 4, hence 4 is returned as the output.


Example 2:
----------

input 1: 5aart6i7io8o5o56
Output: 3


Explanation:
-------------
Here , the string S is " 5aart6i7io8o5o56" . We can find the wrapped items as below.

-> 'i' between 6 and 7
-> 'o' between 8 and 5 
-> 'o' between 5 and 5

The count of such items is 3, hence 3 is returned as the output.


*/
public class CountWrappedItems {
    public static int countWrappedItems(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 1; i < n - 1; i++) {
            if (Character.isLetter(s.charAt(i)) &&
                Character.isDigit(s.charAt(i - 1)) &&
                Character.isDigit(s.charAt(i + 1))) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s1 = "a1b2c3";
        System.out.println(countWrappedItems(s1));  // Output: 2 ('b' and 'c')

        String s2 = "1a2b3";
        System.out.println(countWrappedItems(s2));  // Output: 2 ('a' and 'b')

        String s3 = "abc123";
        System.out.println(countWrappedItems(s3));  // Output: 0
    }
}
