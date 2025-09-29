
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    /**
     * Time complexity: O(n)
     *
     *
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> need = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        int matches = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (need.containsKey(c)) {
                need.put(c, need.get(c) - 1);
                if (need.get(c) == 0) {
                    matches++;
                }
            }

            right++;

            while (right - left > s1.length()) {
                char charLeft = s2.charAt(left);
                if (need.containsKey(charLeft)) {
                    if (need.get(charLeft) == 0) {
                        matches--;
                    }
                    need.put(charLeft, need.get(charLeft) + 1);
                }
                left++;
            }

            // Nếu cửa sổ > s1.length() → thu nhỏ bên trái
            if (matches == need.size()) { // Tai sao khong dung s1.length
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        String s1_2 = "ab", s2_2 = "eidboaoo";
        String s1_3 = "ab", s2_3 = "ba";
        String s1_4 = "ab", s2_4 = "acba";
        System.out.println(checkInclusion(s1, s2));  // true
        System.out.println(checkInclusion(s1_2, s2_2)); // false
        System.out.println(checkInclusion(s1_3, s2_3)); // true
        System.out.println(checkInclusion(s1_4, s2_4)); // true

        // FAIL at testcase 
        String s15 = "abcdxabcde";
        String s25 = "abcdeabcdx";
        System.out.println(checkInclusion(s15, s25)); // true

    }
}
