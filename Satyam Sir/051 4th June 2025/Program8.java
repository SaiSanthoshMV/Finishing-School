// Write a program that prints the next 20 leap years.

// Example:

// input
// -----
// 2019 //Starting year
// output
// ------
// 2020 2024 2028 2032 2036 2040 2044 2048 2052 2056 2060 2064 2068 2072 2076 2080 2084 2088 2092 2096

import java.util.*;

public class Program8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int count = 0;
        while (count < 20) {
            year++;
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.print(year+" ");
                count++;
            }
        }

    }    
}
