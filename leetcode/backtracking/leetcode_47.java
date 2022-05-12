package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_47 {
    public static void main(String[] args) {
        leetcode_47 leetcode = new leetcode_47();
        int[] nums = {1, 1, 2};
        System.out.println(leetcode.permuteUnique(nums));
    }

    /**
     * @param nums Array of targets to obtain permutations (may contain duplicates)
     * @return Permutations ArrayList
     *
     * Solution - Backtracking
     * Time Complexity : O(N!)
     * Space Complexity : O(N)
     *
     * Use backtracking to get permutations.
     * Sorts arrays to check for duplicate numbers.
     * Repeat backtracking and insert the value of the unvisited array into the resulting ArrayList.
     * If you have never visited a previous index and the value is the same as the current index, that is, if it is a duplicate value, continue without adding it.
     * In the next backtracking turn, you will visit sequentially to create a permutation.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new LinkedList<>();
        backtracking(resultList, new LinkedList<>(), nums, new boolean[nums.length]);
        return resultList;
    }

    void backtracking(List<List<Integer>> resultList, List<Integer> permuteList, int[] nums, boolean[] visited) {
        if (permuteList.size() == nums.length) {
            resultList.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]))
                continue;

            visited[i] = true;
            permuteList.add(nums[i]);

            backtracking(resultList, permuteList, nums, visited);

            visited[i] = false;
            permuteList.remove(permuteList.size() - 1);
        }
    }
}
