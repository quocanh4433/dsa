import java.util.HashMap;
import java.util.Map;

class LongestPalindrome {

    /*
        time O(n)
        space O(k) k: number of distinct character

        quy tắt: 
        - sô lần xuất hiện chẵn lấy hết
        - số lần xuất hiện lẻ sẽ trừ đi 1 đánh dâu lại 
     */

    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>(); 
        // có thể dùng mảng int[128] nếu string s chỉ chứa chữ cái hoa và thường 

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int longest = 0;
        boolean hasOdd = false;

        for (int f : freq.values()) {
            if (f % 2 == 0) {
                longest += f;
            } else {
                longest += f - 1;
                hasOdd = true;
            }
        }

        // hasOdd có số lần lẻ + 1 cho 1 kí tự ở giữa
        return hasOdd ? longest + 1 : longest;
    }
}
