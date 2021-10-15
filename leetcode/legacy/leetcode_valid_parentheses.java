import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class leetcode_valid_parentheses {
    public static void main(String[] args) {
        leetcode_valid_parentheses l = new leetcode_valid_parentheses();

        System.out.println(l.isValid("{{}}"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> mappings = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Stack<Character> letters = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (mappings.containsKey(temp)) {
                if (letters.isEmpty() || letters.pop() != mappings.get(temp)) {
                    return false;
                }
            } else {
                letters.push(temp);
            }
        }
        return letters.isEmpty();
    }
}
