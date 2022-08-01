package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode_349 {
    public static void main(String[] args) {
        leetcode_349 lc = new leetcode_349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(lc.intersection(nums1, nums2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);

        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) set.add(num);
        }

        return set.stream().mapToInt(i -> i).toArray();
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
