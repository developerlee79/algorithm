package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_1239 {
    public static void main(String[] args) {
        leetcode_1239 lc = new leetcode_1239();

        List<String> arr = new ArrayList<>();
        arr.add("cha");
        arr.add("r");
        arr.add("act");
        arr.add("ers");

        System.out.println(lc.maxLength(arr));
    }

    public int maxLength(List<String> arr) {
        return helper(arr, 0, "");
    }

    private int helper(List<String> arr, int index, String cur) {
        if (index == arr.size()) return cur.length();

        int res = cur.length();
        for (int i = index; i < arr.size(); i++) {
            String str = cur + arr.get(i);
            if (isUnique(str)) {
                res = Math.max(res, helper(arr, i + 1, str));
            }

        }
        return res;
    }

    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}
