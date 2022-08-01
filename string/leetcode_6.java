package string;

public class leetcode_6 {
    public static void main(String[] args) {
        leetcode_6 leetcode = new leetcode_6();
        String str = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(leetcode.convert(str, rows));
    }

    // Solution - Recursive
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Extracts strings in zigzag order by recursion.
    // First, let's think about the zigzag pattern.
    // In this problem, the zigzag pattern consists of "zig" consisting of numRows alphabets and "zag" connecting the end of the zig to next zig.
    // Because zag does not contain the both end of zig, zag = zig - 2 is established.
    // We can now find the rules here.
    // For the first row in a zigzag string, it consists only of the string after zig + zag in the first alphabet of the existing string.
    // Also, the pattern between the first zig and the next zig is repeated across all zig-zags.
    // So we can pattern the zig-zag like this.
    //
    // P   A   H   N    [1 2 3 2 / 1 2 3 2 / 1 2 3 2 / 1 2]   [1 1 1 1 / 2 2 2 2 2 2 2 / 3 3 3]
    // A P L S I I G  - [P A Y P / A L I S / H I R I / N G] - [P A H N / A P L S I I G / Y I R]
    // Y   I   R
    //
    // P     I     N    [1 2 3 4 3 2 / 1 2 3 4 3 2 / 1 2]   [1 1 1 / 2 2 2 2 2 / 3 3 3 3 / 4 4]
    // A   L S   I G  - [P A Y P A L / I S H I R I / N G] - [P I N / A L S I G / Y A H R / P I]
    // Y A   H R
    // P     I
    //
    // If divide the original string by zig + zag (length of a single zigzag pattern),
    // Each row will have one jig and one zag except for the two ends where the zag does not exist.
    // Like the example, except for the beginning and end of the zig (the first and middle characters as strings),
    // the string that will fit in the column will be p / (zig + zag) - p in the corresponding zig-zag.
    // Follow this pattern to extract the alphabet from the string as per rule until p meets (zig + zag) - p, i.e., it reaches the end of zig.
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;

        int sizeOfZigZag = (numRows - 1) * 2;
        StringBuilder sb = new StringBuilder();
        recursive(s, 0, sizeOfZigZag, sb);

        return sb.toString();
    }

    void recursive(String targetString, int p, int size, StringBuilder sb) {
        if (p >= size) {
            return;
        }

        for (int i = p, j = size - p; i < targetString.length() && i <= j; i += size, j += size) {
            sb.append(targetString.charAt(i));
            if (p != 0 && i != j && j < targetString.length())
                sb.append(targetString.charAt(j));
        }

        recursive(targetString, p + 1, size, sb);
    }
}
