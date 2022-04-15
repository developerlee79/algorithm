package tree;

public class leetcode_669 {
    public static void main(String[] args) {
        leetcode_669 leetcode = new leetcode_669();
        TreeNode root = new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
        System.out.println(leetcode.trimBST(root, 1, 3).toString());
    }

    // Solution - DFS
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // post-order recursive
    // recursively navigate to the end of the tree - values are compared from here.
    //
    // recursive process
    // if val smaller than low - return right node because it's binary search tree so there's no larger then val anymore in left
    // if val larger than low - same as smaller case - return left node
    // returning left / right node means skipping the node associated with the parent node.
    // it means replacing nodes without changing the relative structure of elements.
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        if (root.val < low)
            return root.right;
        else if (root.val > high)
            return root.left;

        return root;
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
