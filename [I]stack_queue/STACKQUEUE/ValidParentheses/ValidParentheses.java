
package ValidParentheses;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> result = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                result.add(c);
                continue;
            }

            if (result.isEmpty()) {
                return false;
            } else {
                if (c == ')') {
                    if (result.pop() != '(') {
                        return false;
                    }
                }

                if (c == '}') {
                    if (result.pop() != '{') {
                        return false;
                    }
                }

                if (c == ']') {
                    if (result.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return result.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()")); // expected: true
        System.out.println(isValid("(]")); // expected: false
        System.out.println(isValid("()[]{}")); // expected: true
        System.out.println(isValid("([)]")); // expected: false
    }
}
