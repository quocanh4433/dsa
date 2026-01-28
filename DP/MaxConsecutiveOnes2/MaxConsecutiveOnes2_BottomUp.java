public class MaxConsecutiveOnes2_BottomUp {
    /*
        Neetcode
        
        time O(n)
        space O(n)
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        
        int n = nums.length;
        /*
            dp1(i): chuỗi 1 liên tiếp kết thúc tại i - được flip 0;
            dp0(i): chuỗi 1 liên tiếp kết thúc tại i - không flip 0;
        
        */
        int[] dp1 = new int[n];
        int[] dp0 = new int[n];
        int res = 0;
        
        if(nums[0] == 1) {
            dp1[0] = 1;
            dp0[0] = 1;
        } else {
            dp1[0] = 1;
            dp0[0] = 0;
        }

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 1) {
                dp1[i] = dp1[i - 1] + 1;
                dp0[i] = dp0[i - 1] + 1;
            } else {
                dp1[i] = dp0[i - 1] + 1;
                dp0[i] = 0;
            }

            res = Math.max(res, dp1[i]);
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}
