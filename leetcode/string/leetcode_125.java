package leetcode.string;

import java.util.Locale;

public class leetcode_125 {
    public static void main(String[] args) {
        leetcode_125 lc = new leetcode_125();
        System.out.println(lc.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            if (i >= j) break;

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i >= j) break;

            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) return false;
        }

        return true;
    }
}
