// Write a recursive algorithm to calculate the value of 2 to the power of n.
import java.util.*;

public class Program6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(recPow(2, n));
    }

    private static double recPow(double a, long b) {
        if (b == 0)
            return 1.0;
        double half = recPow(a, b / 2);
        double res = half * half;
        if (b % 2 == 1) {
            res *= (b > 0 ? a : 1.0 / a);
        }
        return res;
    }
}