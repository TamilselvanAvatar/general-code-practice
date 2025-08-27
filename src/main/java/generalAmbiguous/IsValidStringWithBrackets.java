package generalAmbiguous;

import java.util.Map;
import java.util.Stack;

/**
 * Check the given string with right opening brackets with right closing brackets
 */

public class IsValidStringWithBrackets {
    public static void main(String[] args) {
        String str = "{[]}";
        System.out.println(isValidStringWithBrackets(str));
    }

    private static boolean isValidStringWithBrackets(String str) {
        Map<Character, Character> brackets = Map.of(
                '}', '{',
                ')', '(',
                ']', '['
        );
        Stack<Character> closeBrackets = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (brackets.containsKey(ch)) {
                if (closeBrackets.isEmpty()) {
                    return false;
                }
                char topBracket = closeBrackets.pop();
                if (topBracket != brackets.get(ch)) {
                    return false;
                }
            } else {
                closeBrackets.add(ch);
            }
        }
        return closeBrackets.isEmpty();
    }
}
