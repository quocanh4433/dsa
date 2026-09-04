
package BaseballGame;

import java.util.Stack;

public class BaseballGame {

    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(n)
     * 
     * Bài này có thể giải bằng array;
     */
    public static int calPoints(String[] operations) {
        if (operations == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (String s : operations) {
            // switch expression (Java 14+)
            switch (s) {
                case "D" ->
                    stack.push(stack.peek() * 2);
                case "C" ->
                    stack.pop();
                case "+" -> {
                    int last = stack.pop();
                    int sum = last + stack.peek();
                    stack.push(last);
                    stack.push(sum);
                }
                default ->
                    stack.push(Integer.valueOf(s));
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }
        /*
         * Viết bằng Stream + Lambda
         * 
         * int result = stack.stream().mapToInt(Integer::intValue).sum();
         */

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})); // expected: 27
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"})); // expected: 30
        System.out.println(calPoints(new String[]{"1", "C"})); // expected: 0
    }
}
