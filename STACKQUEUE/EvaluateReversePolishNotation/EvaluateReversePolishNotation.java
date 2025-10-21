
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * Time complexity: O(n)
     *
     * Space complexity: O(n)
     *
     *
     */
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Set<String> operators = Set.of("+", "-", "*", "/");
        Stack<Integer> numStack = new Stack<>();

        for (String token : tokens) {
            if (operators.contains(token)) {
                int b = numStack.pop();
                int a = numStack.pop();
                int result = 0;

                switch (token) {
                    case "+" ->
                        result = a + b;
                    case "-" ->
                        result = a - b;
                    case "*" ->
                        result = a * b;
                    case "/" ->
                        result = a / b;
                    default ->
                        throw new AssertionError();
                }
                numStack.push(result);
            } else {
                numStack.push(Integer.valueOf(token));
            }
        }

        return numStack.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens));
    }
}

/*
- go through each element push onto stack
- if sign = "+" ||  "-" || "/" || "*"
    - resul =  pop() {sign} pop() 
    - push(result)





 */
