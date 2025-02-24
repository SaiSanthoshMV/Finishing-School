import java.util.Scanner;
 
public class BitwiseOperators {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
     
        int num1 =5;         // 0 1 0 1 --> 1 0 1 0 + 1 = 1 0 1 1
        int num2 = 10;       // 1 0 1 0
 
        System.out.println("Bitwise AND: " + (num1 & num2)); //0
        System.out.println("Bitwise OR: " + (num1 | num2));  //15
        System.out.println("Bitwise XOR: " + (num1 ^ num2)); //15
        System.out.println("Bitwise NOT: " + (~num1));       //-3
        System.out.println("Bitwise Left Shift: " + (num1 << 2));   
		//1010  ==> 001010 ==> 010100==>10100 final value==
		System.out.println("Bitwise Right Shift: " + (num1 >> 2));
		//0101==>
        System.out.println("Bitwise Unsigned Right Shift: " + (num1 >>> 2));
 
        
    }
}



















/* Unsigned Right Shift Operator in Java  >>>

Unsigned Right Shift Operator moves the bits of the integer a given number of places to the right. 
The sign bit was filled with 0s. 
The Bitwise Zero Fill Right Shift Operator is represented by the symbol >>>. */




          
      