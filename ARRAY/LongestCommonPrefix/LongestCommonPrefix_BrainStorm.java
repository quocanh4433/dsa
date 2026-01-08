public class LongestCommonPrefix_BrainStorm {

    /* TỰ LÀM CHƯA TỐT LẮM*/
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0]; // flower
        int k = prefix.length(); // 6

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];

            if (s.length() == 0) {
                return "";
            }

            for (int j = 0; j < s.length(); j++) {

                if (j < k && prefix.charAt(j) != s.charAt(j)) {
                    k = j;
                    continue;
                }

                if (j < k && j == s.length() - 1) {
                    k = j + 1;
                }
            }
        }

        return prefix.substring(0, k);
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs));
    }
}
