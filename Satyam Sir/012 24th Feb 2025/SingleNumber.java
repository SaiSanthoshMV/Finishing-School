
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 2};
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        System.out.println("Single Non-Repeating Number: " + result);
    }
}



//XOR of two same numbers is 0 (i.e., x ^ x = 0). 
//XOR all elements; the duplicate numbers cancel out, leaving the unique number.