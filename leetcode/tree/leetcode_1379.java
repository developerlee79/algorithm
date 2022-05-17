package leetcode.tree;

public class leetcode_1379 {
    public static void main(String[] args) {
        leetcode_1379 leetcode = new leetcode_1379();
        TreeNode originalTree = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
        TreeNode clonedTree = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
        TreeNode targetNode = new TreeNode(7, new TreeNode(4), new TreeNode(3));
        System.out.println(leetcode.getTargetCopy(originalTree, clonedTree, targetNode).toString());
    }

    /**
     * @param original Original binary tree
     * @param cloned Cloned binary tree
     * @param target Reference to a node target in the original tree
     * @return Reference to the same node in the cloned tree
     *
     * Solution - DFS
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Search binary tree with DFS.
     * Search to the original tree and the cloned tree with depth-first search and return the cloned tree if the same value exists.
     * One of the path returns the correct answer unconditionally.
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }

        TreeNode leftNode = getTargetCopy(original.left, cloned.left, target);

        if (leftNode != null) {
            return leftNode;
        }

        return getTargetCopy(original.right, cloned.right, target);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this(x);
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
