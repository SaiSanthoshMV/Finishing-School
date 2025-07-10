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

#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>
using namespace std;

bool isFeasible(vector<int>& A, int maxPages, int days) {
    int dayCount = 1, currentSum = 0;
    for (int pages : A) {
        if (currentSum + pages > maxPages) {
            dayCount++;
            currentSum = pages;
            if (dayCount > days) return false;
        } else {
            currentSum += pages;
        }
    }
    return true;
}

int minPagesPerDay(int n, vector<int>& A) {
    int low = *max_element(A.begin(), A.end());    
    int high = accumulate(A.begin(), A.end(), 0);   

    int result = high;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (isFeasible(A, mid, 5)) {
            result = mid;       
            high = mid - 1;
        } else {
            low = mid + 1;       // Increase day capacity
        }
    }
    return result;
}

int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for (int i = 0; i < n; ++i) cin >> A[i];
    cout << minPagesPerDay(n, A) << endl;
    return 0;
}
