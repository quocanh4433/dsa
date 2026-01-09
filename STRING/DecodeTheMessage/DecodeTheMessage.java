import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage {
    /*
        Ý TƯỞNG
        - Tạo mảng mẫu từ key
        - Lấy index của từ ký tự message trong mảng mẫu
        - Lấy index so với bảng chữ cái chuẩn -> ký tự của decode mesage
     */



    /* 
        SOLUTION 1 

        n: key.length
        m: message.length

        Time:   O(n + m)
        Space:  O(26) ~ O(1)

        
    */
    public String decodeMessage(String key, String message) {
        
        Map<Character, Integer> map = new HashMap<>(); // key: character - value: index in key
        int i = 0;
        for(char k : key.toCharArray()) {
            if(k != ' ' && !map.containsKey(k)) {
                map.put(k, i);
                i++;
                continue;
            }
        }

        StringBuilder res = new StringBuilder();
        for(int j = 0; j < message.length(); j++) {
            if(message.charAt(j) == ' ') {
                res.append(" ");
            } else {
                // Lấy index trong háhmap
                int idx = map.get(message.charAt(j));
                // Từ index lấy chữ cái tương ứng trong bản chữ cái
                char c = (char) ('a' + idx);
                res.append(c);
            }
        }
        return res.toString();
    }


    /* 
        SOLUTION 2
        Tương tự như 1 nhưng cách code khác gọn hơn
    */
    public String decodeMessage_2(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char next = 'a';

        // Step 1: build mapping
        for (char c : key.toCharArray()) {
            if (c != ' ' && !map.containsKey(c)) {
                map.put(c, next);
                next++;
            }
        }

        // Step 2: decode message
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append(map.get(c));
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        
    }
}
