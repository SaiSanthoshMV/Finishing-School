// Mystic Energy Number

// In an ancient civilization, numbers were believed to carry mystical energy. 
// A number is considered blessed if repeatedly replacing it with the sum of the squares of its digits eventually results in 1. 
// However, if it falls into a never-ending cycle that does not include 1, it is considered cursed.

// Input
// An integer num (1 ≤ num ≤ 10⁶).
// Output
// Print "Blessed Number" if the number eventually reaches 1.
// Otherwise, print "Cursed Number".


// Example
// Input = 23  
// Output = Blessed Number

// (Explanation: 23 → 2² + 3² = 13 → 1² + 3² = 10 → 1² + 0² = 1, so it is a Blessed Number.)

// Input = 25  
// Output = Cursed Number
// (Explanation: 25 falls into a cycle and does not reach 1.)
import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // boolean res = isHappy(n);
        if (isHappy(n)) {
            System.out.println("Blessed Number");
        }
        else   System.out.println("Cursed Number");
    }

    private static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum += Math.pow(temp, 2);
            n = n / 10;
        }
        return sum;
    }

    private static boolean isHappy(int n) {
        while(n!=1 && n!=4)
            n = sum(n);
        return n == 1;
    }
}