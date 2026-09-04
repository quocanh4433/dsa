import java.util.HashMap;
import java.util.Map;

public class CoinChange_DFSRuntimeError {
    /*
    ⚠️ NGUYÊN NHÂN RUMTIME ERROR
    
    
    */

    /*
    💡 IDEA:
    Xuất phát từ remain = 0 cho đến khi bằng amount
    
    
    */

    private int[] coins;
    private int amount;
    private Map<Integer, Integer> memo;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0; // không có cách nào để chọn
        }
        this.coins = coins;
        this.amount = amount;
        this.memo = new HashMap<>();

        int res = dfs(0); // đi từ 0 đến khi gặp amount
        return res == Integer.MAX_VALUE || res == Integer.MIN_VALUE ? -1 : res;
    }

    public int dfs(int remain) {
        if (remain == amount) {
            return 0;
        }

        if (memo.containsKey(remain)) {
            return memo.get(remain);
        }

        int minCoin = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (remain + coin >= 0 || remain + coin <= amount) { 
                // Tại sao kiêm tra remain + coin >= 0
                // TH: remain = 1 và coin = 2147483647 (MAX_INTEGER)
                // remain + coin = -2147483648
                // Khi cộng thêm số vào max_integer sẽ quay về âm min_integer
                minCoin = Math.min(minCoin, 1 + dfs(remain + coin));
            }
        }

        memo.put(remain, minCoin);
        return minCoin;
    }


    public static void main(String[] args) {
        
    }
}
