
import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
        time: O(n)
        space: O(n)
    */
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < n; i += k) {
            String sub;
            if (i + k <= n) {
                sub = s.substring(i, i + k);
            } else {
                sub = s.substring(i);
                int remain = k - sub.length();
                for (int j = 1; j <= remain; j++) {
                    sub += fill;
                }
            }
            res.add(sub);
        }

        return res.toArray(new String[res.size()]);
    }
}
