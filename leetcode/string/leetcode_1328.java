package leetcode.string;

import java.util.Arrays;

public class leetcode_1328 {
    public static void main(String[] args) {
        leetcode_1328 lc = new leetcode_1328();

        System.out.println(lc.breakPalindrome("aa"));
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() < 2) return "";
        char[] palindromeArr = palindrome.toCharArray();

        for (int i = 0; i < palindromeArr.length / 2; i++) {
            if (palindromeArr[i] != 'a') {
                palindromeArr[i] = 'a';
                return String.valueOf(palindromeArr);
            }
        }

        if (checkSame(palindromeArr)) {
            palindromeArr[palindromeArr.length - 1] = 'b';
            return String.valueOf(palindromeArr);
        }

        return "";
    }

    private boolean checkSame(char[] palindromeArr) {
        int checkAll = 0;
        for (char s : palindromeArr) {
            if (palindromeArr[0] == s) checkAll++;
        }

        return checkAll == palindromeArr.length;
    }
}
