package tree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_117 {
    public static void main(String[] args) {
        leetcode_117 leetcode = new leetcode_117();
        Node root = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null);
        System.out.println(leetcode.connect(root).toString());
    }

    /**
     * @param root Binary Tree which the next pointer should be connected
     * @return Connected Binary Tree
     *
     * Solution - BFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Search the binary tree by Breadth-First Search.
     * Follow the basic principle of BFS.
     * Iteration as many times as the current Queue size. it means the number of sibling nodes.
     * Poll the sibling nodes which stored in the queue one by one and connect them to the next node.
     * If polled node is the last node, point next as null.
     * Each iteration prepares the next iteration by inserting the child nodes of polled node.
     */
    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue<Node> connectQueue = new LinkedList<>();
        connectQueue.add(root);

        while (!connectQueue.isEmpty()) {
            int size = connectQueue.size();

            for (int i = 0; i < size; i++) {
                Node node = connectQueue.poll();
                node.next = (i < size - 1) ? connectQueue.peek() : null;

                if (node.left != null)
                    connectQueue.add(node.left);

                if (node.right != null)
                    connectQueue.add(node.right);
            }
        }

        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    ", next=" + next +
                    '}';
        }
    }
}
