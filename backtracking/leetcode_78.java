package backtracking;

import java.util.*;

public class leetcode_78 {
    public static void main(String[] args) {
        leetcode_78 lc = new leetcode_78();
        int[] nums = {1, 2, 3};
        System.out.println(lc.subsets(nums));
        System.out.println(lc.subsets2(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dp(result, nums, new ArrayList<>(), 0);
        return result;
    }

    void dp(List<List<Integer>> result, int[] num, List<Integer> ret, int x) {
        result.add(new ArrayList<>(ret));
        for (int i = x; i < num.length; i++) {
            ret.add(num[i]);
            dp(result, num, ret, i + 1);
            ret.remove(ret.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());

        int size;
        for (int num : nums) {
            size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }

        return result;
    }
}
