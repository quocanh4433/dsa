
import java.util.Arrays;

class Solution {

    /*
        time: O(n**2)
        space: O(n)

        TLE ❌
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) { // nếu width bằng thì sắp theo height tăng
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            maxCount = Math.max(maxCount, dp[i]);
        }

        return maxCount;
    }
}
