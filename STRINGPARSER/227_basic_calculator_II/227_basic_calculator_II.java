import java.util.Stack;

class Solution {

    /*
        time: O(n)
        space: O(n)
     */
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // built num
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // gặp toán tử hoặc cuối chuỗi
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                switch (sign) {
                    case '+' ->
                        stack.push(num);
                    case '-' ->
                        stack.push(-num);
                    case '*' ->
                        stack.push(stack.pop() * num);
                    case '/' ->
                        stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int x : stack) {
            result += x;
        }
        return result;
    }
}
