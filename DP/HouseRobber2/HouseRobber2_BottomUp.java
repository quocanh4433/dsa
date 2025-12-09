import java.util.Arrays;

public class HouseRobber2_BottomUp {
    /*
    Time -> O(n)

    Space -> O(1)
    
    
    */


    public int rob(int[] nums) {
        int n = nums.length;
        int[] firstArr = Arrays.copyOfRange(nums, 0, n - 1);
        int[] lastArr = Arrays.copyOfRange(nums, 1, n);
        return Math.max(nums[0] , Math.max(helper(firstArr), helper(lastArr)));

        // ✅ Tại sao lại kiểm tra nums[0]?
        // Cho TH chỉ có 1 phân tử  --- nums = [1]
    }

    public int helper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for(int n : nums) {
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    public static void main(String[] args) {
        
    }
}
