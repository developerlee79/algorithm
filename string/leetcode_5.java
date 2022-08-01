package string;

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
    
    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
          dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

          if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
            res = s.substring(i, j + 1);
          }
        }
        }

        return res;
    }
}
