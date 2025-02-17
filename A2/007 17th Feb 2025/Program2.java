// Amazon fire tv stick keyboard wanted to be operated on number pad. 
// You will be given the below pad. 
// You are supposed to print all possible words in alphabetic order for a given number (0-9)

// 	1		2		3
// 		   abc	  def
		 
// 	4		5		6
//    ghi     jkl    mno
  
// 	7		8		9
//   pqrs     tuv   wxyz
	
// 	*		0		#


// You will be given a string S which contains (2-9)  only  
// For example: S = "3", then the possible words are "d", "e", "f".

// Input Format:
// -------------
// String(2-9)

// Output Format:
// --------------
// Print the list of words in alphabetical order


// Sample Input-1:
// ---------------
// 2

// Sample Output-1:
// ----------------
// a b c


// Sample Input-2:
// ---------------
// 24

// Sample Output-2:
// ----------------
// ag ah ai bg bh bi cg ch ci


import java.util.*;

public class Program2 {
    static String[] keyPad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> res = new ArrayList<>();
        getCombinations(s, 0, new StringBuilder(), res);
        Collections.sort(res);
        System.out.println(res);
    }

    private static void getCombinations(String s, int index, StringBuilder curr, List<String> res) {
        if (index == s.length()) {
            res.add(curr.toString());
            return;
        }
        int digit = Character.getNumericValue(s.charAt(index));
        for (char ch : keyPad[digit].toCharArray()) {
            curr.append(ch);
            getCombinations(s, index + 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}