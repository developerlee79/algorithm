package string;

import java.util.Arrays;

public class leetcode_344 {
    public static void main(String[] args) {
        leetcode_344 lc = new leetcode_344();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        lc.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    // it has to be n(1) time complexity.
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < (n / 2); i++) {
            swap(s, i, n - i - 1);
        }
    }

    private void swap(char[] c, int x, int y) {
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
    }
}
