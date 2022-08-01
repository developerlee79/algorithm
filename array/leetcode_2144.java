package array;

import java.util.Arrays;

public class leetcode_2144 {
    public static void main(String[] args) {
        leetcode_2144 leetcode = new leetcode_2144();
        int[] cost = {3, 3, 3, 1};
        System.out.println(leetcode.minimumCost(cost));
    }

    // Solution : Sort Greedy
    // Time Complexity : O(NlogN)
    // Space Complexity : O(1)
    // Basically this "greedy" algorithm select highest two value n skip one value
    // So the key of this question is how to reduce memory usage after sorting array
    // Use j as counting variable to check third object what doesn't count
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int cnt = 0;
        for (int i = cost.length - 1, j = 1; i >= 0; i--, j++)
            if (j % 3 != 0) cnt += cost[i];

        return cnt;
    }
}
