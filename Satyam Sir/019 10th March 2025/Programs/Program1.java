// Malika taught a new fun time program practice for Engineering Students.
// As a part of this she has given set of N numbers, and asked the students 
// to perform the operations listed below:
// 1. sumRange(start, end) - return the sum of numbers between the indices start and end, both are inclusive.
// 2. update(ind, val) - update the value at the index 'ind' to 'val'.

// Your task is to solve this problem using Segment Tree concept.

// Input Format:
// -------------
// Line-1: Two integers N and Q, size of the array(set of numbers) and query count.
// Line-2: N space separated integers.
// next Q lines: Three integers option, start/ind and end/val.

// Output Format:
// --------------
// An integer result, for every sumRange query.


// Sample Input:
// -------------
// 8 5
// 4 2 13 4 25 16 17 8
// 1 2 6		//sumRange
// 1 0 7		//sumRange
// 2 2 18	//update
// 2 4 17	//update
// 1 2 7		//sumRange

// 8 5
// 4 2 13 4 25 16 17 8
// 1 2 6		
// 1 0 7		
// 2 2 18	
// 2 4 17	
// 1 2 7	

// Sample Output:
// --------------
// 75
// 89
// 80

import java.util.*;

class SegmentTreeNode {
    int start;
    int end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}

class SegmentTree {
    SegmentTreeNode root = null;

    public SegmentTree(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        else {
            SegmentTreeNode nn = new SegmentTreeNode(start, end);
            if (start == end)
                nn.sum = nums[start];
            else {
                int mid = start + (end - start) / 2;
                nn.left = buildTree(nums, start, mid);
                nn.right = buildTree(nums, mid + 1, end);
                nn.sum = nn.left.sum + nn.right.sum;
            }
            return nn;
        }
    }

    public void update(int i, int value) {
        update(root, i, value);
    }

    private void update(SegmentTreeNode root, int pos, int value) {
        if (root.start == root.end)
            root.sum = value;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid)
                update(root.left, pos, value);
            else
                update(root.right, pos, value);
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == start && root.start == end)
            return root.sum;
        else if (root.start == root.end)
            return root.sum;
        else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid)
                return sumRange(root.left, start, end);
            else if (start > mid)
                return sumRange(root.right, start, end);
            else
                return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
    }
}

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        SegmentTree root = new SegmentTree(arr);
        for (int i = 0; i < q; i++) {
            int option = sc.nextInt();
            if (option == 1) {
                int st = sc.nextInt();
                int en = sc.nextInt();
                System.out.println(root.sumRange(st, en));
            } else if (option == 2) {
                int pos = sc.nextInt();
                int val = sc.nextInt();
                root.update(pos, val);
            }
        }
    }
}