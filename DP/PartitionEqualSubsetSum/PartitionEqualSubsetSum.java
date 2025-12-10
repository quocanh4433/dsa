public class PartitionEqualSubsetSum {
    /*
    RECURSION
    
    Time -> O(2^n)
    Space -> O(n)
    
    */
    private int[] nums;

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return dfs(0, sum / 2);
    }

    public boolean dfs(int i, int target) {
        if (target == 0) {
            return true;
        }

        if (i == nums.length || target < 0) {
            return false;
        }

        boolean take = dfs(i + 1, target - nums[i]);
        boolean skip = dfs(i + 1, target);

        return take || skip;
    }



    public static void main(String[] args) {
        
    }
}
