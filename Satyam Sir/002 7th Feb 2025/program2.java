import java.util.*;

public class program2 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    List<String> res = new ArrayList<>();
    StringBuilder sb=new StringBuilder(str);for(
    int i = 1;i<sb.length();i++)
    {
        if (sb.charAt(i) == sb.charAt(i - 1) && sb.charAt(i) == '+') {
            sb.setCharAt(i, '-');
            sb.setCharAt(i - 1, '-');
            res.add(sb.toString());
            sb.setCharAt(i, '+');
            sb.setCharAt(i - 1, '+');
        }
    }
    System.out.println(res);
}
}
