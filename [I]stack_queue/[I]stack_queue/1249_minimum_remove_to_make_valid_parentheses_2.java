
import java.util.Stack;

class MinimumRemoveToMakeValidParentheses_II {

    /*  
        time O(n)
        space O(n)

        n: len(s)

        props = advantage: 👍
            ▪︎ can process strings containing special characters
     */

    public String minRemoveToMakeValid(String s) {
        if (s == null) {
            return "";
        }
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        boolean[] skip = new boolean[n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            skip[stack.pop()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (skip[i] == false) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
