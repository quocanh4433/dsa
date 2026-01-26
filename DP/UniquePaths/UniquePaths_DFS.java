
import java.util.Arrays;


public class UniquePaths_DFS {
    /*
        SOLUTION 1: RECURSION

        TIME LIMIT EXCEEDED

        Time: O(2 ^ (m * n))
        Space: O(m * n)
    
    */


    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }

    public int dfs(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        // Có 2 lựa chọn bottom và right;
        int right = dfs(i, j + 1, m, n);
        int bottom = dfs(i + 1, j, m, n);
        return right + bottom;
    }



    /*
        SOLUTION 2: RECURSION + MEMORIZATION
        Time: O(m * n)
        Space: O(m * n)
    
     */

    public int uniquePaths_2(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dfs_2(0, 0, m, n, memo);
    }

    public int dfs_2(int i, int j, int m, int n, int[][] memo) {
        if (i == m - 1 || j == n - 1) { 
            // i == m - 1 && j == n - 1 vẫn đúng
            // TAI SAO CO DIEU KIEN NAY?
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        // Có 2 lựa chọn bottom và right;
        int right = dfs_2(i, j + 1, m, n, memo);
        int bottom = dfs_2(i + 1, j, m, n, memo);
        return memo[i][j] = right + bottom;
    }

    public static void main(String[] args) {

    }
}
