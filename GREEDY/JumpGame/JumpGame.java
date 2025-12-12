

public class JumpGame {
    /**
     * BACKWARD GREEDY
     * 
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        int goal = n - 1;

        // Kiểm tra ngược từ vị trí áp cuối
        // Xác đinh có vị trí nào nhay đến goal
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                // 👉 Từ vị trí i, có nhảy được tới goal không?
                // Nếu có cập nhật goal
                goal = i;
            }
        }

        return goal == 0;
    }


    
    public static void main(String[] args) {
        
    }
}
