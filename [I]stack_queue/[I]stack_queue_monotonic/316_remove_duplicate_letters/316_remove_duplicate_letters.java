
class RemoveDuplicateLetters {
    /*
        time O(n)
        space O(1)
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1)
            return s;

        int[] count = new int[26];
        boolean[] visited = new boolean[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';

            count[index]--;

            // đã có trong stack thì bỏ qua
            if (visited[index])
                continue;

            while (stack.length() > 0
                    && stack.charAt(stack.length() - 1) > ch
                    && count[stack.charAt(stack.length() - 1) - 'a'] > 0) {

                char removed = stack.charAt(stack.length() - 1);
                stack.deleteCharAt(stack.length() - 1);
                visited[removed - 'a'] = false;
            }

            stack.append(ch);
            visited[index] = true;
        }

        return stack.toString();
    }
}