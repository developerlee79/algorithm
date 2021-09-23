package leetcode.string;

public class leetcode_1328 {
    public static void main(String[] args) {
        leetcode_1328 lc = new leetcode_1328();

        System.out.println(lc.breakPalindrome("aa"));
    }

    public String breakPalindrome(String palindrome) {
        char[] palindromeArr = palindrome.toCharArray();

        for (int i = 0; i < palindromeArr.length / 2; i++) {
            if (palindromeArr[i] != 'a') {
                palindromeArr[i] = 'a';
                return String.valueOf(palindromeArr);
            }
        }

        palindromeArr[palindromeArr.length - 1] = 'b';
        return palindrome.length() < 2 ? "" : String.valueOf(palindromeArr);
    }
}
