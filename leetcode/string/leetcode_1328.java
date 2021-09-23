package leetcode.string;

import java.util.Arrays;

public class leetcode_1328 {
    public static void main(String[] args) {
        leetcode_1328 lc = new leetcode_1328();

        System.out.println(lc.breakPalindrome("aa"));
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() < 2) return "";
        String[] palindromeArr = getPalindromeArr(palindrome);

        for (int i = 0; i < palindromeArr.length / 2; i++) {
            if (!palindromeArr[i].equals("a")) {
                palindromeArr[i] = "a";
                return Arrays.toString(palindromeArr);
            }
        }

        if (checkSame(palindromeArr)) {
            palindromeArr[palindromeArr.length - 1] = "b";
            return Arrays.toString(palindromeArr);
        }

        return "";
    }

    private String[] getPalindromeArr(String palindrome) {
        String[] palindromeArr = new String[palindrome.length()];
        for (int i = 0; i < palindrome.length(); i++) {
            palindromeArr[i] = palindrome.substring(i, i + 1);
        }

        return palindromeArr;
    }

    private boolean checkSame(String[] palindromeArr) {
        int checkAll = 0;
        for (String s : palindromeArr) {
            if (palindromeArr[0].equals(s)) checkAll++;
        }

        return checkAll == palindromeArr.length;
    }
}
