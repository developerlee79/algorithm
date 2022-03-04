package leetcode.string;

import java.util.*;

public class leetcode_1408 {
    public static void main(String[] args) {
        leetcode_1408 leetcode = new leetcode_1408();
        String[] words = {"leetcoder", "leetcode", "od", "hamlet", "am"};
        System.out.println(leetcode.stringMatching(words).toString());
        System.out.println(leetcode.stringMatchingStringIndex(words).toString());
    }

    // Solution 1 : Brute force with memorization
    // Time Complexity : O(n^2)
    // Space Complexity : O(N)
    // If word(Element till iterate array) contains words[j](brute search)
    // add result at result list n memory j index.
    // if word equal words[j] / j got memorized / words[j].length() longer then word length
    // then skip this sequence and proceed next loop.
    public List<String> stringMatching(String[] words) {
        List<String> result = new LinkedList<>();

        int[] dp = new int[words.length];

        for (String word : words) {
            for (int j = 0; j < words.length; j++) {
                if (word.equals(words[j]) || dp[j] == 1 || word.length() < words[j].length())
                    continue;
                if (word.contains(words[j])) {
                    result.add(words[j]);
                    dp[j] = 1;
                }
            }
        }

        return result;
    }

    // Solution 2 : Compare index of string
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Combine string array as string str
    // if index of word(at first place) doesn't equal last index of word
    // it means there must be longest string contains word.
    public List<String> stringMatchingStringIndex(String[] words) {
        List<String> list = new LinkedList<>();

        String str = String.join(" ", words);
        for (String word : words)
            if (str.indexOf(word) != str.lastIndexOf(word))
                list.add(word);

        return list;
    }
}
