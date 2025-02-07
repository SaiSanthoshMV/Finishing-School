// Write a program to construct a binary tree from level-order input, while treating -1 
// as a placeholder for missing nodes. The program reads input, constructs the tree, 
// and provides an in-order traversal to verify correctness.

// Input Format:
// ---------------
// Space separated integers, level order data (where -1 indiactes null node).

// Output Format:
// -----------------
// Print the in-order data of the tree.

// Sample Input:
// ----------------
// 1 2 3 -1 -1 4 5

// Sample Output:
// ----------------
// 2 1 4 3 5

// Explanation:
// --------------
//     1
//   / \
//   2   3
//      / \
//     4   5

// Sample Input:
// ----------------
// 1 2 3 4 5 6 7

// Sample Output:
// ----------------
// 4 2 5 1 6 3 7

// Explanation:
// --------------
//         1
//       / \
//       2   3
//      / \  / \
//     4  5 6  7

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node() {
        left = null;
        right = null;
    }

    Node(int v) {
        data = v;
        left = null;
        right = null;
    }
}

public class problem5 {
    static void insert(Node root, int val) {
        LinkedList<Node> ll = new LinkedList<>();
        ll.add(root);
        while (!ll.isEmpty()) {
            int n = ll.size();
            for (int i = 0; i < n; i++) {
                Node t = ll.poll();
                if (t.data == -1)
                    continue;
                if (t.left != null) {
                    ll.add(t.left);
                } else {
                    // if(val==-1){
                    // }
                    Node s = new Node(val);
                    t.left = s;
                    return;
                }
                if (t.right != null) {
                    ll.add(t.right);
                } else {
                    // if(val==-1){
                    // t.left=null;
                    // }
                    Node s = new Node(val);
                    t.right = s;
                    return;
                }
            }
        }
    }

    static void inorder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        if (root.data != -1)
            ans.add(root.data);
        inorder(root.right, ans);
    }

    static void lvl(Node root, ArrayList<Integer> ans) {
        LinkedList<Node> ll = new LinkedList<>();
        ll.add(root);
        while (!ll.isEmpty()) {
            int n = ll.size();
            for (int i = 0; i < n; i++) {
                Node t = ll.poll();
                ans.add(t.data);
                if (t.left != null) {
                    ll.add(t.left);
                }
                if (t.right != null) {
                    ll.add(t.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        int arr[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Node root = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            insert(root, arr[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        // lvl(root,ans);
        for (int i : ans)
            System.out.print(i + " ");
        sc.close();
    }
}

// Sample Input:
// ----------------
// 1 2 3 -1 -1 4 5

// Sample Output:
// ----------------
// 2 1 4 3 5