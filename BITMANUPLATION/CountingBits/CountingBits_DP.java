public class CountingBits_DP
    /*
        SOLUTION 2: Dynamic Programming

        Time: O(n)
        Space: O(n)
    */


    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                res[i]++;
                num &= (num - 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}
