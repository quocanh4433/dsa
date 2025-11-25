package STRING.LongestPalindromicSubstring;

public class LongestPalindromicSubstring {

    /**
     * 
     * Time complexity: O(n^2)
     * 
     * Space complexity: O(1)
     * 
     * @param s
     * @return
     */

    public String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String s1 = expandAroundCenter(s, i, i);
            String s2 = expandAroundCenter(s, i, i + 1);

            String longer = s1.length() > s2.length() ? s1 : s2;

            if (longer.length() > res.length()) {
                res = longer;
            }
        }
        return res;
    }

    public String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    public static void main(String[] args) {
        
    }
}
