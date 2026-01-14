package DP.LongestCommonSubsequence;

public class LongestCommonSubsequence_BottomUp {

    /*
        Time: O(m * n)
        Space: O(m * n)

        https://www.youtube.com/watch?v=7uQ1Lehw7_k


        dp[][] với "abcde" và "ace":

                a   c   e   ∅
        a       ?   ?   ?   0
        b       ?   ?   ?   0
        c       ?   ?   ?   0
        d       ?   ?   ?   0
        e       ?   ?   ?   0
        ∅       0   0   0   0
    
    */

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        /*
            Tại sao cần m + 1 và n + 1? 
            👉 Cần n + 1 và m + 1 để biểu diễn trường hợp “chuỗi rỗng”
        */



        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    /*
                        👉 Lấy 1 ký tự này vào LCS
                        👉 Cộng thêm LCS của phần còn lại
                    */
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        
    }
}
