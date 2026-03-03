
import java.util.*;

class Solution {

    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    /*
        một biểu thức lips có 2 phần
    
        1. atomic (đơn giản)
            
        2. compound (phức tạp)
            add(....)
            mult(...)
            let(...)
    
        hàm eval tách + tính toán các phần
    
     */
    private int eval(String expr, Map<String, Integer> scope) {

        if (expr.charAt(0) != '(') { // nếu không phải '(' thì chỉ có số hoặc biến

            // nếu là số
            if (Character.isDigit(expr.charAt(0))) {
                return Integer.parseInt(expr);
            }

            // nếu là biến
            return scope.get(expr);
        }

        // nếu là biểu thức (add 3 4) thì bỏ dấu ngoặc '(' và ')'
        String content = expr.substring(1, expr.length() - 1); // xác định loại biểu thức
        if (content.startsWith("add ")) {
            return handleAdd(content, scope);
        } else if (content.startsWith("mult ")) {
            return handleMult(content, scope);
        } else { // let
            return handleLet(content, scope);
        }
    }

    private int handleAdd(String content, Map<String, Integer> scope) {
        // bỏ add 
        // content = add 3 (mult 4 5) -> 3 (mult 4 5)
        String rest = content.substring(4); // part = ["3", "(mult 4 5)"]
        List<String> parts = split(rest);

        int val1 = eval(parts.get(0), scope);
        int val2 = eval(parts.get(1), scope);

        return val1 + val2;
    }

    private int handleMult(String content, Map<String, Integer> scope) {
        // bỏ mult 
        String rest = content.substring(5);
        List<String> parts = split(rest);

        int val1 = eval(parts.get(0), scope);
        int val2 = eval(parts.get(1), scope);

        return val1 * val2;
    }

    private int handleLet(String content, Map<String, Integer> scope) {
        // bỏ let
        String rest = content.substring(4);
        List<String> parts = split(rest);

        int val1 = eval(parts.get(0), scope);
        int val2 = eval(parts.get(1), scope);

        return val1 * val2;
    }

    // Hàm tách expression theo space nhưng giữ nguyên ngoặc
    private List<String> split(String s) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') balance++;
            if (c == ')') balance--;

            if (c == ' ' && balance == 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString());
        return result;
    }
}
