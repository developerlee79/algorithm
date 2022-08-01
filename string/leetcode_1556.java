package string;

public class leetcode_1556 {
    public static void main(String[] args) {
        leetcode_1556 lc = new leetcode_1556();
        System.out.println(lc.thousandSeparator(51040));
    }

    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));

        for (int i = sb.length() - 3; i > 0; i -= 3)
            sb.insert(i, '.');

        return sb.toString();
    }
}
