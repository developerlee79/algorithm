package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1302 {
    public static void main(String[] args) {
        leetcode_1302 leetcode = new leetcode_1302();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
        System.out.println(leetcode.deepestLeavesSum(root));
    }

    /**
     * @param root Binary Tree
     * @return Deepest leaves of binary tree
     *
     * Solution - BFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Classic BFS problem.
     * Search the binary tree by Breadth-First Search.
     * Initialize node size & result in every loop.
     */
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();

        int result = 0, i;

        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            for (i = nodeQueue.size() - 1, result = 0; i >= 0; i--) {
                TreeNode node = nodeQueue.poll();
                result += node.val;

                if (node.right != null)
                    nodeQueue.add(node.right);

                if (node.left != null)
                    nodeQueue.add(node.left);
            }
        }

        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
