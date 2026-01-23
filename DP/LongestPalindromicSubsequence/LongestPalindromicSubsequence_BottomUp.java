public class LongestPalindromicSubsequence_BottomUp {

    /*
        time O(n**2)
            - có n*n state trong bảng memo

        space O(n**2)
            - memo[n][n]: O(n**2)
    */

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        /*
            dp[l][r]: đội dài longest palindrome trong đoạn s[l..r]
            tại sao không chon dp[n+1][n+1]
            👉 dp không đại diện cho chiều dài 
            👉mà đại diện cho đoạn trong chuỗi
        */
        int[][] dp = new int[n][n]; //
        
        /*
            base case
            mỗi char là một palindrome -> add theo diagonal
                    a   b
            a       1   ?   
            b           1 
        */
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        /*
            Tại sao phải duyêt từ cuối mảng mà không phải ngược lại?
            👉 dp duyệt theo thứ tự phụ thuộc
                dp[0][n-1] phụ thuộc vào:
                - dp[1][n-2]        char l và r giống nhau  
                - dp[1][n-1]        cố định r thăng l
                - dp[0][n-2]        cố định l tăng r
        */
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                /*
                    Tại sao j = i + 1 ? -> vì dp[i][j] là độ dài s[i..j] nên j > i nhưng j < n
                    Tại sao j tăng nhưng i giảm dần?
                    
                    👉 Thứ tự duyệt bottom-up chính là mô phỏng stack đệ quy của top-down

                    👉TOPDOWN
                    dfs(0, 4)
                        ├─ dfs(1, 3)
                        │   ├─ dfs(2, 2)  ← base case
                        │   └─ dfs(2, 3)
                        └─ dfs(0, 3)

                   👉 BOTTOMUP
                    dp[2][2]
                    dp[2][3]
                    dp[1][3]
                    dp[0][3]
                    dp[0][4]
                */
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence_BottomUp LPS = new LongestPalindromicSubsequence_BottomUp();
        System.out.println(LPS.longestPalindromeSubseq("bbbab"));
    }
}
