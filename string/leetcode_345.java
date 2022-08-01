package string;

import java.util.HashSet;
import java.util.Stack;

public class leetcode_345 {
    public static void main(String[] args) {
        leetcode_345 lc = new leetcode_345();
        System.out.println(lc.reverseVowels("hello"));
    }

    static HashSet<Character> vowels = new HashSet<>();

    static {
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
    }

    public String reverseVowels(String s) {
        if (s.length() == 0) return s;

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) stack.push(c);
        }

        for (char c : s.toCharArray()) {
            if (vowels.contains(c))
                sb.append(stack.pop());
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
