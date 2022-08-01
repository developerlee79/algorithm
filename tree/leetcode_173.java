package tree;

import java.util.Stack;

public class leetcode_173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator bstIterator = new BSTIterator(root);

        for (int i = 0; i < 3; i++) {
            System.out.println(bstIterator.next());
            System.out.println(bstIterator.hasNext());
        }
    }

    // Solution - DFS with Stack
    // Time Complexity : O(N) (Average : O(1)?)
    // Space Complexity : O(N)
    // Like problem says, it's basically act like in-order traversal.
    // It means it works like a leetcode_99 - so let's solve it from now.
    // We use stack as save previous node what in-order already skipped.
    // When next() called, it search to the end of the left node and push it into the stack.
    // After that, next() return value of currentNode and switched currentNode to right node for searching right side (in-order traversal)
    // If the right node has a left child node, iterative same as previous task.
    // If there's no right node(currentNode == null), pop previous(parent) node from stack and do it again.
    // When stack is empty & currentNode is null, it means it's end of the tree - so hasNext() == false.
    static class BSTIterator {

        private final Stack<TreeNode> treeNodeStack;

        private TreeNode currentNode;

        public BSTIterator(TreeNode root) {
            treeNodeStack = new Stack<>();
            currentNode = root;
        }

        public int next() {
            while (currentNode != null) {
                treeNodeStack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = treeNodeStack.pop();
            int val = currentNode.val;
            currentNode = currentNode.right;
            return val;
        }

        public boolean hasNext() {
            return !treeNodeStack.isEmpty() || currentNode != null;
        }
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
