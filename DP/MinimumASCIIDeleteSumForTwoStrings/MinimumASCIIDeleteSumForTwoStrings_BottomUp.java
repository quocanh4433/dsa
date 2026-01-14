
public class MinimumASCIIDeleteSumForTwoStrings_BottomUp {

    /*
        ĐỂ HIỂU BÀI NÀY TỐT HƠN CẦN XEM LẠI BÀI 

        Longest common subsequence


        DẠNG DP 2D Bottom-Up Dynamic Programming (DP bảng)
        🔍 Cách triển khai mảng dp[][]
            https://www.youtube.com/watch?v=I6B-tRWvuSE
       


        HIỂU ĐỀ:
        Cho 2 string s1 và s2. Xóa ký tự ở cả 2 string chúng giống nhau, nhưng chi phí thấp nhất.
        Chi phí là value ASCII của ký tự bị xóa.

        ✅Thay vì tập trung xóa hãy giữa được nhiều ký tự nhất

        Lúc này bài toán chuyển sang Longest common subsequnces

     */
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        /*    
            Tại sao mảng dp là n + 1 và m + 1 thay vì n và m ?
            👉 dp là (n+1)x(m+1) để biểu diễn chuỗi rỗng
            👉 Tư duy chuẩn (length-based)


                    s       e       a       ∅
                e   0       0       0       0
                a   0       0       0       0
                t   0       101     101     101
                ∅   0       101     198     198
         */
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char si1 = s1.charAt(i);
                char s2j = s2.charAt(j);
                if (si1 == s2j) {
                    dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
                } else {
                    // 👉 bắt buộc bỏ 1 trong 2, và chọn phương án giữ được nhiều ASCII nhất
                    // bỏ s1[i] giữ s2[j]
                    int delete_s1 = dp[i][j + 1];
                    // ngược lại
                    int delete_s2j = dp[i + 1][j];
                    // dp[i + 1][j + 1] = Math.max(delete_s1, delete_s2j);
                    dp[i + 1][j + 1] = Math.max(delete_s1, delete_s2j);
                }
            }
        }

        int total = 0;
        for (char c : s1.toCharArray()) {
            total += c;
        }
        for (char c : s2.toCharArray()) {
            total += c;
        }

        return total - 2 * dp[n][m];
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteSumForTwoStrings_BottomUp Minimum = new MinimumASCIIDeleteSumForTwoStrings_BottomUp();
        System.out.println(Minimum.minimumDeleteSum("sea", "eat"));
    }
}
