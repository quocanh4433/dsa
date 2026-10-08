import java.util.Stack;

class RemoveKDigits {
      /*
        time O(n)
        space O(n)

     */
    public String removeKdigits(String num, int k) {
        if(num == null) return null;
        if(num.length() == k) return "0";

        int n = num.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        // *** case quan trọng
        // remove remain k digit from the end of the stack
        while(!stack.isEmpty()  && k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        reverse(sb);

        // *** case quan trọng
        // remove leadings zero
        while(sb.length() > 0 && sb.charAt(0) == '0') { 
            sb.deleteCharAt(0);
        }   

        return sb.length() > 0 ? sb.toString() : "0";
    }

    public void reverse(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;

        while(left <= right) {
            char cl = sb.charAt(left);
            char cr = sb.charAt(right);

            sb.setCharAt(left, cr);
            sb.setCharAt(right, cl);

            left++;
            right--;
        }
    }
}





/*

X num = "1432219", k = 3 -> "1219"


X num = "10200", k = 1 -> 200 -> handle leading zero
0020

X num = "10", k = 2 -> 0 -> 


X num = "100000", k = 1 -> 0 -> handle all zero


*/