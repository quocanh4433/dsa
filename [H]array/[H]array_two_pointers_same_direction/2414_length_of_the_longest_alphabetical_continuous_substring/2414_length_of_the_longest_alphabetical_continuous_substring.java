
class LengthOfTheLongestAlphabeticalContinuousSubstring {
    /*
        time O(n)
        space O(1)
    */
    public int longestContinuousSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int max = 0;
        int current = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                current++;
            } else {
                current = 1;
            }

            max = Math.max(max, current);
        }

        return max;
    }
}
