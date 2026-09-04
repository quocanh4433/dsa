import java.util.Objects;
import java.util.Stack;

class BackspaceStringCompare_Stack {

    /*
        time O(max(n, m))
        space O(n + m)
     */
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        getChar(stackS, s);
        getChar(stackT, t);

        if (stackS.size() != stackT.size()) {
            return false;
        }

        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (!Objects.equals(stackS.pop(), stackT.pop())) {
                return false;
            }
        }

        return true;
    }

    public void getChar(Stack<Character> stack, String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
    }
}
