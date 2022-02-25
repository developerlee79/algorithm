package leetcode.array;

import java.util.*;

public class leetcode_1128 {
    public static void main(String[] args) {
        leetcode_1128 leetcode = new leetcode_1128();
        int[][] dominoes = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};
        System.out.println(leetcode.numEquivDominoPairs(dominoes));
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Transform array to integer. ({1, 2} -> 12)
    // calculate count of same value. (cnt += 3 * 2 / 2)
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        for (int[] dominoe : dominoes) {
            if (dominoe[0] < dominoe[1]) {
                swap(dominoe);
            }

            int t = dominoe[0] * 10 + dominoe[1];
            map.merge(t, 1, Integer::sum);
        }

        for (int i : map.values()) {
            cnt += i * (i - 1) / 2;
        }

        return cnt;
    }

    private static void swap(int[] arr) {
        int x = arr[0];
        arr[0] = arr[1];
        arr[1] = x;
    }
}
