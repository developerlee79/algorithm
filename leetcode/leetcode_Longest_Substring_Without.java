import java.util.HashSet;
import java.util.Set;

public class leetcode_Longest_Substring_Without {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int j = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while(set.contains(c)) {
                set.remove(s.charAt(j));
                j++;
            }


            set.add(c);
            answer = Math.max(set.size(), answer);
        }

        return answer;

    }
}
