public class palindrome_number {
    public boolean isPalindrome(int x) {
        int num = 0, temp = x;
        while (x > 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return temp == num;
    }
}
