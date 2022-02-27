package leetcode.tree;

import java.util.*;

public class leetcode_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        recursive(root, stack);
        return new ArrayList<>(stack);
    }

    // Recursive way
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    static void recursive(TreeNode root, Stack<Integer> stack) {
        if (root == null) return;
        recursive(root.left, stack);
        recursive(root.right, stack);
        stack.push(root.val);
    }

    // Iteratively way
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public List<Integer> iterative(TreeNode root) {
        LinkedList<Integer> arr = new LinkedList<>();
        if (root == null) return arr;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                arr.addFirst(root.val);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }

        return arr;
    }

    public class TreeNode {
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
