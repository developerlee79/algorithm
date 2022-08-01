package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_216 {
    public static void main(String[] args) {
        leetcode_216 leetcode = new leetcode_216();
        int k = 3, n = 9;
        System.out.println(leetcode.combinationSum3(k, n));
    }

    /**
     * @param k Number of elements in a combination with a sum
     * @param n Sum
     * @return A list of all possible valid combinations
     *
     * Solution - Backtracking
     * Time Complexity : O(logN)
     * Space Complexity : O(logN)
     *
     * Classic backtracking problem.
     * Solution what recursively with backtracking with a condition that add only when the combination is k and the sum is n.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtracking(resultList, new ArrayList<>(), k, n, 1);
        return resultList;
    }

    void backtracking(List<List<Integer>> resultList, List<Integer> subset, int k, int n, int index) {
        if (subset.size() > k) {
            return;
        }

        if (subset.size() == k && n == 0) {
            resultList.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i <= 9; i++) {
            subset.add(i);
            backtracking(resultList, subset, k, n - i, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
