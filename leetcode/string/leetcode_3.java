package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class leetcode_3 {
    public static void main(String[] args) {
        leetcode_3 leetcode = new leetcode_3();
        System.out.println(leetcode.lengthOfLongestSubstring("dvdf"));
    }

    // Solution - Sliding window using Set
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Start with 2 pointers. (left : L, right : R)
    // add element of R pointer at set iteratively & compare cnt and right - left to memorize at cnt.
    // if get a larger value, that's a long subset.
    // if set contains R, from here on, it means that it overlaps.
    // therefore remove every duplicate element & increase pointer L.
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int cnt = 0, left = 0, right = 0;

        while (right < s.length()) {
            while (set.contains(s.charAt(right)))
                set.remove(s.charAt(left++));
            set.add(s.charAt(right++));
            cnt = Math.max(cnt, right - left);
        }

        return cnt;
    }
}
