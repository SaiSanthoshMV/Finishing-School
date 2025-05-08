// In a joint family, every person assigned with an ID, an integer value.
// and the entire family is arranged in the from of tree.

// You will be given the family tree and two persons IDs P1 and P2.
// Your task is to find the person ID, who is the latest common ascendant of P1 and P2.
// and return the Lowest Common Ascendant ID.

// Implement the class Solution:
// - Node lowestCommonAscendant(Node root, Node P1, Node P2):
// return the person ID who is the latest common ascendant of P1 and P2.

// Input Format:

// Line-1: Single line of space separated integers, person ID's in the family.
// Line-2: Two Person IDs, P1 and P2.

// Output Format:

// Return the latest common ascendant of P1 and P2.

// Sample Input-1:

// 3 5 1 6 2 0 8 -1 -1 7 4
// 6 4

// Sample Output-1:

// 5

// Sample Input-2:

// 11 99 88 77 22 33 66 55 10 20 30 40 50 60 44
// 66 55

// Sample Output-2:

// 11

import java.util.*;

class Node {
    int id;
    Node left, right;

    Node(int id) {
        this.id = id;
        this.left = null;
        this.right = null;
    }
}

class Main {
    public Node lowestCommonAscendant(Node root, Node P1, Node P2) {
        if (root == null || root == P1 || root == P2)
            return root;
        Node left = lowestCommonAscendant(root.left, P1, P2);
        Node right = lowestCommonAscendant(root.right, P1, P2);
        if (left != null && right != null)
            return root;
        return (left != null) ? left : right;
    }

    public Node buildTree(List<Integer> values) {
        if (values == null || values.size() == 0)
            return null;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(values.get(0));
        queue.offer(root);
        int i = 1;
        while (i < values.size()) {
            Node current = queue.poll();
            if (i < values.size() && values.get(i) != -1) {
                current.left = new Node(values.get(i));
                queue.offer(current.left);
            }
            i++;
            if (i < values.size() && values.get(i) != -1) {
                current.right = new Node(values.get(i));
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public Node findNode(Node root, int id) {
        if (root == null)
            return null;
        if (root.id == id)
            return root;
        Node left = findNode(root.left, id);
        if (left != null)
            return left;
        return findNode(root.right, id);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int P1 = sc.nextInt();
        int P2 = sc.nextInt();
        List<Integer> values = new ArrayList<>();
        for (String val : line1) {
            values.add(Integer.parseInt(val));
        }
        Main sol = new Main();
        Node root = sol.buildTree(values);
        Node node1 = sol.findNode(root, P1);
        Node node2 = sol.findNode(root, P2);
        Node lca = sol.lowestCommonAscendant(root, node1, node2);
        System.out.println(lca.id);
    }

}