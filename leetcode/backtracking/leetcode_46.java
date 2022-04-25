package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_46 {
    public static void main(String[] args) {
        leetcode_46 leetcode = new leetcode_46();
        int[] nums = {1, 2, 3};
        System.out.println(leetcode.permute(nums));
    }

    // Solution - Backtracking
    // Time Complexity : O(n!)
    // Space Complexity : O(N)
    // Classic backtracking problem.
    // If the value you are trying to add exists in the list, exclude the value and move on.
    // If not, add a value to the list and proceed with a recursive call.
    // If the length of the sublist is equal to the length of the target list (correct permutation), add sublist to the resultList.
    // After adding to the resultList, prepare the next permutation by remove the values added to the sublist before recursion.
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultArrayList = new ArrayList<>();
        backtracking(resultArrayList, new ArrayList<>(), nums);
        return resultArrayList;
    }

    void backtracking(List<List<Integer>> resultList, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (list.contains(num))
                continue;
            list.add(num);
            backtracking(resultList, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
