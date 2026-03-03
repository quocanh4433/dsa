
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
        time: O(n)
        space: O(n)
    */
    public String reorderSpaces(String text) {
        int n = text.length();
        int spaceCount = 0;
        List<String> words = new ArrayList<>();
        int i = 0;

        while (i < n) {
            char c = text.charAt(i);
            if (c == ' ') {
                spaceCount++;
                i++;
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLetter(text.charAt(i))) {
                    i++;
                }
                words.add(text.substring(start, i));
            }
        }

        int wordCount = words.size();

        if (wordCount == 1) {
            return words.get(0) + " ".repeat(spaceCount);
        }

        int spaces = spaceCount / (wordCount - 1);
        int remainSpaces = spaceCount % (wordCount - 1);

        String gap = " ".repeat(spaces);
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < wordCount; k++) {
            String s = words.get(k);
            sb.append(s);
            if (k < wordCount - 1) {
                sb.append(gap);
            }
        }

        sb.append(" ".repeat(remainSpaces));
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reorderSpaces("  this   is  a sentence "));
    }
}
