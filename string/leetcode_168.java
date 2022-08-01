package string;

public class leetcode_168 {
    public static void main(String[] args) {
        leetcode_168 lc = new leetcode_168();
        System.out.println(lc.convertToTitle(28));
    }

    public String convertToTitle(int columnNumber) {
        return columnNumber == 0 ? "" : convertToTitle(--columnNumber / 26) + (char) ('A' + (columnNumber % 26));
    }
}
