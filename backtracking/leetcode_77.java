package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_77 {
    public static void main(String[] args) {
        leetcode_77 leetcode = new leetcode_77();
        int n = 4, k = 2;
        System.out.println(leetcode.combine(n, k));
    }

    // Solution - Backtracking
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultArray = new ArrayList<>();
        backtracking(resultArray, new ArrayList<>(), n, k, 1);
        return resultArray;
    }

    void backtracking(List<List<Integer>> resultArray, List<Integer> elementArray, int n, int k, int i) {
        if (elementArray.size() == k) {
            resultArray.add(new ArrayList<>(elementArray));
            return;
        }

        for (; i <= n; i++) {
            elementArray.add(i);
            backtracking(resultArray, elementArray, n, k, i + 1);
            elementArray.remove(elementArray.size() - 1);
        }
    }
}
