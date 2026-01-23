import java.util.Arrays;

public class LongestPalindromicSubsequence_BottomUp_OptimizeSpace {

    /*
        time O(n**2)
            - có n*n state trong bảng memo

        space O(n)
            - dp[n]: O(n**2)

        🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
        XEM LAI
        🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥
    */

    public int longestPalindromeSubseq(String s) {
       int n = s.length();
       int[] dp = new int[n];
        
       // base case
       Arrays.fill(dp, 1);

       for(int i = n - 1; i >= 0; i++) {
            int prev = 0; // dp[i+1][j-1]
            for(int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if(s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
       }

       return dp[n-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence_BottomUp_OptimizeSpace LPS = new LongestPalindromicSubsequence_BottomUp_OptimizeSpace();
        System.out.println(LPS.longestPalindromeSubseq("bbbab"));
    }
}
