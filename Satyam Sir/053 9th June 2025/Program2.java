// In a distant galaxy,an ancient civilization built a hierarchical communication network of interconnected relay stations.The structure of this network can be reconstructed using two ancient data logs:

// Beacon Activation Order(analogous to in-order traversal)Final Signal Sent Order(analogous to post-order traversal)Using these logs,we can reconstruct the original relay network and process queries about signals reaching specific hierarchical levels.

// Given the Beacon Activation Order and the Final Signal Sent Order of a galactic communication network,reconstruct the relay network.After reconstructing the hierarchy,and the output should list the relay stations in the order they appear in a level-wise transmission sequence.

// Input Format:-------------An integer N representing the number of relay stations in the network.A space-separated list of N integers representing the Beacon Activation Order(similar to in-order traversal).A space-separated list of N integers representing the Final Signal Sent Order(similar to post-order traversal).

// Output Format:--------------For each query,print the relay stations in order of their signal transmissions within the given depth range

// Sample Input:-------------7 4 2 5 1 6 3 7 4 5 2 6 7 3 1 Sample Output:---------------[1,2,3,4,5,6,7]

// Explanation:The logs correspond to the following hierarchical relay network:1/\2 3/\/\4 5 6 7 The level order is:1 2 3 4 5 6 7 
import java.util.*;

class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Program2 {
    private static Node buildTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd,
            Map<Integer, Integer> mp) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postOrder[postEnd];
        Node root = new Node(rootVal);
        int inRootInd = mp.get(rootVal);
        int leftSize = inRootInd - inStart;
        root.left = buildTree(inOrder, postOrder, inStart, inRootInd - 1, postStart, postStart + leftSize - 1, mp);
        root.right = buildTree(inOrder, postOrder, inRootInd + 1, inEnd, postStart + leftSize, postEnd - 1, mp);

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
        int[] postOrder = new int[n];
        for (int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            postOrder[i] = sc.nextInt();
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(inOrder[i], i);
        }
        Node root = buildTree(inOrder, postOrder, 0, n - 1, 0, n - 1, mp);
        List<Integer> res = levelOrd(root);
        System.out.println(res);
    }
}