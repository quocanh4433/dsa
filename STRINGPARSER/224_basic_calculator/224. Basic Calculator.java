
import java.util.Stack;

class Solution {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // nếu là số
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // nều là dấu ngoặc - dấu - cuối chuỗi
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {

                if (sign == '+') {
                    stack.push(num);
                }
            }
        }

        int res = 0;
        for (int x : stack) {
            res += x;
        }

        return res;
    }
}
