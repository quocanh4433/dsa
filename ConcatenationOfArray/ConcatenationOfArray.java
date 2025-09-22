
import java.util.Arrays;

public class ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        if (nums == null)
            return new int[0];

        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[n + i] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 22, 21, 20, 1 };
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }
}
