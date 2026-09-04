import java.util.HashMap;
import java.util.Map;

public class PerfectSquares_TopDown {
    /*
        time O(n * sqrt(n))
            for: với n = 10 -> chạy 3 lần (1, 2 ,3) gần băng sqrt(10)
        space O(n)
            memo[n]
    */
    private Map<Integer, Integer> memo; // key: target - value: result of dfs(target)
    public int numSquares(int n) {
        memo = new HashMap<>();
        return dfs(n);
    }

    public int dfs(int n) {
        if(n == 0) {
            return 0;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        int res = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++) { 
            // 👉 time ~O(sqrt(n)) - VD: n = 10 -> chạy 3 lần (1, 2 ,3) gần băng sqrt(10)
            //👉 điều kiện đúng: i * i nhỏ hơn or bằng n
            int square = i * i;
            res = Math.min(res, dfs(n - square) + 1);
        }

        memo.put(n, res);
        return res;
    }
    public static void main(String[] args) {
        
    }
}
