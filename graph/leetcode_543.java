package graph;

public class leetcode_543 {

    class TreeNode {
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

    public int diameterOfBinaryTree(TreeNode root) {
        return DFS(root)[0];
    }

    private int[] DFS(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = DFS(node.left);
        int[] right = DFS(node.right);

        int best = Math.max(left[1] + right[1], Math.max(left[0], right[0]));
        int height = 1 + Math.max(left[1], right[1]);
        return new int[]{best, height};
    }
}
