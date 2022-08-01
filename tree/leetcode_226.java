package tree;

public class leetcode_226 {
    public static void main(String[] args) {
        leetcode_226 leetcode = new leetcode_226();
        TreeNode node = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(leetcode.invertTree(node).toString());
    }

    /**
     * @param root Tree needs to be reverted
     * @return Reverted tree
     *
     * Solution - Recursive (Bottom - Up)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Recursively swap the left and right nodes of the tree.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swap(root, invertTree(root.left), invertTree(root.right));
        return root;
    }

    private void swap(TreeNode node, TreeNode leftNode, TreeNode rightNode) {
        node.left = rightNode;
        node.right = leftNode;
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
