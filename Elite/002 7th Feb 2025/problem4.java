// You are developing an application for a garden management system where each tree 
// in the garden is represented as a binary tree structure. The system needs to 
// allow users to plant new trees in a systematic way, ensuring that each tree is 
// filled level by level.

// A gardener wants to:
//  - Plant trees based on user input.
//  - Ensure trees grow in a balanced way by filling nodes level by level.
//  - Inspect the garden layout by performing an in-order traversal, which helps 
//   analyze the natural arrangement of trees.

// Your task is to implement a program that:
//     - Accepts a list of N tree species (as integers).
//     - Builds a binary tree using level-order insertion.
//     - Displays the in-order traversal of the tree.

// Input Format:
// -------------
// - An integer N representing the number of tree plants.
// - A space-separated list of N integers representing tree species.

// Output Format:
// --------------
// A list of integers, in-order traversal of tree.

// Sample Input:
// -------------
// 7
// 1 2 3 4 5 6 7

// Sample Output:
// --------------
// 4 2 5 1 6 3 7

// Explanation:
// ------------
// The tree looks like this:

//         1
//       / \
//       2   3
//      / \  / \
//     4   5 6  7
// The in order is : 4 2 5 1 6 3 7

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

public class problem4 {
    static void insert(Node root, int val) {
        // if(root==null) {
        // // if(val==-1) root=null;
        // root.data=val;
        // return;
        // }
        LinkedList<Node> ll = new LinkedList<>();
        ll.add(root);
        while (!ll.isEmpty()) {
            int n = ll.size();
            for (int i = 0; i < n; i++) {
                Node t = ll.poll();
                if (t.left != null) {
                    ll.add(t.left);
                } else {
                    Node s = new Node(val);
                    t.left = s;
                    return;
                }
                if (t.right != null) {
                    ll.add(t.right);
                } else {
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
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Node root = new Node(arr[0]);
        for (int i = 1; i < n; i++) {
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