package tree;

public class leetcode_110 {

    // Time Complexity : O(N)
    // Depth First Search
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    // the depth of tree is always >= 0
    // so use -1 as flag to check balance of tree
    static int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left), right = dfs(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public class TreeNode {
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
    }
}
