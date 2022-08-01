package two_pointers;

import java.util.HashSet;
import java.util.Set;

public class leetcode_567 {
    public static void main(String[] args) {
        leetcode_567 leetcode = new leetcode_567();
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(leetcode.checkInclusion(s1, s2));
        System.out.println(leetcode.checkInclusionPermutation(s1, s2));
    }

    /**
     * @param s1 candidate string
     * @param s2 target string
     * @return did target string contains candidate string
     *
     * Solution - Sliding window
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Solve the problem using "sliding window".
     * Use the "window size" as the size of the candidate string.
     * Declares two arrays representing each character in a string.
     * Counts the character of the candidate string in the first array.
     * Then, repeat the length of the target string to populate the second array.
     * Remove the count at the end of the "window" if the index is greater than the length of the candidate string,
     * that is, if the second array has more counted elements than the candidate string.
     * Then compare the two arrays and return true if the number of elements(characters) is the same
     * Returns false if the array is different until the end of the iteration.
     */
    public boolean checkInclusion(String s1, String s2) {
        int firstStrLength = s1.length(), secondStrLength = s2.length();

        if (firstStrLength > secondStrLength) {
            return false;
        }

        int[] firstArray = new int[ARRAY_SIZE], secondArray = new int[ARRAY_SIZE];

        for (char c : s1.toCharArray())
            firstArray[c]++;

        for (int i = 0; i < secondStrLength; i++) {
            secondArray[s2.charAt(i)]++;

            if (i + 1 > firstStrLength)
                secondArray[s2.charAt(i - firstStrLength)]--;

            if (equalArray(firstArray, secondArray))
                return true;
        }

        return false;
    }

    private static final int ARRAY_SIZE = 'a' + 26;

    private static boolean equalArray(int[] firstArray, int[] secondArray) {
        for (int i = 'a'; i < ARRAY_SIZE; i++) {
            if (firstArray[i] != secondArray[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution - Get permutation with backtracking (Timeout at LeetCode)
     * Time Complexity : O(N!)
     * Space Complexity : O(N)
     */
    public boolean checkInclusionPermutation(String s1, String s2) {
        Set<String> permutationSet = getPermutation(s1);

        for (int i = s1.length(); i <= s2.length(); i++) {
            if (permutationSet.contains(s2.substring(i - s1.length(), i)))
                return true;
        }

        return false;
    }

    private Set<String> getPermutation(String target) {
        Set<String> permutationSet = new HashSet<>();
        backtracking(permutationSet, new StringBuilder(target), 0);
        return permutationSet;
    }

    private static void backtracking(Set<String> resultSet, StringBuilder sb, int index) {
        if (index == sb.length()) {
            resultSet.add(sb.toString());
        } else {
            backtracking(resultSet, sb, index + 1);

            for (int i = index + 1; i < sb.length(); i++) {
                swap(sb, index, i);
                backtracking(resultSet, sb, index + 1);
                swap(sb, i, index);
            }
        }
    }

    private static void swap(StringBuilder str, int x, int y) {
        char tmp = str.charAt(x);
        str.setCharAt(x, str.charAt(y));
        str.setCharAt(y, tmp);
    }
}
