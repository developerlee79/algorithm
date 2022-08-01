package backtracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22 {
    public static void main(String[] args) {
        leetcode_22 leetcode = new leetcode_22();
        int n = 3;
        System.out.println(leetcode.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        backtracking(resultList, new StringBuilder(), 0, 0, n);
        return resultList;
    }

    // Title - Generate Parentheses
    // Solution - Backtracking
    // Time Complexity : O(N!)
    // Space Complexity : O(N)
    // Represent the number of current parentheses with 'open' and 'close' variables.
    // If open < N, it means can open more parentheses, so add parentheses and recurs.
    // If the parenthesis is as open as N, recursively close the parenthesis until close equals n.
    // If open = close = n, all parentheses are closed, so the recursion ends.
    void backtracking(List<String> parenthesisList, StringBuilder parenthesis, int open, int close, int n) {
        if (open == n && close == n) {
            parenthesisList.add(parenthesis.toString());
            return;
        }

        if (open < n) {
            parenthesis.append("(");
            backtracking(parenthesisList, parenthesis, open + 1, close, n);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }

        if (close < open) {
            parenthesis.append(")");
            backtracking(parenthesisList, parenthesis, open, close + 1, n);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }
    }
}
