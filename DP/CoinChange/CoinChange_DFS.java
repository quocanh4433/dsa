
import java.util.HashMap;
import java.util.Map;

public class CoinChange_DFS {

    public static void main(String[] args) {

    }
}

class Solution {
    // private int[] coins;
    // private int amount;
    // private Map<Integer, Long> cache;
    // public int coinChange(int[] coins, int amount) {
    //     this.coins = coins;
    //     this.amount = amount;
    //     this.cache = new HashMap<>();
    //     long res = dfs(0);
    //     return res == Integer.MAX_VALUE ? -1 : (int) res;
    // }

    // public long dfs(int cur) {
    //     if(cur == amount) {
    //         return 0;
    //     }
    //     if (cur > amount) return Integer.MAX_VALUE; // vượt quá thì bỏ
    //     if(cache.containsKey(cur)) {
    //         return cache.get(cur);
    //     }
    //     long minCoin = Integer.MAX_VALUE;
    //     for(int coin : coins) {
    //         if(cur + coin <= amount) {
    //             long next = dfs(cur + coin);
    //             if (next != Integer.MAX_VALUE) {
    //                 minCoin = Math.min(minCoin, 1 + next);
    //             }
    //             // minCoin = Math.min(minCoin, 1 + dfs(cur + coin));
    //         }
    //     }
    //     cache.put(cur, minCoin);
    //     return minCoin;
    // }
    private int[] coins;
    private int amount;
    private Map<Integer, Integer> memo;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;
        this.memo = new HashMap<>();

        int res = dfs(0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int cur) {
        if (cur == amount) {
            return 0;               // tạo đủ tiền → cần 0 xu

        }
        if (cur > amount) {
            return Integer.MAX_VALUE; // vượt quá → vô nghĩa
        }
        if (memo.containsKey(cur)) {
            return memo.get(cur);
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int sub = dfs(cur + coin);
            if (sub != Integer.MAX_VALUE) {
                min = Math.min(min, sub + 1);
            }
        }

        memo.put(cur, min);
        return min;
    }

    // private Map<Integer, Integer> memo;
    // private int[] coins;
    // public int coinChange(int[] coins, int amount) {
    //     this.coins = coins;
    //     memo = new HashMap<>();
    //     int res = dfs(amount);
    //     return res == Integer.MAX_VALUE ? -1 : res;
    // }
    // private int dfs(int remain) {
    //     if (remain == 0) return 0;
    //     if (remain < 0) return Integer.MAX_VALUE;
    //     if (memo.containsKey(remain)) return memo.get(remain);
    //     int min = Integer.MAX_VALUE;
    //     for (int coin : coins) {
    //         int sub = dfs(remain - coin);
    //         if (sub != Integer.MAX_VALUE) {
    //             min = Math.min(min, sub + 1);
    //         }
    //     }
    //     memo.put(remain, min);
    //     return min;
    // }
    // private Map<Integer, Integer> memo;
    // private int[] coins;
    // public int coinChange(int[] coins, int amount) {
    //     Arrays.sort(coins);
    //     this.coins = coins;
    //     memo = new HashMap<>();
    //     int res = dfs(amount);
    //     return res == Integer.MAX_VALUE ? -1 : res;
    // }
    // private int dfs(int remain) {
    //     // Base cases
    //     if (remain == 0) return 0;
    //     if (remain < 0) return Integer.MAX_VALUE;
    //     if (memo.containsKey(remain)) return memo.get(remain);
    //     int min = Integer.MAX_VALUE;
    //     // Try using the largest coins first (pruning)
    //     for (int i = coins.length - 1; i >= 0; i--) {
    //         int coin = coins[i];
    //         if (coin > remain) continue;
    //         int sub = dfs(remain - coin);
    //         if (sub != Integer.MAX_VALUE) {
    //             min = Math.min(min, sub + 1);
    //         }
    //     }
    //     memo.put(remain, min);
    //     return min;
    // }
}
