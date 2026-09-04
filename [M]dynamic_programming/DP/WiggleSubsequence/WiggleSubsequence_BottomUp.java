import java.util.Arrays;

public class WiggleSubsequence_BottomUp {
    /*
        time O(n**2)
        space O(n)
    */
   public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] up = new int[n];
        int[] down = new int[n];

        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    up[i] = Math.max(down[j] + 1, up[i]);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(up[j] + 1, down[i]);
                }
            }
        }

        int res = 1;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(down[n - 1], up[n - 1]));
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}
