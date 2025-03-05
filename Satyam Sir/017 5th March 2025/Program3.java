// Shankuntala a maths student a given a set of N numbers,and was asked to to perform the operations listed below:

// 1. sumRange(start,end)-return the sum of numbers between the indices start and end,both are inclusive.2. update(ind,val)-update the value at the index'ind'to'val'.

// Your task is to solve this problem using Fenwick Tree concept.

// Input Format:-------------Line-1:Two integers N and Q,size of the array(set of numbers)and query count.Line-2:N space separated integers.next Q lines:Three integers option,start/ind and end/val.

// Output Format:--------------An integer result,for every sumRange query.

// Sample Input-1:---------------8 5 
// 1 2 13 4 25 16 17 8 
// 1 2 6 //sumRange
// 1 0 7 //sumRange
// 2 2 18 //update
// 2 4 17 //update
// 1 2 7 //sumRange

// Sample Output-1:----------------75 86 80

// Sample Input-2:---------------8 5 
// 1 2 13 4 25 16 17 8 
// 1 2 6 
// 1 0 7 
// 2 2 18 
// 2 4 17 
// 1 0 7

// Sample Output-2:----------------75 86 83
import java.util.*;

class FenwickTree {
    int[] tree;
    int n;

    public FenwickTree(int n) {
        this.n = n;
        this.tree = new int[n + 1];
    }

    public void init(int i, int val) {
        i++;
        while (i <= n) {
            tree[i] += val;
            i += i & (-i);
        }
    }

    public void update(int index, int val, int[] arr) {
        int diff = val - arr[index];
        arr[index] = val;
        init(index, diff);
    }

    public long getSum(int index) {
        long sum = 0;
        index++;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }

    public long sumRange(int start, int end) {
        return getSum(end) - getSum(start - 1);
    }

    public void build(int[] arr) {
        for (int i = 0; i < n; i++) {
            init(i, arr[i]);
        }
    }
}

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        FenwickTree ft = new FenwickTree(n);
        ft.build(arr);
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int opt = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (opt == 1) {
                res.add(ft.sumRange(start, end));
            } else if (opt == 2) {
                ft.update(start, end, arr);
            }
        }
        System.out.println(res);
    }
}
