import java.util.*;

class sort {
  public static void main(String args[]) {
    List list1 = new ArrayList();   // Test with List <Integer>
    list1.add(45);
    list1.add(21);
    Collections.sort(list1);
    System.out.println(list1);
  }
}























/*
Collections.sort() uses Timsort, which is a hybrid of Merge Sort and Insertion Sort.
Introduced in Java 7, it is an optimized sorting algorithm for real-world data.
Time Complexity:
Best Case	O(n) (if already sorted)
Average Case	O(n log n)
Worst Case	O(n log n)
*/





