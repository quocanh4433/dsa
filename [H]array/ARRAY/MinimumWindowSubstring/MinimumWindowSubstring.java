
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {


    /*
     * n: len(String s)
     * m:len(String t)
     * 
     * Time complexity: O(n)  nhưng có thể degrade thành O(n²) do substring
     * 
     * Space complexity: O(m) 
     * 
     * 
     * Tự code + test dựa trên ý tưởng của neetcode
     * 
     * 
     * 
     * 🔽⬇️ BETTER VERSION IS BELOW  ⬇️🔽

     * 
     */
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>(t.length());

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int have = 0;
        String result = "";

        while (l <= r && r < s.length()) {
            char currentChar = s.charAt(r);
            window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);

            if (need.containsKey(currentChar) && window.get(currentChar).equals(need.get(currentChar))) {
                have++;
                while (l <= r && have == need.size()) {
                    String substring = s.substring(l, r + 1);

                    if (result.isEmpty() || substring.length() < result.length()) {
                        result = substring;
                    }

                    char charLeft = s.charAt(l);
                    window.put(charLeft, window.get(charLeft) - 1);
                    if (need.containsKey(charLeft) && window.get(charLeft) < need.get(charLeft)) {
                        have--;
                    }

                    l++;
                }
            }

            r++;
        }

        return result;
    }


    /*
     * ▶️ BETTER VERSION 
     * 
     * Time complexity: O(n + m)
     * 
     * Space complexity: O(n + m)
     */
    public static String minWindow_Better(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needMap = new HashMap<>(t.length());

        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0;
        int have = 0;
        int need = needMap.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;

        while (l <= r && r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (needMap.containsKey(c) && window.get(c).equals(needMap.get(c))) {
                have++;
            }

            while (have == need) {
                // Không dùng substring như cách trên
                // cập nhật độ dài nhỏ nhất hiện tại
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char charLeft = s.charAt(l);
                window.put(charLeft, window.get(charLeft) - 1);
                if (needMap.containsKey(charLeft) && window.get(charLeft) < needMap.get(charLeft)) {
                    have--;
                }

                l++;
            }

            r++;
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a")); // expected: "a"
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // expected: "BANC"
        System.out.println(minWindow("x", "xy")); // expected: ""
        System.out.println(minWindow("OUZODYXAZV", "XYZ")); // expected: "YXAZ"
        System.out.println(minWindow("xyz", "xyz")); // expected: "xyz"
        /* FAIL THIS TESTCASE */
        System.out.println(minWindow("a", "aa")); // expected: ""
        System.out.println(minWindow("aa", "aa")); // expected: "aa"
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd")); // expected: "abbbbbcdd"

        System.out.println("________________________________________");

        System.out.println(minWindow_Better("a", "a")); // expected: "a"
        System.out.println(minWindow_Better("ADOBECODEBANC", "ABC")); // expected: "BANC"
        System.out.println(minWindow_Better("x", "xy")); // expected: ""
        System.out.println(minWindow_Better("OUZODYXAZV", "XYZ")); // expected: "YXAZ"
        System.out.println(minWindow_Better("xyz", "xyz")); // expected: "xyz"
        /* FAIL THIS TESTCASE */
        System.out.println(minWindow_Better("a", "aa")); // expected: ""
        System.out.println(minWindow_Better("aa", "aa")); // expected: "aa"
        System.out.println(minWindow_Better("aaaaaaaaaaaabbbbbcdd", "abcdd")); // expected: "abbbbbcdd"

    }
}
