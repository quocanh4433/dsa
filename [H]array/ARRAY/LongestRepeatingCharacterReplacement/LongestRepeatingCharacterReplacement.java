public class LongestRepeatingCharacterReplacement {
    /**
     * 424. Longest Repeating Character Replacement
     * 
     * You are given a string s and an integer k. You can choose any character of
     * the string and change it to any other uppercase English character. You can
     * perform this operation at most k times.
     * 
     * Return the length of the longest substring containing the same letter you can
     * get after performing the above operations.
     * 
     * Example 1:
     * 
     * Input: s = "ABAB", k = 2
     * Output: 4
     * Explanation: Replace the two 'A's with two 'B's or vice versa.
     * Example 2:
     * 
     * Input: s = "AABABBA", k = 1
     * Output: 4
     * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
     * The substring "BBBB" has the longest repeating letters, which is 4.
     * There may exists other ways to achieve this answer too.
     * 
     * 
     * Constraints:
     * 
     * 1 <= s.length <= 105
     * s consists of only uppercase English letters.
     * 0 <= k <= s.length
     * 
     * l = 0
     * common = 0
     * res = 0
     * count[26] ={0,0...0}
     * 
     *  s = "AABABBA"
     * 
     * for r = 0: r++
     *      count[r]++
     *      max(common, courn++)
     *      
     * 
     * time complexity O(n)
     * space complexity O(1)
     */

    public static  int characterReplacement(String s, int k) {
        if(s == null) return 0;
        if(s.length() == 1) return 1;

        int l = 0, res = 0, common = 0;
        int[] count = new int[26];

        for(int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;
            common = Math.max(common, count[s.charAt(r) - 'A']);

            while ((r - l + 1) - common > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int k = 1;
        String s = "AABABBA";
        System.out.println(characterReplacement(s, k));

        int k2 = 2;
        String s2 = "ABAB";
        System.out.println(characterReplacement(s2, k2));

    }
}
