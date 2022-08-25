package string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class leetcode_383 {
    public static void main(String[] args) {
        leetcode_383 lc = new leetcode_383();
        System.out.println(lc.canConstruct("abb", "bba"));
        System.out.println(lc.canConstructSet("abb", "bba"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution - Frequency Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param ransomNote string
     * @param magazine string
     * @return return true if ransomNote can be constructed by using the letters from magazine and false otherwise
     */
    public boolean canConstructSet(String ransomNote, String magazine) {
        Map<Character, Long> frequencyMap = magazine.chars().mapToObj(c -> (char) c).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        );

        for (int i = 0; i < ransomNote.length(); i++) {
            char letter = ransomNote.charAt(i);

            if (frequencyMap.containsKey(letter) && frequencyMap.get(letter) > 0) {
                frequencyMap.put(letter, frequencyMap.get(letter) - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
