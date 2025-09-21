
public class ValidAnagram {
    /**
     * Given two strings s and t, return true if t is an anagram of s, and false
     * otherwise.
     * 
     * Example 1:
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * 
     * Example 2:
     * Input: s = "rat", t = "car"
     * Output: false
     * 
     * 
     * Constraints:
     * 1 <= s.length, t.length <= 5 * 104
     * s and t consist of lowercase English letters.
     */

    public static boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        for (int i : count) {
            if (i != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
