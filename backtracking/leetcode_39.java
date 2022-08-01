package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_39 {
    public static void main(String[] args) {
        leetcode_39 leetcode = new leetcode_39();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(leetcode.combinationSum(candidates, target));
    }

    // Solution - Backtracking
    // Time Complexity : O(NlogN)
    // Space Complexity : O(NlogN)
    // First sort array for backtracking
    // iterate each element of array(continue when element > target)
    // add element at front of list and recursive(candidates : copy of candidates array [0 ~ index], target : target - element)
    // if target == 0 at recursive, it means that the values added so far are valid, so add list at result and return
    // then back to called method and remove element from list for next iteration
    // if target != 0, Repeat until target is 0
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(candidates);
        backTracking(result, new LinkedList<>(), candidates, target);
        return result;
    }

    void backTracking(List<List<Integer>> result, LinkedList<Integer> list, int[] candidates, int target) {
        if (target == 0) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] <= target) {
                list.addFirst(candidates[i]);
                backTracking(result, list, Arrays.copyOfRange(candidates, 0, i + 1), target - candidates[i]);
                list.removeFirst();
            }
        }
    }
}
