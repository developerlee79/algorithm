package string;

public class leetcode_171 {
    public static void main(String[] args) {
        leetcode_171 lc = new leetcode_171();
        System.out.println(lc.titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) return -1;
        int sum = 0;
        for (char c : columnTitle.toUpperCase().toCharArray()) {
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
