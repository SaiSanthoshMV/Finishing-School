Count the Number of Set Bits (1s) in an Integer



public class CountSetBits {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n &= (n - 1); // Removes the rightmost 1
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 9; // Binary: 1001 → Two 1s
        System.out.println("Number of set bits: " + countSetBits(num));
    }
}