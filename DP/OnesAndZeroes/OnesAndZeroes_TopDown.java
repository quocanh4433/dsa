public class OnesAndZeroes_TopDown {
    /*
        time O(m * n * N)
        space O(m * n * N)
    */

    private int[][] arr; // lưu tổng số 1 và 0 ở mỗi str con
    private Integer[][][] memo;

    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        this.arr = new int[N][2];
        this.memo = new Integer[N][m + 1][n + 1];

        // đếm số lương 1 và 0 ở tương chuỗi con
        for (int i = 0; i < N; i++) {
            for (char c : strs[i].toCharArray()) {
                arr[i][c - '0']++;
            }
        }

        // bắt đầu với str con đầu tiên
        return dfs(0, m, n);
    }

    public int dfs(int i, int m, int n) {
        // base case: không còn chuỗi -> 0 cách chọn
        if (i == arr.length) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 0;
        }

        if (memo[i][m][n] != null) {
            return memo[i][m][n];
        }

        // có 2 lựa chon là bỏ qua hoặc chọn
        // 1. bỏ qua thi tăng i lên
        int skip = dfs(i + 1, m, n);
        // 2. chọn thì kiểm tra điều kiện
        int take = 0;
        if (arr[i][0] <= m && arr[i][1] <= n) {
            take = 1 + dfs(i + 1, m - arr[i][0], n - arr[i][1]);
        }

        memo[i][m][n] = Math.max(skip, take);
        return memo[i][m][n];
    }

    public static void main(String[] args) {
        
    }
}
