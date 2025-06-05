// Write a program to sort an array of input numbers in ascending order and print.
// You have to use Bubble sort algorithm.

// (Hint: Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacentelements if they are in wrong order)
import java.util.*;
public class Program6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bubbleSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for(int j=0;j<n-i-1;j++){
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
