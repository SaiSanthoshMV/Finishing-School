// Implement strStr()not using the standard strStr function.Return the index of the first occurrence of str1 and str2,or-1 if str1 is not part of str2.(Eg:if s1="one",and s2="tone",strStr(s1,s2)should return 1)

// example input=llo hello output=2
import java.util.*;

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int i = 0, j = 0;
        int cnt = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                System.out.println(cnt);
                System.exit(0);
            }
            cnt++;
            i++;
            j++;
        }
        System.out.println(-1);
    }
}