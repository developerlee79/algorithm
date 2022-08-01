package tree;

public class leetcode_112 {
    public static void main(String[] args) {
        leetcode_112 leetcode = new leetcode_112();
        TreeNode rootNode = new TreeNode(1, null, new TreeNode(2));
        int target = 1;
        System.out.println(leetcode.hasPathSum(rootNode, target));
    }

    /**
     * @param root binary tree
     * @param targetSum Target sum of root-to-leaf in binary tree
     * @return Presence of a path that becomes targetSum when all values are added along the root-to-leaf path
     *
     * Solution - DFS
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Search the tree by Depth-First Search.
     * At this problem, we only have to calculate at "leaf node" - which childless node.
     * Therefore, search until the node has no children and calculate targetSum.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        else if (root.left == null && root.right == null)
            return targetSum == root.val;
        else
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
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
    }
}
