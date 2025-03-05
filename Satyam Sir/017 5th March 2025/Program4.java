// Calendar Dates 

// Ramu is playing with the dates of the calender, for his surprise he flag few dates to be similar in both from left to right
// and right to left.
// He is now intrested to know all such dates in the calender. Help ramu in this.
// IF NO PALINDROMIC DATES PRINT -1.


// input = 2020
// output = 02-02-2020


// input = 2010
// output = 01-02-2010
import java.util.*;
import java.time.*;

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        boolean flag = false;
        LocalDate st = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        while (!st.isAfter(end)) {
            String date = String.format("%02d-%02d-%d", st.getDayOfMonth(), st.getMonthValue(), st.getYear());
            String str = date.replace("-", "");
            if (isPalindrome(str)) {
                System.out.println(date);
                flag = true;
            }
            st = st.plusDays(1);
        }
        if (!flag) {
            System.out.println("-1");
        }
    }
    public static boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}
