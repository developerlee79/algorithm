package leetcode.array;

public class leetcode_35 {
    public static void main(String[] args) {
        leetcode_35 lc = new leetcode_35();

        int[] arr = {1, 3, 5, 6};
        System.out.println(lc.searchInsert(arr, 5));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) high = mid;
            else low = mid + 1;
        }

        return low;
    }
}
