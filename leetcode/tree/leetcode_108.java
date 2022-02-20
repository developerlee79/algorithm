package leetcode.tree;

public class leetcode_108 {

    // Solution
    // Time Complexity : O(N)
    // Divide-and-conquer
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }

    private static TreeNode recursive(int[] nums, int left, int right) {
       if (left > right) return null;
       int m = (right - left) / 2 + left;
       TreeNode node = new TreeNode(nums[m]);
       node.left = recursive(nums, left, m - 1);
       node.right = recursive(nums, m + 1, right);
       return node;
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
