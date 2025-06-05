// Write a program to find the age of a person given his date of birth in dd-mm-yvyy
// format. (Eg: dob= 03-03-1976, current-date = 22-10-2021, => age = 45)

// Example:
// input=03-03-1976 //DOB
// 22-10-2021  // current-date
// output=
// 45 // Age

import java.util.*;

public class Program7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dob = sc.nextLine();
        String curr = sc.nextLine();
        String[] years = new String[2];
        years[0] = dob.substring(6, 10);
        years[1] = curr.substring(6, 10);
        if(dob.substring(3,5).equals(curr.substring(3,5))) {
            if(dob.substring(0,2).equals(curr.substring(0,2))) {
                System.out.println(Integer.parseInt(years[1]) - Integer.parseInt(years[0]));
            } else {
                System.out.println(Integer.parseInt(years[1]) - Integer.parseInt(years[0]) - 1);
            }
        } else if(Integer.parseInt(years[1]) > Integer.parseInt(years[0])) {
            System.out.println(Integer.parseInt(years[1]) - Integer.parseInt(years[0]));
        } else {
            System.out.println("Invalid Input");
        }
    }
}
