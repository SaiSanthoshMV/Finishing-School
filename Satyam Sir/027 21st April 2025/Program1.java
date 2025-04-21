// There are N people standing in a circle waiting to be executed.
// The counting out begins at point 'k' in the circle and proceeds around the circle in a fixed direction.

// In each step, a certain number of people are skipped and the next person is executed.

// The elimination proceeds around the circle (which is becoming smaller and smaller as
// the executed people are removed), until only the last person remains, who is given freedom.

// Given the total number of persons N and a number k which indicates that k-1 persons are
// skipped and the kth person is killed in a circle.

// The task is to choose the person in the initial circle that survives.

// Input Format:

// Line-1: Two integers, N and K

// Output Format:

// Line-1: An integer

// Sample Input-1:

// 5 2

// Sample Output-1:

// m

// Explanation:

// Firstly, the person at position 2 is killed,
// then the person at position 4 is killed, then the person at position 1 is killed.
// Finally, the person at position 5 is killed. So the person at position 3 survives.

// Sample Input-2:

// 7 3

// Sample Output-2:

// 4

import java.util .*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + k) % i;

            System.out.println(res + 1);
        }
    }
}