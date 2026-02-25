
import java.util.Arrays;

class Solution {

    /*
        time: O(n**2)
        space: O(n)

        TLE ❌
    */

    private int[] memo;
    private int[][] env;
    private int n;

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) { // nếu width bằng thì sắp theo height tăng
                return b[1] - a[1];
            }

            return a[0] - b[0];
        });

        this.n = envelopes.length;
        this.memo = new int[n];
        this.env = envelopes;

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            // với i là phong bị nhỏ nhất - thì có bao nhiêu phong bì lớn hơn bọc bên ngoài
            int count = dfs(i);
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private int dfs(int i) {
        if (memo[i] != 0) {
            return memo[i];
        }

        int best = 1; // chính là env[i]

        for (int j = i + 1; j < n; j++) {
            if (env[j][1] > env[i][1]) {
                best = Math.max(best, 1 + dfs(j));
            }
        }

        memo[i] = best;
        return best;
    }
}
