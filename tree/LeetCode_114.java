package tree;

public class LeetCode_114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        new LeetCode_114().flatten(root);
        System.out.println(root);
    }

    private TreeNode prevNode = null;

    /**
     * Solution - DFS
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Recursively constructs a linked list by traversing the tree in the reverse direction of the pre-order traversal.
     *
     * @param root binary tree
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prevNode;
        prevNode = root;
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
