// Imagine a system that can "speak" numbers. Your task is to build this system for the range of zero to nine hundred and ninety-nine. 
// Given an integer within this scope, the system should articulate its value in standard English words.
// If a number falls outside this speaking range, the system should indicate its inability to translate.

// Input:
// ------
// A single integer num such that 0 <= num < 1000.

// Output:
// -------
// A string representing the English words for the number.

// If the number is not in range, output: "Out of range"

// Example 1:
// -------
// Input:
// 219

// Output:
// Two Hundred and Nineteen

// Example 2:
// -----------
// Input:
// 1001

// Output:
// Out of range

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(convertNum(num));
    }

    private static String convertNum(int num) {
        if (num < 0 || num >= 100) {
            return "Out of range";
        }

        Map<Integer, String> mp1 = new HashMap<>();
        Map<Integer, String> mp2 = new HashMap<>();

        mp1.put(0, "Zero");
        mp1.put(1, "One");
        mp1.put(2, "Two");
        mp1.put(3, "Three");
        mp1.put(4, "Four");
        mp1.put(5, "Five");
        mp1.put(6, "Six");
        mp1.put(7, "Seven");
        mp1.put(8, "Eight");
        mp1.put(9, "Nine");
        mp1.put(10, "Ten");
        mp1.put(11, "Eleven");
        mp1.put(12, "Twelve");
        mp1.put(13, "Thirteen");
        mp1.put(14, "Fourteen");
        mp1.put(15, "Fifteen");
        mp1.put(16, "Sixteen");
        mp1.put(17, "Seventeen");
        mp1.put(18, "Eighteen");
        mp1.put(19, "Nineteen");

        mp2.put(2, "Twenty");
        mp2.put(3, "Thirty");
        mp2.put(4, "Forty");
        mp2.put(5, "Fifty");
        mp2.put(6, "Sixty");
        mp2.put(7, "Seventy");
        mp2.put(8, "Eighty");
        mp2.put(9, "Ninety");

        if (num < 20) {
            return mp1.get(num);
        } else {
            int ten = num / 10;
            int one = num % 10;
            if (one == 0) {
                return mp2.get(ten);
            } else {
                return mp2.get(ten) + " " + mp1.get(one);
            }
        }
    }
}
