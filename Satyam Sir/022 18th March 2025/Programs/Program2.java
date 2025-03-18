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

// import java.util.*;

// public class Program2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         List<Integer> arr = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             arr.add(sc.nextInt());
//         }
//         int k = sc.nextInt();
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         pq.addAll(arr);
//         while (k > 1 && !pq.isEmpty()) {
//             pq.poll();
//             k--;
//         }
//         if (!pq.isEmpty()) {
//             System.out.println(pq.peek());
//         }
//     }

// }

import java.util.Random;
import java.util.Scanner;

class TreapNode {
    int key, priority, size;
    TreapNode left, right;

    public TreapNode(int key) {
        this.key = key;
        this.priority = new Random().nextInt();
        this.size = 1;
        this.left = this.right = null;
    }
}

class Treap {
    private TreapNode root;

    // Get size of a node
    private int getSize(TreapNode node) {
        return node == null ? 0 : node.size;
    }

    // Update size after modification
    private void updateSize(TreapNode node) {
        if (node != null) {
            node.size = 1 + getSize(node.left) + getSize(node.right);
        }
    }

    // Right Rotate
    private TreapNode rightRotate(TreapNode y) {
        TreapNode x = y.left;
        TreapNode T2 = x.right;
        x.right = y;
        y.left = T2;
        updateSize(y);
        updateSize(x);
        return x;
    }

    // Left Rotate
    private TreapNode leftRotate(TreapNode x) {
        TreapNode y = x.right;
        TreapNode T2 = y.left;
        y.left = x;
        x.right = T2;
        updateSize(x);
        updateSize(y);
        return y;
    }

    // Insert a key into the Treap
    private TreapNode insert(TreapNode node, int key) {
        if (node == null)
            return new TreapNode(key);

        if (key <= node.key) {
            node.left = insert(node.left, key);
            if (node.left.priority > node.priority)
                node = rightRotate(node);
        } else {
            node.right = insert(node.right, key);
            if (node.right.priority > node.priority)
                node = leftRotate(node);
        }

        updateSize(node);
        return node;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    // Find the k-th largest element
    private int findKthLargest(TreapNode node, int k) {
        int rightSize = getSize(node.right);

        if (rightSize + 1 == k) {
            return node.key;
        } else if (rightSize + 1 < k) {
            return findKthLargest(node.left, k - rightSize - 1);
        } else {
            return findKthLargest(node.right, k);
        }
    }

    public int findKthLargest(int k) {
        if (root == null || k > root.size) {
            return -1;
        }
        return findKthLargest(root, k);
    }
}

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        Treap treap = new Treap();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int k = sc.nextInt();

        System.out.println(treap.findKthLargest(k));
    }
}
