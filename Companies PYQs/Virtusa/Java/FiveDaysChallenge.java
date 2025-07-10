/*
10. 5 DAYS CHALLENGE


Alice is undertaking a 5-day challenge to read N books , each book containing A pages . 
Alice must complete the books by disturbing the pages as evenly as possible .
Your task is to find and return an integer value representing the minimum number 
of pages she must read in a day to finish all the books in exactly 5 days.


input specification:
--------------------

input1: An integer value N, representing the number of books.

input2: An integer array A, representing the number of pages in each book.

Output specification:
--------------------

Return an integer value representing the minimum number of pages she must read in a day to finish all the books
in exactly 5 days.

Example 1:
----------

input 1: 5
input 2: (4,10,20,30,40)

output: 20


Explanation:
------------

Here, the given array is (4,10,20,30,40) so Alice must read the pages in the given manner.

	->The first way : (1,1,1,1,100),where Alice reads 1 page each for the first 4 days and 100 pages on the 
	last day . so the minimum number of pages read in a day is 1.
	
	-> The optimal way: Since we have to evenly distribute the pages so the distribution can be (20,21,22,21,20) , 
	where the number of pages read by Alice in 5 days are 20,21,22,21 and 20, respectively ,
	so the minimum number of pages read in a day is 20.
	
Therefore, 20 is  returned as the output.


Example 2:
----------

input1: 5
input2: (1,1,1,1,1)

output:1

Explanation:
------------
Here, the given array is (1,1,1,1,1) so Alice must read the books in the given manner.

-> There is only one way to read the books read the books: read 1 page everyday (1,1,1,1,1) so the minimum number 
of pages read in a day is 1.

Therefore, 1 is returned as the output.

*/
public class FiveDaysChallenge {

    // Helper: Check if all books can be read in 5 days with maxPagesPerDay
    public static boolean canDistribute(int[] A, int maxPages) {
        int days = 1;
        int currentSum = 0;

        for (int pages : A) {
            if (pages > maxPages) return false; // Single book exceeds limit

            if (currentSum + pages <= maxPages) {
                currentSum += pages;
            } else {
                days++;
                currentSum = pages;
            }

            if (days > 5) return false;
        }

        return true;
    }

    public static int minPagesPerDay(int N, int[] A) {
        int low = 0;
        int high = 0;

        for (int pages : A) {
            high += pages;
            low = Math.max(low, pages); // At least one day must be able to read the largest book
        }

        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canDistribute(A, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(minPagesPerDay(5, new int[]{4, 10, 20, 30, 40}));  // Output: 20
        System.out.println(minPagesPerDay(5, new int[]{1, 1, 1, 1, 1}));      // Output: 1
    }
}
