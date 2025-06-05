// Given a number, find the sum of all the numbers less than that number and a multiple of either 3 or 5.. 
// If the number is multiple of both 3 and 5 then consider only once.


// example

// input=10 
// output=23  // sum of multiple's of 3 and 5 below 10 are 3+5+6+9

import java.util.*;

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
