
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    /*
     * Time compleixty: O(n)
     * 
     * Space complexity: O(n)
     * 
     */
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }

        if(memo.containsKey(n)) {
            return  memo.get(n);
        }

        int res = climbStairs(n-1) + climbStairs(n-2);
        memo.put(n, res);
        return res;
    }
    public static void main(String[] args) {
        System.out.println(3); // 3
        System.out.println(2); // 2
    }
}
