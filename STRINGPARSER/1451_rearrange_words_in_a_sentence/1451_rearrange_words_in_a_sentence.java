
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
        bucket sort

        time: O(n)
        space: O(n)
    */
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] words = text.split(" ");

        // 2. tìm maxLen
        int maxLen = 0;
        for (String w : words) {
            maxLen = Math.max(maxLen, w.length());
        }

        // 3. tạo bucket theo maxLen
        // index của bucket đại diện cho len(word)
        List<String>[] bucket = new ArrayList[maxLen + 1];

        // 4. phân loại vào bucket theo chiều dài
        for (String w : words) {
            int len = w.length();

            if (bucket[len] == null) {
                bucket[len] = new ArrayList<>();
            }
            bucket[len].add(w);
        }

        // 5. build kết quả
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                for (String w : bucket[i]) {
                    sb.append(w).append(" ");
                }
            }
        }

        // 6. bỏ space cuối
        sb.setLength(sb.length() - 1);

        // 7. viết hoa chữ đầu
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        return sb.toString();
    }
}
