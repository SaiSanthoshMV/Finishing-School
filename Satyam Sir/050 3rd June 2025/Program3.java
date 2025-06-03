// Given an integer N, write a program that returns true if the given number is a palindrome,
// else return false. Assume N > 99 and can be of any number of digits...


import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long rev = revNum(n);
        // System.out.println(rev);
        System.out.println(n == rev);
    }
    private static long revNum(long n) {
        long revNum = 0;
        while (n > 0) {
            long temp = n % 10;
            revNum = revNum * 10 + temp;
            n /= 10;
        }
        return revNum;
    }
}