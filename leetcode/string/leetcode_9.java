package leetcode.string;

public class leetcode_9 {
    public static void main(String[] args) {
        leetcode_9 leetcode = new leetcode_9();
        System.out.println(leetcode.isPalindrome(121));
        System.out.println(leetcode.isPalindromeToString(121));
    }

    // Solution 1 - Mathematics operation
    // Time Complexity - O(N)
    // Space Complexity - O(1)
    // compare digit of x & num(number what start at 0) until x > 0
    // if temp(init value of x) equal num, it's palindrome
    public boolean isPalindrome(int x) {
        int num = 0, temp = x;
        while (x > 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return temp == num;
    }

    // Solution 2 - String.valueOf
    // Time Complexity - O(N)
    // Space Complexity - O(N)
    // Translate x to char array
    // use two pointer to check it's palindrome
    public boolean isPalindromeToString(int x) {
        char[] chars = String.valueOf(x).toCharArray();

        for (int i = 0, j = chars.length - 1; i < j; i++, j--)
            if (chars[i] != chars[j])
                return false;

        return true;
    }
}
