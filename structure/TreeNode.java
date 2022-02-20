package leetcode;

public class TreeNode {
    Object val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Object val) {
        this.val = val;
    }

    public TreeNode(Object val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public static TreeNode of(Object... numberOfNodes) {
        if (numberOfNodes.length == 0) throw new RuntimeException();
        TreeNode head = new TreeNode(numberOfNodes[0]);
        return dp(numberOfNodes, head, 1, 2);
    }

    private static TreeNode dp(Object[] numberOfNodes, TreeNode node, int i, int x) {
        if (i >= numberOfNodes.length) return node;
        int j = i + 1;
        node.left = new TreeNode(numberOfNodes[i]);
        node.right = new TreeNode(numberOfNodes.length > j ? numberOfNodes[j] : null);
        dp(numberOfNodes, node.left, i + x, x * 2);
        dp(numberOfNodes, node.right, j + x + 1, x * 2 + 1);
        return node;
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
