package leetcode.string;

import java.util.HashMap;

public class leetcode_290 {
    public static void main(String[] args) {
        leetcode_290 lc = new leetcode_290();
        System.out.println(lc.wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if (arr.length != pattern.length())
            return false;
        for (int i = 0; i < arr.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i]))
                    return false;
            } else {
                if (map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}
