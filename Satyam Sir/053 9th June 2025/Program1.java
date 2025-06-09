// In a distant future, humanity has begun interstellar colonization, establishing zones of habitation and control on a new planet. 
// Scientists have recorded two types of data regarding how these zones were structured:

// 1. Survey Order (analogous to pre-order traversal) – This record details how the colonization started, with the first zone established and
// then expanding into new zones following a systematic approach.
// 2. Planetary Layout (analogous to in-order traversal) – This document shows how zones were positioned relative to each other on the map,
// based on territorial boundaries.

// Using this information, scientists need to reconstruct the colonization hierarchy (binary tree of zones) and display them level wise.

// Input Format:
// --------------
// An integer N representing the number of zones colonized.
// A space-separated list of N integers representing the Planetary Layout Order (in-order).
// A space-separated list of N integers representing the Survey Order ( pre-order ).

// Output Format:
// ---------------
// Print all zone IDs in level order:

// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 1 2 4 5 3 6 7

// Sample Output:
// ---------------
// 1 2 3 4 5 6 7

// Explanation:
// The given Planetary Layout (in-order) and Survey Order (pre-order) correspond to the following colonization hierarchy:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7

// Level Order: [1, 2, 3, 4, 5, 6, 7]

import java.util.*;

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Program1 {
    private static Node buildTree(int[] inOrder, int[] preOrder, int inStart, int inEnd, int preStart, int preEnd, Map<Integer, Integer> mp) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        int rootVal = preOrder[preStart];
        Node root = new Node(rootVal);
        int inRootInd = mp.get(rootVal);
        int leftSize = inRootInd - inStart;
        root.left = buildTree(inOrder, preOrder, inStart, inRootInd - 1, preStart + 1, preStart + leftSize, mp);
        root.right = buildTree(inOrder, preOrder, inRootInd + 1, inEnd, preStart + leftSize + 1, preEnd, mp);
        return root;
    }

    private static List<Integer> levelOrd(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            res.add(curr.data);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inOrder = new int[n];
        int[] preOrder = new int[n];
        for (int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            preOrder[i] = sc.nextInt();
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
           mp.put(inOrder[i], i);
        }
        Node root = buildTree(inOrder, preOrder, 0, n - 1, 0, n - 1, mp);
        List<Integer> res = levelOrd(root);
        System.out.println(res);
    }
}