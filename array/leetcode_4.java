package array;

public class leetcode_4 {
    public static void main(String[] args) {
        leetcode_4 leetcode = new leetcode_4();
        int[] nums1 = {0, 0}, nums2 = {0, 0};
        System.out.println(leetcode.findMedianSortedArrays(nums1, nums2));
    }

    /**
     * @param nums1 sorted array 1
     * @param nums2 sorted array 2
     * @return The median of the two sorted arrays
     *
     * Solution - Two pointers
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Repeat to half the length of the two arrays.
     * Set the pointers idx1 and idx2.
     * If the other pointer points to a larger value, set median to the value of that pointer and increase the value of the smaller pointer.
     * The median can always be the median because it repeats exactly half the sum of the lengths.
     * If the sum of the lengths of the two arrays is even, the median is the average of the two median values, so set the median before increasing -the other median- to the subMedian.
     * It returns the average of subMedian and median for even numbers, and median for odd numbers.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;

        int idx1 = 0, idx2 = 0;
        int subMedian = 0, median = 0;

        while (idx1 + idx2 <= len / 2) {
            subMedian = median;

            if (idx1 == nums1.length) {
                median = nums2[idx2++];
            } else if (idx2 == nums2.length || nums1[idx1] < nums2[idx2]) {
                median = nums1[idx1++];
            } else {
                median = nums2[idx2++];
            }
        }

        if (len % 2 == 0) {
            return (float) (subMedian + median) / 2;
        }

        return median;
    }
}
