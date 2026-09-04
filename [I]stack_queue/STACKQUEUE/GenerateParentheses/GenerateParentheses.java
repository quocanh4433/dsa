
package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
     * Time và Space Complexity GenerateParentheses_Complexity.png
     */
    public static List<String> generateParenthesis(int n) {
        /*
         - only add open parentheses if open < n
         - only add close parentheses if close < open
         - valid if close == open == n
         */

        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, result, stack);
        return result;
    }

    public static void backtrack(int open, int close, int n, List<String> res, StringBuilder stack) {
        if (open == n && close == n) {
            res.add(stack.toString());
            return;
        }

        if (close < open) {
            stack.append(')');
            backtrack(open, close + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (open < n) {
            stack.append('(');
            backtrack(open + 1, close, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3)); // expected: [()()(), ()(()), (())(), (()()), ((()))]
    }
}
