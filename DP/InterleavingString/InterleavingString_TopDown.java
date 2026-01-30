
public class InterleavingString_TopDown {
    /*
        time O(n * m)
        space O(n * m)
    */
    private String s1, s2, s3;
    private Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0);
    }

    public boolean dfs(int i, int j) {
        // di den cuoi s1 va 2
        // 👉 tại sao đi đến cuối lại trả về tru ?
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int k = i + j;
        boolean res = false;

        // ở vị trí k có 2 hướng - ký tự giống s1 or giống s2
        // kiêm trs s3 với s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = dfs(i + 1, j);
        }

        // kiêm trs s3 với s2 (chỉ khi chưa co true)
        // thử lấy từ s2 (chỉ khi nhánh trên chưa true)
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = dfs(i, j + 1);
        }

        memo[i][j] = res;
        return res;

    }

    public static void main(String[] args) {

    }
}
