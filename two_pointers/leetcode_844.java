package two_pointers;

public class leetcode_844 {
    public static void main(String[] args) {
        leetcode_844 leetcode = new leetcode_844();
        String s = "a##c", t = "#a#c";
        System.out.println(leetcode.backspaceCompare(s, t));
        System.out.println(leetcode.backspaceCompareStringBuilder(s, t));
    }

    // Solution 1 - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Start with two pointers.
    // Move each pointer until the char that the pointer points is not BackSpace(#).
    // Compare each pointer and if there's not same - it means different string - return false.
    // Iterative until one pointer be 0.
    public boolean backspaceCompare(String s, String t) {
        int p1 = s.length() - 1, p2 = t.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            p1 = subtractUntilNonHashChar(s, p1);
            p2 = subtractUntilNonHashChar(t, p2);

            if (equalBackSpacedStringWithPointerStatus(s, t, p1--, p2--))
                return false;
        }

        return true;
    }

    private boolean equalBackSpacedStringWithPointerStatus(String s, String t, int p1, int p2) {
        return p1 >= 0 && p2 >= 0 && s.charAt(p1) != t.charAt(p2) || p1 >= 0 ^ p2 >= 0;
    }

    private int subtractUntilNonHashChar(String s, int pointer) {
        int hashPoint = 0;

        while (pointer >= 0) {
            if (checkHash(s, pointer)) {
                hashPoint++;
                pointer--;
            } else if (hashPoint > 0) {
                hashPoint--;
                pointer--;
            } else {
                break;
            }
        }

        return pointer;
    }

    private boolean checkHash(String s, int index) {
        return s.charAt(index) == '#';
    }

    // Solution 2 - String Builder
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Simple solution.
    // Append char in StringBuilder iteratively.
    // If explored char is a backspace, remove it from the StringBuilder.
    public boolean backspaceCompareStringBuilder(String s, String t) {
        return getDeletedString(s).equals(getDeletedString(t));
    }

    private String getDeletedString(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
