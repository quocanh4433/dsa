
class Solution {
    /*
        time O(n**2)
        space O(n)
    */

    private int[][] books;
    private int shelfWidth;
    private int n;
    private Integer[] memo;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shelfWidth = shelfWidth;
        this.n = books.length;
        this.memo = new Integer[n];
        return dfs(0);
    }

    public int dfs(int i) {
        // base case
        if (i == n) {
            return 0;
        }

        // memo
        if (memo[i] != null) {
            return memo[i];
        }

        // độ rộng khi đặt nhiều sách lên cùng 1 kệ
        int width = 0;
        // chiều cao kệ
        int height = 0;
        int res = Integer.MAX_VALUE;

        // thêm từng quyển lên kệ
        for (int j = i; j < n; j++) {
            width += books[j][0];

            if (width > shelfWidth) {
                break;
            }

            height = Math.max(height, books[j][1]);

            res = Math.min(res, height + dfs(j + 1));
        }

        memo[i] = res;
        return res;
    }

    public static void main(String[] args) {

    }
}
