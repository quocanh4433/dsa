
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    /*
        time: O(nlogn)
            ▪︎ while loop: O(n)
            ▪︎ sort: O(klogk) mà k <= n -> O(nlogn)
        space: O(n) do stack
    
    */
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int i = 0;
        int n = formula.length();

        while (i < n) {
            char c = formula.charAt(i);

            // case 1: "("
            if (c == '(') {
                stack.push(new HashMap<>());
                i++;
                continue;
            } // case 2: ")"
            else if (c == ')') {
                i++;
                // đọc số phía sau dấu ngoặc
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }

                /*
                    case: (OH)
                    start = 4
                    i++ = 4
                    start == i -> multipiler = 1 

                    case: (OH)127
                    start = 4 
                    i++ = 6
                    start < i -> substring(start, i) = 127
                 */
                int multipiler = start < i
                        ? Integer.parseInt(formula.substring(start, i))
                        : 1;


                /*
                    stack = [ {Mg : 1}, {O: 1, H: 1}]

                    lấy ra map gần nhất trong stack

                    top = {O: 1, H: 1}

                 */
                Map<String, Integer> top = stack.pop();
                for (String key : top.keySet()) {
                    top.put(key, top.get(key) * multipiler);
                }

                /*

                    stack lúc này stack = [{Mg: 1}]

                    top lúc này top = {O: 4, H: 4}

                    nhập top vừa mới update và stack gần nhất

                    -> stack [{Mg: 1, O: 4, H: 4}]
                 */
                Map<String, Integer> cur = stack.peek();
                for (String key : top.keySet()) {
                    cur.put(key, cur.getOrDefault(key, 0) + top.get(key));
                }
            } // case 3: atom
            else {
                // kiểm tra chữ
                int start = i;
                i++;

                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }

                String atom = formula.substring(start, i);

                // kiểm tra số
                start = i;

                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }

                int count = start < i
                        ? Integer.parseInt(formula.substring(start, i))
                        : 1;

                // add vào map hiện tại
                Map<String, Integer> current = stack.peek();
                current.put(atom,
                        current.getOrDefault(atom, 0) + count);

            }
        }

        // map cuối cùng
        Map<String, Integer> result = stack.pop();

        /*
            treemap LUÔN sắp xếp theo thứ tự alpabet
            🌳 Red-Black Tree (một dạng Balanced Binary Search Tree)

            map.put("O", 2);
            map.put("H", 1);
            map.put("Mg", 1);

            -> {H=1, Mg=1, O=2}
         */
        Map<String, Integer> sorted = new TreeMap<>(result);

        StringBuilder sb = new StringBuilder();

        for (String key : sorted.keySet()) {
            sb.append(key);
            if (sorted.get(key) > 1) {
                sb.append(sorted.get(key));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countOfAtoms("Mg(OH)2"));
    }
}
