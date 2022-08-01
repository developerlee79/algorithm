package string;

public class leetcode_58 {
     int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");

        return arr[arr.length - 1].length();
    }
}
