// Given an integer array nums and an integer k, return the kth largest element in the array.

// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// You must solve it in O(n) time complexity.

// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4

// Note: You are supposed to print the K'th largest height in the sorted order of heights[].
//  Not the K'th distinct height

import java.util.*;

class TreapNode {
    int key, priority, size;
    TreapNode left, right;

    public TreapNode(int key) {
        this.key = key;
        this.priority = (int) (Math.random() * 100);
        this.size = 1; 
        this.left = this.right = null;
    }
}

class test {
    private static int getSize(TreapNode node) {
        return (node == null) ? 0 : node.size;
    }

    private static void updateSize(TreapNode node) {
        if (node != null) {
            node.size = 1 + getSize(node.left) + getSize(node.right);
        }
    }

    public static TreapNode rightRotate(TreapNode y) {
        TreapNode x = y.left;
        TreapNode T2 = x.right;

        x.right = y;
        y.left = T2;

        updateSize(y);
        updateSize(x);

        return x;
    }

    public static TreapNode leftRotate(TreapNode x) {
        TreapNode y = x.right;
        TreapNode T2 = y.left;

        y.left = x;
        x.right = T2;

        updateSize(x);
        updateSize(y);

        return y;
    }

    public static TreapNode insertNode(TreapNode root, int key) {
        if (root == null) return new TreapNode(key);

        if (key <= root.key) {
            root.left = insertNode(root.left, key);
            if (root.left.priority > root.priority) {
                root = rightRotate(root);
            }
        } else {
            root.right = insertNode(root.right, key);
            if (root.right.priority > root.priority) {
                root = leftRotate(root);
            }
        }
        updateSize(root);
        return root;
    }

    public static int findKthLargest(TreapNode root, int k) {
        if (root == null) return -1;

        int rightSize = getSize(root.right);
        
        if (rightSize + 1 == k) return root.key; 
        if (rightSize >= k) return findKthLargest(root.right, k); 
        return findKthLargest(root.left, k - rightSize - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
        int nums[] = new int[n];
        
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        TreapNode root = null;
        for (int num : nums) {
            root = insertNode(root, num);
        }

        System.out.println(findKthLargest(root, k));
    }
}