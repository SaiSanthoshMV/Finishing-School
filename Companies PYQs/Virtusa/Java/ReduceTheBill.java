/*
11. REDUCE THE BILL


Darryl visits a clothing store to buy some clothes. The clothing store has an ongoing special offer that helps
customers save their money.The customers must convert their bill amount of N dollars into its binary equivalent.
Then they must flip any single bit with the aim of decreasing their bill amount when it is converted back to
its decimal equivalent. Your task is to help Darryl find and return an integer value representing the minimum amount
of dollars he must pay for his shopping after availing the offer.

Note:
  N is an integer value.
  Flipping a bit means converting bit 0 to bit 1 or vice versa.
  Assume 1 based indexing for bits, starting from left to right.
  Darryl must flip a bit.


Input Specification:
---------------------

input1: An integer value N, representing the initial bill amount in dollars.

Output Specification:
----------------------
Return an integer value representing the minimum amount of dollars he must pay for his shopping after availing 
the offer.

Example 1: 
----------
input1: 12

Output : 4

Explanation:
------------
12 can be represented as 1100 in binary form. On flipping one bit at a time we can get the following bill amounts

  By flipping the 1st bit, we obtain 0100 which is 4 in decimal from.

  By flipping the 2nd bit, we obtain 1000 which is 8 in decimal from.

  By flipping the 3rd bit, we obtain 1110 which is 14 in decimal from.

  By flipping the 4th bit, we obtain 1101 which is 13 in decimal from.

Clearly, the minimum possible final bill amount value is 4 dollar.Hence, 4 is returned as the output.

Example 2:
----------

input1 : 0

Output : 1

Explanation:
------------
O can be represented as 0000 in binary form. Even though 0 is the minimum bill amount Darryl must flip a bit once. 
The following bill amounts can be obtained on flipping a bit at a time:

  By flipping the 1st bit, we obtain 1000 which is 8 in decimal form.

  By flipping the 2nd bit, we obtain 0100 which is 4 in decimal form.

  By flipping the 3rd bit, we obtain 0010 which is 2 in decimal form.

  By flipping the 4th bit, we obtain 0001 which is 1 in decimal form.

Clearly, the minimum possible final bill amount value is 1 dollar.Hence, 1 is returned as the output.

*/
public class ReduceTheBill {

    public static int reduceBill(int N) {
        String binary = Integer.toBinaryString(N);
        int len = binary.length();
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            char[] chars = binary.toCharArray();
            // Flip the bit
            chars[i] = chars[i] == '0' ? '1' : '0';
            String modified = new String(chars);
            int val = Integer.parseInt(modified, 2);
            minValue = Math.min(minValue, val);
        }

        // Consider the case of leading 0 added by flipping an implicit 0
        StringBuilder withLeadingOne = new StringBuilder("1");
        for (int i = 0; i < len; i++) withLeadingOne.append('0');
        int val = Integer.parseInt(withLeadingOne.toString(), 2);
        minValue = Math.min(minValue, val);

        return minValue;
    }

    public static void main(String[] args) {
        System.out.println(reduceBill(12)); // Output: 4
        System.out.println(reduceBill(0));  // Output: 1
    }
}
