package tree;

public class leetcode_99 {
    public static void main(String[] args) {
        leetcode_99 leetcode = new leetcode_99();
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        leetcode.recoverTree(root);
        System.out.println(root);
    }

    // Solution - DFS (Inorder traversal)
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Inorder traversal always searched in the order left-middle-right.
    // Therefore it's suitable for searching BST Tree whose values are always placed by left < middle < right
    // Use inorder traversal to ensure that always the current root > previous node.
    // If there is no previous value, it means current node is searching the root.left depth for the first time.
    // If the value of the current node is less than prev node during recursion, it's a "mistake" node.
    // Therefore, store previous Node(only at first time) & current Node at firstInvalid & secondInvalid Node.
    // When recursive reach the root.right, from now on searching root.right.
    // Proceed the same (prev > curr condition remains because right node must be larger than prev).
    // Searching the entire tree like this - inorder traversal.
    // Swap each value after recursion ended to recover tree.
    public void recoverTree(TreeNode root) {
        traversal(root);
        swap(firstInvalidNode, secondInvalidNode);
    }

    private TreeNode previousNode, firstInvalidNode, secondInvalidNode;

    void traversal(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        traversal(currentNode.left);

        if (previousNode != null && previousNode.val > currentNode.val) {
            if (firstInvalidNode == null) {
                firstInvalidNode = previousNode;
            }
            secondInvalidNode = currentNode;
        }

        previousNode = currentNode;

        traversal(currentNode.right);
    }

    void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    static class TreeNode {
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
