package medium;


/**
 * @author: godder
 * @date: 2019/2/25
 */

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersInEachNode_116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node current, pre = root;
        while (pre.left != null) {
            current = pre;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            pre = pre.left;
        }

        return root;
    }

    public static void main(String... args) {
        System.out.println(System.currentTimeMillis());
        PopulatingNextRightPointersInEachNode_116 solution = new PopulatingNextRightPointersInEachNode_116();

        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null, null),
                        new Node(5, null, null, null),
                        null),
                new Node(3,
                        new Node(6, null, null, null),
                        new Node(7, null, null, null),
                        null),
                null);
        Node result = solution.connect(root);
        System.out.println(result);
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + (left == null? "null" : left.val) +
                ", right=" + (right == null ? "null" : right.val) +
                ", next=" + (next == null ? "null" : next.val) +
                '}';
    }
};