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

    private static int cntDig(long n) {
        int cnt = 0;
        while (n > 0) {
            long temp = n % 10;
            cnt++;
            n = n / 10;
        }
        return cnt;
    }

    private static long revNum(long n) {
        int cnt = cntDig(n);
        long revNum = 0;
        while (cnt-- > 0) {
            long temp = n % 10;
            revNum = revNum + temp * (long) Math.pow(10, cnt);
            n = n / 10;
        }
        return revNum;
    }
}