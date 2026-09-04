

public class LongestPalindromicSubsequence_TopDown {

    /*
        time O(n**2)
            - có n*n state trong bảng memo

        space O(n**2)
            - memo[n][n]: O(n**2)
            - recursion: O(n)
    */
    private Integer[][] memo;
    // memo(l, r) = độ dài Longest Palindromic Subsequence trong đoạn s[l..r]
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new Integer[n][n];
        return dfs(s, 0, n - 1);
    }

    public int dfs(String s, int l, int r) {
        // base case
        if(l > r) return 0;
        if(l == r) return 1;

        if(memo[l][r] != null) {
            return memo[l][r];
        }

        if(s.charAt(l) == s.charAt(r)) { // time O(n)
            memo[l][r] = 2 + dfs(s, l + 1, r - 1);
        } else {
            memo[l][r] = Math.max(dfs(s, l+1, r), dfs(s, l, r-1));
        }

        return memo[l][r];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence_TopDown LPS = new LongestPalindromicSubsequence_TopDown();
        System.out.println(LPS.longestPalindromeSubseq("bbbab"));
    }
}
