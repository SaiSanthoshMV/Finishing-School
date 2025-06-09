// You are given some tokens printed with unique numbers on it and an integer T.
// Your task is to find the least number of tokens that you need to make up the 
// value T, by adding the numbers printed on all the tokens. 
// If you cannot make the value T, by any combination of the tokens, return -1.

// NOTE: Assume that you have unlimited set of tokens of each number type.

// Input Format:
// -------------
// Line-1: Space separated integers tokens[], number printed on tokens.
// Line-2: An integer T.

// Output Format:
// --------------
// Print an integer, minimum number of tokens to make the value T.


// Sample Input-1:
// ---------------
// 1 2 5
// 11

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// 5+5+1 = 11


// Sample Input-2:
// ---------------
// 2 4
// 15

// Sample Output-2:
// ----------------
// -1
import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ip = sc.nextLine().split(" ");
        int[] arr = new int[ip.length];
        for (int i = 0; i < ip.length; i++) {
            arr[i] = Integer.parseInt(ip[i]);
        }
        int T = sc.nextInt();
        System.out.println(minTokens(arr, arr.length, T));
    }

    private static int minTokens(int[] arr, int n, int T) {
        List<Integer> res = new ArrayList<>();
        backtrack(arr, n, T, 0, res);
        // res.sort(null);
        return res.size() > 0 ? Collections.min(res) : -1;
    }

    private static void backtrack(int[] arr, int n, int T, int cnt, List<Integer> res) {
        if (T == 0) {
            res.add(cnt);
            return;
        }
        if (T < 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            T -= arr[i];
            backtrack(arr, n, T, cnt + 1, res);
            T += arr[i];
        }
    }
}
