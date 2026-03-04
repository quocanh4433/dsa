
import java.util.*;

class Solution {

    /*
    
        time
            ▪︎ averrage: O(n)
            ▪︎ worst case: O(n**2)
        space
            ▪︎ averrage: O(n)
            ▪︎ worst case: O(n**2)

        nguyên nhân O(n**2) 
            ▪︎ clone nhiều scope
            ▪︎ lồng nhiều recursion let vd: (let x ( let y ( let z.. )))  
     */

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

        @param expr = "x (mult 5 6)" OR
        @param expr = "5 (mult 5 6)"
    
     */
    private int eval(String expr, Map<String, Integer> scope) {

        if (expr.charAt(0) != '(') { // nếu không phải '(' thì chỉ có số hoặc biến

            // nếu là số
            if (Character.isDigit(expr.charAt(0)) || expr.charAt(0) == '-') {
                return Integer.parseInt(expr);
            }

            // nếu là biến
            return scope.get(expr);
        }

        // nếu là biểu thức (add 3 4) thì bỏ dấu ngoặc '(' và ')'
        String content = expr.substring(1, expr.length() - 1);

        // xác định loại biểu thức
        if (content.startsWith("add")) {
            return handleAdd(content, scope);
        } else if (content.startsWith("mult")) {
            return handleMult(content, scope);
        } else { // let
            return handleLet(content, scope);
        }
    }

    private int handleAdd(String content, Map<String, Integer> scope) {
        // bỏ add 
        // content = add 3 (mult 4 5) -> 3 (mult 4 5)
        String rest = content.substring(4);
        // part = ["3", "(mult 4 5)"]
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

        // tạo scope cho let hiện tại nhưng vẫn kế thừ scope bên ngoài
        Map<String, Integer> newScope = new HashMap<>(scope);

        // gán biến
        // part cuối (idx: part.size() - 1) là biểu thức trong ngoặc nên không cần xét
        // += 2 vì tên biến năm ở index chẳng
        for (int i = 0; i < parts.size() - 1; i += 2) {
            // tên biến
            String var = parts.get(i);
            // value của biến cần xét thêm scope
            int value = eval(parts.get(i + 1), newScope);
            newScope.put(var, value);
        }
        // Biểu thức cuối cùng 
        // do let không tính toán mà buổi thức cuối mới tính toán
        return eval(parts.get(parts.size() - 1), newScope);
    }

    /*
        hàm tách space nhưng vẫn giữ ngoặc

        @param s = "5 (add 3 4)"
        @return res = ["5", "(add 3 4)"]
     */
    private List<String> split(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            }
            if (c == ')') {
                balance--;
            }

            if (c == ' ' && balance == 0) { // gặp space và space không ở trong ngoặc
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
