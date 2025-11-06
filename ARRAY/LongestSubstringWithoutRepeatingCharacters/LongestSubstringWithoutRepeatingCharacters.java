
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int res = 0, l = 0, r = 0;
        Map<Character, Integer> seen = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);

            if (seen.containsKey(c) && seen.get(c) >= l) {
                l = seen.get(c) + 1;
            }

            res = Math.max(res, r - l + 1);
            seen.put(c, r);
            r++;

            /* WRONG CODE creates bug s3="au"  */
            // if(!seen.containsKey(c)) {
            //     seen.put(c, r);
            // } else {
            //     res = Math.max(res, r - l);
            //     l = seen.get(c) + 1;
            //     seen.put(c, r);
            // }
        }

        return res;
    }

    /* JUST REVISE THIS PROBLEM
     * 
     * Time complexity: O(n)
     * 
     * Space complexity: O(n)
     */
    public int lengthOfLongestSubstring_2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> seen = new HashMap<>();
        int i = 0;
        int res = 0;

        for (int k = 0; k < chars.length; k++) {
            char c = chars[k];

            // 🔥 NEEDED THE CONDITION: seen.get(c) >= i?
            if (seen.containsKey(c) && seen.get(c) >= i) {
                i = seen.get(c) + 1;
            }
            seen.put(c, k);
            res = Math.max(res, k - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        String s1 = "bbbbb";
        String s2 = "abcabcbb";
        /* FAIL AT TESTCASE s3 */
        String s3 = "au";
        String s4 = "accna";

        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
    }
}
