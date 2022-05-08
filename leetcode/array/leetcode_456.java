package leetcode.array;

import java.util.Stack;

public class leetcode_456 {
    public static void main(String[] args) {
        leetcode_456 leetcode = new leetcode_456();
        int[] nums = {1, 2, 3, 4};
        System.out.println(leetcode.find132pattern(nums));
    }

    // Solution - Stack
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Stack using method.
    // Verify that the variable thirdElement meets the pattern 132
    // Check the current element is less then thirdElement.
    // If it is, it means 132 pattern is satisfied - so return true
    // Else, popping stack value until stack top element larger than nums[i] to set thirdElement.
    // And push nums[i] into stack.
    // If there's no pattern in this array - return false.
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int thirdElement = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < thirdElement)
                return true;

            while (!stack.isEmpty() && stack.peek() < nums[i])
                thirdElement = stack.pop();

            stack.push(nums[i]);
        }

        return false;
    }
}
