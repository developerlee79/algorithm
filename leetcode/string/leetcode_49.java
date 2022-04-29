package leetcode.string;

import java.util.*;

public class leetcode_49 {
    public static void main(String[] args) {
        leetcode_49 leetcode = new leetcode_49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(leetcode.groupAnagrams(strs));
    }

    // Solution - Hash Map
    // Time Complexity : O(NlogN)
    // Space Complexity : O(N)
    // Converts the string to a char array and sorts it to create an  original anagram string regardless of the order.
    // Check map contains sorted string and if it is not contain, add a new LinkedList and put the sorted string : pre-sorted string into the map.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = String.valueOf(chars);
            if (!anagramMap.containsKey(sortedString)) {
                anagramMap.put(sortedString, new LinkedList<>());
            }
            anagramMap.get(sortedString).add(str);
        }

        return new LinkedList<>(anagramMap.values());
    }
}
