package baekjoon.string;

public class baekjoon_13275 {
    public static void main(String[] args) {
        baekjoon_13275 bj = new baekjoon_13275();
        System.out.println(bj.findLongestPalindrome("abab"));
    }

    int findLongestPalindrome(String s) {
        if (s == null || s.trim().equals("")) {
            return 0;
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
        return s.substring(begin, begin + maxLen).length();
    }
}
