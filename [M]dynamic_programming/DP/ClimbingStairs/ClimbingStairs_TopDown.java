
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_TopDown {
    /*
        time O(n)
        space O(n)

        để đến bậc n chỉ có 2 cách đi từ n-1 (bước 1 bước) và đi từ n-2 (bước 2 bước) 
        F(n) = F(n-1) + F(n-2)

        topdown nên xuất phát từ bậc n
     */
    static Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        int res = climbStairs(n-1) + climbStairs(n-2);
        memo.put(n, res);
        return res;
    }


    /*
        time O(n)
        space O(n)
    */
    static int[] cache;
    public static int climbStairs_2(int n) {
        cache = new int[n+1];
        return dfs(n);
    }

    public static int dfs(int n) {
        //base case
        if(n == 1) return 1;
        if(n == 2) return 2; 
        
        if(cache[n] != 0) {
            return cache[n];
        }

        cache[n] = dfs(n-1) + dfs(n-2);
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs_2(3)); // 3
        System.out.println(climbStairs_2(4)); // 5
    }
}
