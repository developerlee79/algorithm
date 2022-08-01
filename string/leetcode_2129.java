package string;

public class leetcode_2129 {
    public static void main(String[] args) {
        leetcode_2129 leetcode = new leetcode_2129();
        System.out.println(leetcode.capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(leetcode.capitalizeTitleBit("capiTalIze tHe titLe"));
    }

    // Solution 1 - Use built in String method
    // Time Complexity - O(N)
    // Space Complexity - O(N)
    public String capitalizeTitle(String title) {
        String[] arr = title.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase();

            if (arr[i].length() > 3) {
                arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
            }

            sb.append(arr[i]).append(" ");
        }

        return sb.toString().trim();
    }

    // Solution 2 - Bit manipulation
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public String capitalizeTitleBit(String title) {
        char[] chars = title.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int firstIndex = i;

            while (i < chars.length && chars[i] != ' ') {
                chars[i] |= 32;
                i++;
            }

            if (i - firstIndex > 2)
                chars[firstIndex] &= ~32;
        }

        return String.valueOf(chars);
    }
}
