// Write a function that will retum the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string.The input string can be assumed to contain only alphabets(both uppercase and lowercase)and numeric digits.

// example input=aA112 output=2
import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch >= 65 && ch <= 90) {
                sb.append((char) (ch + 32));
            } else {
                sb.append(ch);
            }
        }
        int cnt = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : sb.toString().toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> m : mp.entrySet()) {
            if (m.getValue() > 1)
                cnt++;
        }
        System.out.println(cnt);
    }
}
