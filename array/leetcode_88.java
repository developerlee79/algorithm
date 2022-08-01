package array;

import java.util.Arrays;

public class leetcode_88 {
    public static void main(String[] args) {
        leetcode_88 lc = new leetcode_88();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        lc.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, end = m + n - 1;

        while (i >= 0 && j >= 0) {
            nums1[end--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }

        while (j >= 0) {
            nums1[end--] = nums2[j--];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int cnt = 0;

        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[cnt];
            cnt++;
        }

        Arrays.sort(nums1);
    }
}
