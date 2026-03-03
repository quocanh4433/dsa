
import java.util.Stack;

class Solution {
    /*
        time: O(n)
        space: O(n)

        tư duy đúng 
            • không push từng số vào stack như leetcode 227
            • gặp ( push res + sign vào stack tính new res
            • gặp ) pop res và sign cộng dồn với new res
    */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int sign = 1; // 1: plus, -1: minus
        int num = 0;
        int res = 0;
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);

            // nếu là số
            if (Character.isDigit(c)) {
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * num;
                num = 0;
                continue;
            }

            // nếu là toán tử và dấu ngoặc
            switch (c) {
                case '+' -> sign = 1;
                case '-' -> sign = -1;
                case '(' -> {
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                }
                case ')' -> {
                    res = stack.pop() * res;
                    res += stack.pop();
                }
                default -> {}
            }
            i++;
        }
        return res;
    }
}
