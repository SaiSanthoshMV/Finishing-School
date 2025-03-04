// Given an expression in string format print the value of the expression after evaluating

// Rules for Evaluation:The expression is Evaluated from Left to Right and operators allowed are only+,-,/,*Ignore Operator Precedence and evaluate the expression from left to right Assume the expression only consists of numbers(0-9)(both postive and negative)and operators(+,-,*,/)

// Test Case-1 input=2+3*6 output=30

// Explanation:-The sum of 2+3 is 5 and 5*6=30

// Test Case-2 input=5+7-9+0*0+1 output=1

// Explanation-The sum of 5+7 is 12 12-9 is 3 and 3+0 is 3,3*0 is 0 and 0+1 is 1

// Test Case-3 input=-1+-1*2 output=-4

// Explanation- -1+-1 is-2 and-2*2 is-4

import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int i = 0;
        int res = 0;
        int num = 0, sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i++) - '0');
        }
        res = sign * num;
        while (i < n) {
            char op = s.charAt(i++);
            num = 0;
            sign = 1;
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            }
            while (i < n && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i++) - '0');
            }
            if (op == '+')
                res += sign * num;
            else if (op == '-')
                res -= sign * num;
            else if (op == '*')
                res *= sign * num;
            else if (op == '/')
                res /= sign * num;
        }
        System.out.println(res);
    }
}
