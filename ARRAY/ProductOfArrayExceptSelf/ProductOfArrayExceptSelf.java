
public class ProductOfArrayExceptSelf {

    /*
        Time: O(n)
        Space: O(n)

        pre     1   2   6   24

        suf     24  24  12  4

        res[i] = suffix[i + 1] * prefix[i - 1]
    */

    public int[] productExceptSelf(int[] nums) {      
        int n = nums.length;

        // Caculate prefix
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        // Caculate suffix
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }

        // result
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int pre = (i == 0) ? 1 : prefix[i - 1];
            int suf = (i == n - 1) ? 1 : suffix[i + 1];
            res[i] = pre * suf;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
