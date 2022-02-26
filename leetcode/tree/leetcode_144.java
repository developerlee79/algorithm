package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode_144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stk = new Stack<>();
        while (!stk.isEmpty() || root != null) {
            while (root != null) {
                result.add(root.val);
                stk.push(root);
                root = root.left;
            }
            TreeNode popped = stk.pop();
            root = popped.right;
        }

        return result;
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
