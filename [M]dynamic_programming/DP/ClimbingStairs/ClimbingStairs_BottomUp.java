
public class ClimbingStairs_BottomUp {

    /*
        time O(n)
        space O(n)

        TƯ DUY:
        
        để đến bậc n chỉ có 2 cách đi từ n-1 (bước 1 bước) và đi từ n-2 (bước 2 bước) 
        F(n) = F(n-1) + F(n-2)

        bottomup nên xuất phát từ bậc 0

        từ 0 lên bậc 1 có 1 cách -> dp[1] = 1
        tư 0 lên bậc 2 có 2 cách -> dp[2] = 2
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1]; // dp[i]: số cách để tới bậc thứ i
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /*
        time O(n)
        space O(1)
        bottom-up optimize space
     */
    public int climbStairs_2(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int prevPrev = 1;
        int prev = 2;

        for(int i = 3; i <= n; i++) {
            int curr = prev + prevPrev;
            int temp = prev;
            prev = curr;
            prevPrev = temp;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
