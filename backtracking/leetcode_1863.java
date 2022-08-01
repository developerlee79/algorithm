package backtracking;

public class leetcode_1863 {
    public static void main(String[] args) {
        leetcode_1863 leetcode = new leetcode_1863();
        int[] nums = {1, 3};
        System.out.println(leetcode.subsetXORSum(nums));
    }

    public int subsetXORSum(int[] nums) {
        return getSubSetXOR(nums, 0, 0);
    }

    // Solution - Recursion
    // Time Complexity : O(NlogN)
    // Space Complexity : O(NlogN)
    // Divide the array into parts and apply the XOR operation to obtain the value.
    // One array applies an XOR operation to the value of the current value and the value of the current array.
    // The other array only increases the Index value.
    // The first part with XOR is used to add values, and the second part is used to load a single value.
    // At the end of the recursion, returns the XOR operation applied and a single value combined.
    int getSubSetXOR(int[] nums, int index, int currentValue) {
        if (index == nums.length) {
            return currentValue;
        }

        return getSubSetXOR(nums, index + 1, currentValue ^ nums[index]) +
                getSubSetXOR(nums, index + 1, currentValue);
    }
}
