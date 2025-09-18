import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithRepeatingCharacters {
    /**
     * Given a string s, find the length of the longest substring without duplicate
     * characters.
     * 
     * Example 1:
     * 
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * 
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * 
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a
     * substring.
     * 
     * 
     * Constraints:
     * 
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     * 
     * s = "pwwkew"
     * start = 0, end = 0
     * map {key: char, value: index}
     * 
     * while(end < s.lenght) {
     *   char = s[end]
     *    
     * 
     * }
     * 
     * return end - start
     */

    static int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() == 1) return 1;

        int res = 0, l = 0, r = 0;
        Map<Character, Integer> seen = new HashMap<>();

        while(r < s.length()) {
            char c = s.charAt(r);

            if(seen.containsKey(c) && seen.get(c) >= l) {
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
    

    public static void main(String[] args) {
        String s = "pwwkew";
        String s1 = "bbbbb";
        String s2 = "abcabcbb";
        /* NOTE: FAIL AT TESTCASE s3 */
        String s3 = "au";
        String s4 = "accna";
       
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
    }
}
