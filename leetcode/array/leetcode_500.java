package leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_500 {
    public static void main(String[] args) {
        leetcode_500 lc = new leetcode_500();
        String[] arr = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(lc.findWords(arr)));
    }

    public String[] findWords(String[] words) {
        List<String> wordList = new LinkedList<>();

        for (String word : words) {
            String str = word.toLowerCase();
            if (str.matches("[qwertyuiop]*") || str.matches("[asdfghjkl]*") || str.matches("[zxcvbnm]*")) {
                wordList.add(word);
            }
        }

        return wordList.toArray(new String[0]);
    }
}
