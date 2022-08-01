package two_pointers;

public class leetcode_11 {
    public static void main(String[] args) {
        leetcode_11 leetcode = new leetcode_11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(leetcode.maxArea(height));
    }

    // Solution - Two pointers
    // Time Complexity - O(N)
    // Space Complexity - O(1)
    // Basically it's moves greedy(area).
    // move smaller pointer until two pointers meet.
    // because area is width * height, and height determined to be smaller one because water overflows.
    // Place each pointer at first & last index
    // if right pointer is higher or equal, move left pointer.
    // if left pointer was higher, move right pointer forward.
    // compare max value at every iteration.
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);

            if (height[left] < height[right])
                left++;
            else if (height[left] > height[right])
                right--;
            else {
                left++;
                right--;
            }
        }

        return max;
    }
}
