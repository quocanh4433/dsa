import java.util.HashMap;
import java.util.Map;

class ReorganizeString {

    /*
        time O(n)
        space O(n)
     */
    public String reorganizeString(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        int n = s.length();

        // Step 1: Đếm tần suất các ký tự bằng HashMap
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        int maxFreq = 0;
        char charWithMaxFreq = ' ';

        // Step 2: Tìm ký tự xuất hiện nhiều nhất
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                charWithMaxFreq = entry.getKey();
            }
        }


        /*
            kiểm tra có thể sắp xếp với maxFreq
            - maxFreq <= (n + 1)/2  : có thể sắp xếp
            - maxFreq > (n + 1)/2   : không thể sắp xếp
 
            
            tại sao lại là (n + 1)/2?

            vd: "aaab" - maxFreq = 3 

            a _ a _ a

            số vị trí trống giứa các char 'a': maxFreq - 1 = 2 

            mà số vị trí trống cộng với maxFreq không thể vượt qua n nên: 

            (maxFreq - 1) + maxFreq <= n

            maxFreq <= (n + 1) / 2
         */
        if (maxFreq > (n + 1) / 2) {
            return "";
        }

        char[] result = new char[n];
        int idx = 0;

        // Step 3: Đặt ký tự xuất hiện nhiều nhất vào các chỉ số chẵn trước
        while (charFreq.get(charWithMaxFreq) > 0) {
            result[idx] = charWithMaxFreq;
            idx += 2;
            charFreq.put(charWithMaxFreq, charFreq.get(charWithMaxFreq) - 1);
        }

        // Step 4: Đặt nốt các ký tự còn lại
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            while (count > 0) {
                // Nếu chỉ số chẵn vượt quá độ dài chuỗi, chuyển sang chỉ số lẻ (bắt đầu từ 1)
                if (idx >= n) {
                    idx = 1;
                }

                result[idx] = c;
                idx += 2;
                count--;

            }
        }

        return new String(result);

    }
}
