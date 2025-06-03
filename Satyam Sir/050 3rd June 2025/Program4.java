// Implement strStr()not using the standard strStr function.Return the index of the first occurrence of str1 and str2,or-1 if str1 is not part of str2.(Eg:if s1="one",and s2="tone",strStr(s1,s2)should return 1)

// example input=llo hello output=2
import java.util.*;

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(strStr(s1, s2));
    }

    private static int strStr(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();
        if (m > n) {
            return -1;
        }
        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (s1.charAt(j) != s2.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}