package leetcode.string;

public class leetcode_5 {
    public static void main(String[] args) {
        leetcode_5 lc = new leetcode_5();
        System.out.println(lc.longestPalindrome("abba"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.trim().equals("")) {
            return s;
        }
        int len = s.length();
        int begin = 0;
        int maxLen = 0;
        for (int i = 0; i < len - maxLen / 2; i++) {
            int j = i;
            int k = i;
            while (k < len - 1 && s.charAt(k) == s.charAt(k + 1)) {
                k++;
            }
            while (j > 0 && k < len - 1 && s.charAt(j - 1) == s.charAt(k + 1)) {
                j--;
                k++;
            }
            int newLen = k - j + 1;
            if (newLen > maxLen) {
                begin = j;
                maxLen = newLen;
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
