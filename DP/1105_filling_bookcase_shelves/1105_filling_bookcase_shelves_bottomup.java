
class Solution {
    /*
        time O(n**2)
        space O(n)
    */
   
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // chiều cao đề xếp i quyển sách đầu tiên
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int width = 0;
            int height = 0;
            dp[i] = Integer.MAX_VALUE;

            // kệ cuối cùng chứa sách j..i
            for (int j = i; j >= 0; j--) {
                width += books[j][0];
                if (width > shelfWidth) {
                    break;
                }

                height = Math.max(height, books[j][1]);
                dp[i] = Math.min(dp[i], (j == 0 ? 0 : dp[j - 1]) + height);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
    }
}
