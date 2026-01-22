public class LongestPalindromicSubsequence_BottomUp {

    /*
        time O(n**2)
            - có n*n state trong bảng memo

        space O(n**2)
            - memo[n][n]: O(n**2)
            - recursion: O(n)
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
        Integer[][] dp = new Integer[n][n]; //
        
        /*
            base case
            mỗi char là một palindrome -> add theo diagonal

                    a   b
            a       1   0   
            b       0   1           
        */
        for(int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        /*
            Tại sao phải duyêt từ cuối mảng mà không phải ngược lại?
            👉 cần tìm longest palindrome trong đoạn s[0..n-1]
            nên cần dp[0][n-1]
            
            👉
        
        */

        for(int i = 0)


        
        
        



        return dp[n][n];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence_BottomUp LPS = new LongestPalindromicSubsequence_BottomUp();
        System.out.println(LPS.longestPalindromeSubseq("bbbab"));
    }
}
