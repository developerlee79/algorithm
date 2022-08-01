package backtracking;

import java.util.*;

public class leetcode_17 {
    public static void main(String[] args) {
        leetcode_17 leetcode = new leetcode_17();
        System.out.println(leetcode.letterCombinations("23").toString());
    }

    static final String[] keyArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Solution - Combine
    // Time Complexity - O(N)
    // Space Complexity - O(N)
    // Use double loop to add new word at list.
    // pre-list alphabets by number in keyArr
    // First Loop - iterative by digits length & make temp arrayList
    // Second Loop - for-each by keyArr[sub-elements of digits]
    // Third Loop - for-each by resultArray - concat c at string s(element of resultArray) and add in temp array
    // Example (Data - 23)
    // - First iterative
    // digit = 2
    // c at for-each loop = [a, b, c]
    // s at for-each loop = [""] - so at the end of the loop, tmp is like this : [a, b, c]
    // - Second iterative
    // digit = 3
    // c at for-each loop = [d, e, f]
    // s at for-each loop = [a, b, c] - concat c at s and insert at tmp - ad bd cd
    // so at the end of the loop, tmp is like this : [ad, bd, cd, ae, be, ce, af, bf, cf]
    public List<String> letterCombinations(String digits) {
        List<String> resultArray = new ArrayList<>();
        if (digits.isEmpty()) return resultArray;

        resultArray.add("");
        for (char digit : digits.toCharArray()) {
            List<String> tmp = new LinkedList<>();
            int i = Character.getNumericValue(digit);

            for (char c : keyArr[i].toCharArray())
                for (String s : resultArray)
                    tmp.add(s.concat(String.valueOf(c)));

            resultArray = new ArrayList<>(tmp);
        }

        return resultArray;
    }
}
