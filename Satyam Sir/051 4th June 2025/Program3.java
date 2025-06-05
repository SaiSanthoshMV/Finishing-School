// Perfect number is a number whose sum of all factors (not including the number, but including 1) is equal to the number itself. 
// Write a program to find if the given number is a perfect number.
import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isPerfect(n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isPerfect(int n) {
        if(n<2)
            return false;
        int sum = 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
}
