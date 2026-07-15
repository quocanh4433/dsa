import java.util.HashMap;
import java.util.Map;

class VerifyingAnAlienDictionary {

    /*
        time O(n * m)
        space O(26) ~ O(1)

        n: len(words)
        m: the total of number characters in all words
     */
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> order_map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            order_map.put(ch, i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];

            /*
                giả định nếu 2 từ gần giông nhau và khác nhau độ dài: 
                ví dụ: app và apple

                thì từ ngắn hơn luôn năm trước, nên duyệt theo độ dài của cur

                tức len = cur.length()

                trong khi duyệt nếu đi chưa hết độ dài của cur mà chạm đến độ dài của next

                tức vị trí đang sai return false
             */
            int len = cur.length();

            for (int k = 0; k < len; k++) {

                if (k == next.length()) {
                    return false;
                }

                int cur_order = order_map.get(cur.charAt(k)); // 0
                int next_order = order_map.get(next.charAt(k)); // 1

                if (cur_order > next_order) {
                    return false;
                }

                if (cur_order < next_order) {
                    break;
                }
            }

        }

        return true;
    }
}
