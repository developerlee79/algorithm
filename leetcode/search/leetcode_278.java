package search;

public class leetcode_278 {
    public static void main(String[] args) {
        leetcode_278 leetcode = new leetcode_278();
        System.out.println(leetcode.firstBadVersion(2));
    }

    // Solution - Binary search
    // Time Complexity : O(logN)
    // Space Complexity : O(1)
    public int firstBadVersion(int n) {
        int start = 1, end = n, middle;

        while (start < end) {
            middle = start + (end - start) / 2;

            if (!isBadVersion(middle))
                start = middle + 1;
            else
                end = middle;
        }

        return start;
    }

    // Test double method
    static boolean isBadVersion(int version) {
        return version >= 2;
    }
}
