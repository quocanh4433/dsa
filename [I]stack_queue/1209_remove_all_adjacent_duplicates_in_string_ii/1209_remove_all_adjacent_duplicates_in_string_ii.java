import java.util.Stack;

class RemoveAllAdjacentDuplicatesInStringII {
    /*
        time O(n)
        space O(n)
    */
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{ch, 1});
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            int[] pair = stack.pop();

            char ch = (char) pair[0];
            int f = pair[1];

            for (int i = 0; i < f; i++) {
                sb.append(ch);
            }
        }

        //reverse
        reverseStringBuilder(sb);

        return sb.toString();
    }

    private void reverseStringBuilder(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }
    }
}
