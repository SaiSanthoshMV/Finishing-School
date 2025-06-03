// Write a recursive algorithm to calculate the value of 2 to the power of n.
// Write a recursive algorithm to calculate the value of 2 to the power of n.
import java.util.*;

public class Program6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(powOf2(2, n));
    }

    private static double powOf2(double a, long b) {
        if (b == 0) {
            return 1.0;
        }
        if (b > 0) {
            return a * powOf2(a, b - 1);
        }
        return 1 / powOf2(a, -b);
    }
}