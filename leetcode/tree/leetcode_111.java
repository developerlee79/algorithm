package leetcode.tree;

public class leetcode_111 {
    public static void main(String[] args) {
        leetcode_111 leetcode = new leetcode_111();
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(leetcode.minDepth(treeNode));
    }

    // Solution - DFS
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Post-order traversal
    // If node have both child - complete node - then compare the depth of the two nodes.
    // If only one child node is missing, search the other child node. (To exclude empty nodes)
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static class TreeNode {
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
