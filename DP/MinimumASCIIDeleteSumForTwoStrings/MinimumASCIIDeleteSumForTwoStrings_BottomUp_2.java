
public class MinimumASCIIDeleteSumForTwoStrings_BottomUp_2 {
    public int minimumDeleteSum(String s1, String s2) {
        /*    
                                    S2
                        ∅       e       a       t       
                ∅       0       0       0       0
                s       0       0       0       0
        S1      e       0       0       0       0
                a       0       0       0       0



                PHÂN TÍCH THEO HƯỚNG NÀY DỄ HIỂU HƠN
               
         */
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int sum1 = 0, sum2 = 0;
        for (char c : s1.toCharArray()) {
            sum1 += c;
        }
        for (char c : s2.toCharArray()) {
            sum2 += c;
        }

        /*
            res = chi phí xóa s1 + chi phí xóa s2
                = (sum1 - dp[n][m]) + (sum2 - dp[n][m])
                = sum1 + sum2 - 2*dp[n][m]
        */

        return sum1 + sum2 - 2 * dp[n][m];
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteSumForTwoStrings_BottomUp_2 Minimum = new MinimumASCIIDeleteSumForTwoStrings_BottomUp_2();
        System.out.println(Minimum.minimumDeleteSum("sea", "eat"));
    }
}
