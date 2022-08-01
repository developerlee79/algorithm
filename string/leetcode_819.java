package string;

import java.util.*;

public class leetcode_819 {
    public static void main(String[] args) {
        leetcode_819 lc = new leetcode_819();
        String paragraph = "Bob. hIt, baLl";
        String[] banned = {"bob", "hit"};
        System.out.println(lc.mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> strMap = new HashMap<>();

        String result = null;
        String[] paragraphArr = paragraph.toLowerCase().split("[ ,.!?';]+");
        for (String s : paragraphArr) {
            if (!banSet.contains(s)) {
                strMap.merge(s, 1, Integer::sum);
                if (result == null || strMap.get(s) > strMap.get(result)) result = s;
            }
        }

        return result;
    }
}
