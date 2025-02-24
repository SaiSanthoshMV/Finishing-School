public class BitwiseEvenOdd {
    public static void main(String[] args) {
        int num = 5; // Change the value to test
        if ((num & 1) == 0)
            System.out.println(num + " is Even");
        else
            System.out.println(num + " is Odd");
    }
}


//A number is even if the least significant bit (LSB) is 0 and odd if it is 1. You can use n & 1 to check this.