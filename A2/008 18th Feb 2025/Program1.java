// Magic Reflections: In a mystical world, a spell can concatenate the essence of two magical artifacts represented as sequences of integers. 
// Once combined, the new sequence may reflect ancient symmetrical magic if it appears the same from both ends. 
// As a novice wizard,your task is to determine if the resulting sequence from combining two artifacts holds this reflective, symmetrical property.


// Test Case 1:
// Input = 1 4 9
// 9 4 1
// output true 

// Test Case 2:
// Input = 1 2 3
// 3 2 4 
// output false


import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        String[] str3 = new String[str1.length + str2.length];
        System.arraycopy(str1, 0, str3, 0, str1.length);
        System.arraycopy(str2, 0, str3, str1.length, str2.length);
        // System.out.println(Arrays.toString(str3));
        System.out.println(checkSymmetric(str3));
    }

    private static boolean checkSymmetric(String[] str) {
        int left = 0, right = str.length - 1;
        while (left < right) {
            if (!str[left].equals(str[right]))
                return false;
            left++;
            right--;
        }
        return true;
    }
}