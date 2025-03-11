// Ram a english student wants to help a programmer to write the property names in the correct form of mutators and accessors. 
// Help Ram to do so.

// input = name
// size
// mutators
// mutators
// output =
// setName(datatype name)
// setSize(datatype size)


// input = marks
// age
// mutators
// accessor
// output = 
// setMarks(datatype marks)
// datatype getAge()


// Help Ram to write the necessary Java code to print the output as shown above.
// Assume only 2 properties followed by 2 mutators/accessors

import java.util.*;

public class Program4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = sc.next();
        String s4 = sc.next();

        if (s3.equals("mutators")) {
            System.out.println("set" + s1.substring(0, 1).toUpperCase() + s1.substring(1) + "(datatype " + s1 + ")");
        } else if (s3.equals("accessor")) {
            System.out.println("datatype get" + s1.substring(0, 1).toUpperCase() + s1.substring(1) + "()");
        }

        if (s4.equals("mutators")) {
            System.out.println("set" + s2.substring(0, 1).toUpperCase() + s2.substring(1) + "(datatype " + s2 + ")");
        } else if (s4.equals("accessor")) {
            System.out.println("datatype get" + s2.substring(0, 1).toUpperCase() + s2.substring(1) + "()");
        }

    }
}
