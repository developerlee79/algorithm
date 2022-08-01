package search;

public class leetcode_704 {
    public static void main(String[] args) {
        leetcode_704 leetcode = new leetcode_704();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(leetcode.search(nums, 9));
    }

    // Solution - Binary search
    // Time Complexity : O(logN)
    // Space Complexity : O(1)
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length, middle;

        while (start < end) {
            middle = (end + start) / 2;

            if (nums[middle] == target)
                return middle;
            else if (nums[middle] < target)
                start = middle + 1;
            else
                end = middle;
        }

        return -1;
    }
}
