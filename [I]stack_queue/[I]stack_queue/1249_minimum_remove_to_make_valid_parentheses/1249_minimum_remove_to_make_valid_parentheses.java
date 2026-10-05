import java.util.Stack;

class MinimumRemoveToMakeValidParentheses {
    /*  
        time O(n)
        space O(n)

        n: len(s)

        cons = disadvantage: 📌
            ▪︎ can not handle strings with special characters

    */

    public String minRemoveToMakeValid(String s) {
        if(s == null) return "";

        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if(c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if(!stack.isEmpty() && chars[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }

        while(!stack.isEmpty()) {
            chars[stack.pop()] = '#';
        }

        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            if(c != '#') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
