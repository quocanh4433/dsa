
import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    /* 
     * TỰ LÀM SAI HẾT 😭
     * 
     */
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int ast = asteroids[i];

            if (stack.isEmpty() || ast > 0) {
                stack.push(ast);
                continue;
            }

            // Đến đây ast chắn chắn < 0. 
            //----------------------------------------------------
            // Nếu cùng hướng với stack.peek() thêm vào stack
            if (stack.peek() * ast > 0) {
                stack.push(ast);
                continue;
            }

            // Đến đây ast chắc chắn va chạm với stack.peek()
            // kích thước ast nhỏ không đáng kể -> bỏ qua
            if (Math.abs(ast) < Math.abs(stack.peek())) {
                continue;
            }

            // kích thước ast == stack.peek() -> cả 2 cùng nổ
            if (Math.abs(ast) == Math.abs(stack.peek())) {
                stack.pop();
                continue;
            }

            // kích thước ast > stack.peek()
            while (Math.abs(ast) > Math.abs(stack.peek()) && ast * stack.peek() < 0) {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(ast);
                    break;
                }

                if (ast * stack.peek() > 0) {
                    stack.push(ast);
                    break;
                }

                while (ast * stack.peek() < 0 && Math.abs(ast) > Math.abs(stack.peek())) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] asteroids2 = {5, -5};
        int[] asteroids3 = {10, 2, -5};
        int[] asteroids4 = {5, -10};
        int[] asteroids5 = {5, -10, 20};
        int[] asteroids6 = {5, 8, -2, -20};
        int[] asteroids7 = {-5, -2, 3};
        int[] asteroids8 = null;
        System.out.println(Arrays.toString(asteroidCollision(asteroids))); // expected: [5, 10]
        System.out.println(Arrays.toString(asteroidCollision(asteroids2))); // expected: []
        System.out.println(Arrays.toString(asteroidCollision(asteroids3))); // expected: [10]
        System.out.println(Arrays.toString(asteroidCollision(asteroids4))); // expected: [-10]
        System.out.println(Arrays.toString(asteroidCollision(asteroids5))); // expected: [-10, 20]
        System.out.println(Arrays.toString(asteroidCollision(asteroids6))); // expected: [-20]
        System.out.println(Arrays.toString(asteroidCollision(asteroids7))); // expected: [-5, -2, 3]
        System.out.println(Arrays.toString(asteroidCollision(asteroids8))); // expected: []

        /* FAIL AT TESTCASE */
        int[] asteroids9 = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids9))); // expected: [-2,-1,1,2]

        /* FAIL AT TESTCASE */
        int[] asteroids10 = {-2, -2, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids10))); // expected: [-2,-2,-2]

        /* FAIL AT TESTCASE */
        int[] asteroids11 = {-2, -1, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids11))); // expected: [-2,-1,-2]

        /* FAIL AT TESTCASE */
        int[] asteroids12 = {-2, 2, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids12))); // expected: [-2]

        /* FAIL AT TESTCASE */
        int[] asteroids13 = {-2, 1, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids13))); // expected: [-2,-2]
    }
}
