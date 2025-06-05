// Write a function stringy that takes a size and returns a string of alternating '1 s' and 'Os'.
//    the string should start with a 1. 
//    a string with size 6 should return :101010'.
//    with size 4 should return : '1010'.
//    with size 12 should return : 101010101010'.
//    The size will always be positive and will only use whole numbers.
import java.util.*;
public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                res.append("1");
            else
                res.append("0");
        }
        System.out.println(res.toString());
    }
}
