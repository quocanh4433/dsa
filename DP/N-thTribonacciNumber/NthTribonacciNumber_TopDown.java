
public class NthTribonacciNumber_TopDown {
    /*
        time O(n)
        space O(n)
    
    */
    Integer[] memo;

    public int tribonacci(int n) {
        memo = new Integer[n + 1];
        return dfs(n);
    }

    public int dfs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = dfs(n - 1) + dfs(n - 2) + dfs(n - 3);
        return memo[n];
    }

    public static void main(String[] args) {

    }
}
