// In the ancient land of Numeria, there was a hidden code known only to the wise sages. 
// They believed that every number carried a secret message, waiting to be uncovered.

// One day, a young scholar named Elias stumbled upon an old scroll.
// It contained a strange table of numbers and their corresponding symbols.

// He noticed a pattern:

// N	Secret Code
// 0	 ""
// 1	"0"
// 2	"1"
// 3	"00"
// 4	"01"
// 5	"10"
// 6	"11"
// 7	"000"
// The scroll contained a riddle:

// "To reveal a number’s true code, first step beyond it. Then, strip away its disguise to find what remains."

// Elias pondered this and realized the trick:

// Increase the number by 1.
// Convert it to binary.
// Remove the first ‘1’.

// Using this method, Elias was able to unlock the secret codes of any number.

// Your Task:
// Help Elias write a program that can decode any number using this method.

// Input Format:
// A single non-negative integer num.

// Output Format:
// A string representing its encoded form.

import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = Integer.toBinaryString(n + 1);
        System.out.println(s.substring(1));
    }
}