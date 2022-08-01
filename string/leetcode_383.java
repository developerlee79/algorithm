package string;

public class leetcode_383 {
    public static void main(String[] args) {
        leetcode_383 lc = new leetcode_383();
        System.out.println(lc.canConstruct("abb", "bba"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
