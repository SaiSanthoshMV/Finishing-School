// Write a program to print a square with "*"s for a given length of the side of the square.


// Example:

// input:
// -----
// 3

// output:
// ------
// * * *
// * * *
// * * *
import java.util.*;

public class Program9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print('*' + " ");
            }
            System.out.println(" ");
        }
    }
}
