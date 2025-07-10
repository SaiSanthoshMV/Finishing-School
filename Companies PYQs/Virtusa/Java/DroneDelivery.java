/*
18.DRONE DELIVERY

You are given a string S containing space separated IDs representing signals of a drone network .
There are some invalid IDs present in the list due to some signal imbalance, and you need to find the valid IDs
out of all of them .

For each of the ID

->if the length of the ID is even , rotate the string left by half its length.

-> if the length is odd , rotate the string right by (length/2)

After rotation ,compute a mapped sum by converting each character as follows:

-> Digits(0-9) contribute to their numeric value.

-> Vowels (a,e,i,o,u case-insensitive) contribute to 1.

-> All other characters contribute their ASCII value modulo 10.

if this sum is a perfect square (like 1,4,9,16,25, etc..) , the original ID is considered valid.

Your task is to find and return a string value representing all the space separated valid IDs ,
in the order they appeared.

Input specification:
---------------------

input1:A string S containing IDs.

Output specification:
---------------------

Return a string representing all the valid IDs, in the order they appear.

Example 1:
----------

input1: abd34 aeiou4

Output: abd34 aeiou4


Explanation:
------------

Here, the string S is "abd34 aeiou4"
for "abd34"

-> Rotate rights by (5/2)=2 which will be "34abd", in 34abd,

	'3'--> 3
	
	'4'--> 4
	
	'a'-->vowel-->1
	
	'b'-->ASCII('b')=98-->98%10=8
	
	'd'-->ASCII('d')=100-->100%10=0
	
Sum = 3 + 4 + 1 + 8 + 0 = 16.16 is a perfect square(4^2) .so "abd34" is valid.

	
for "aeiou4"

-> Rotate lefty (6/2)=3 which will be "ou4aei",in ou4aei,

	'o'--> vowel --> 1
	
	'u'--> vowel --> 1
	
	'4'--> digit --> 4
	
	'a'--> vowel --> 1
	
	'e'--> vowel --> 1
	
	'i'--> vowel --> 1
	
Sum = 1 + 1 + 4 + 1 + 1 + 1 =9. 9 is a perfect square(3^2), so "aeiou4" is valid.

Hence ,abd34 aeiou4 is returned as the output.


Example 2:
----------

input1: atyre aeiou56

output: aeiou56


Explanation:
-------------
Here, the string S is "atyre aeiou56".

for "atyre".
-> Rotate right by (5/2) =2 which will be "reaty". in reaty 
	'r' --> ASCII 114 --> 114%10 =4
	
	'e' --> vowel -->1
	
	'a' --> vowel -->1
	
	't' --> ASCII 116 --> 116%10 = 6
	
	'y' --> ASCII 121 --> 121%10 = 1
	
Sum =4 + 1 + 1 + 6 + 1 = 13. 13 is not a perfect Square,so "atyre" is invalid.



for "aeiou56" 

-> Rotate right by (7/2) = 3 which will be "u56aeiou". in u56aeiou,

	'u' --> vowel -->1
	
	'5' --> digit -->5
	
	'6' --> digit -->6
	
	'a' --> vowel -->1
	
	'e' --> vowel -->1
	
	'i' --> vowel -->1
	
	'o' --> vowel -->1

Sum = 1 + 5 + 6 + 1 + 1 + 1 + 1 = 16. 16 is a perfect square (4^2) ,so "aeiou56" is valid.

Hence,aeiou56 is returned as output.



*/
import java.util.*;

public class DroneDelivery {

    public static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static String rotate(String s) {
        int len = s.length();
        int mid = len / 2;

        if (len % 2 == 0) { // even: rotate left
            return s.substring(mid) + s.substring(0, mid);
        } else { // odd: rotate right
            return s.substring(len - mid) + s.substring(0, len - mid);
        }
    }

    public static int getMappedSum(String rotated) {
        int sum = 0;
        for (char ch : rotated.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += ch - '0';
            } else if ("aeiouAEIOU".indexOf(ch) != -1) {
                sum += 1;
            } else {
                sum += ((int) ch) % 10;
            }
        }
        return sum;
    }

    public static String findValidIDs(String S) {
        String[] ids = S.split(" ");
        List<String> validIDs = new ArrayList<>();

        for (String id : ids) {
            String rotated = rotate(id);
            int sum = getMappedSum(rotated);
            if (isPerfectSquare(sum)) {
                validIDs.add(id);
            }
        }

        return String.join(" ", validIDs);
    }

    public static void main(String[] args) {
        System.out.println(findValidIDs("abd34 aeiou4"));    // Output: abd34 aeiou4
        System.out.println(findValidIDs("atyre aeiou56"));   // Output: aeiou56
    }
}
