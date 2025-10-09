
import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    /*
     * Time complexity: O(n)
     * 
     * Space complexity: O(n)
     * 
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return new int[]{};
        }

        Stack<Integer[]> stack = new Stack<>(); // pair: [ temp , index]
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];

            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                result[stack.peek()[1]] = i - stack.peek()[1];
                stack.pop();
            }

            stack.push(new Integer[]{temp, i});

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); // expected: [1,1,4,2,1,1,0,0]
    }
}
