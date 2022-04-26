package leetcode.string;

public class leetcode_12 {
    public static void main(String[] args) {
        leetcode_12 leetcode = new leetcode_12();
        int num = 58;
        System.out.println(leetcode.intToRoman(num));
    }

    int[] intArr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romanArr = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    // Solution - Iteration
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Add Roman numerals to StringBuilder by repeating two arrays where numeric values and Roman numerals are replaced.
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < intArr.length; i++) {
            while (num >= intArr[i]) {
                num -= intArr[i];
                sb.append(romanArr[i]);
            }
        }

        return sb.toString();
    }
}
