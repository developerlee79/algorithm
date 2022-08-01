package two_pointers;

public class leetcode_557 {
    public static void main(String[] args) {
        leetcode_557 leetcode = new leetcode_557();
        String words = "a's s'a x's";
        System.out.println(leetcode.reverseWords(words));
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Start with two pointer i & j.
    // i save index of each word / j move forward until meet an blank
    // if j meet blank, it means end of this word and it has to be reversed.
    // therefore reverse subset and increase i pointer as j + 1 (cause j + 1 is always start idx of next word)
    // when j reach the end of array, reverse it over lastly (cause no more blanks there)
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0, j = 1; j <= chars.length; j++) {
            if (j == chars.length || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }

        return String.valueOf(chars);
    }

    static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    static void swap(char[] arr, int x, int y) {
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
