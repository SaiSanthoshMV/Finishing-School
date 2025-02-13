import java.util.*;
public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Character> mp = new LinkedHashMap<>();
        StringBuilder res = new StringBuilder();
        String alpha = sc.next();
        String code = sc.next();
        for (int i = 0; i < alpha.length(); i++) {
            String val = String.format("%02d", i + 1);
            mp.put(val, alpha.charAt(i));
        }
        // System.out.println(mp);
        for (int j = 0; j < code.length(); j += 2) {
            String c = code.substring(j, j + 2);
            res.append(mp.get(c));
        }
        System.out.println(res.toString());
    }
}