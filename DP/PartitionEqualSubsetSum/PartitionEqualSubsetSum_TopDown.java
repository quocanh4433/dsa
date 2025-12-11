public class PartitionEqualSubsetSum_TopDown {
    private int[] nums;

    /*
    RECURSION
    
    Time -> O(2^n)
    Space -> O(n)

    BỊ LỖI TLE
    
    */

    public boolean canPartition_TLE(int[] nums) {
        this.nums = nums;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return dfs_TLE(0, sum / 2);
    }

    public boolean dfs_TLE(int i, int target) {
        if (target == 0) {
            return true;
        }

        if (i == nums.length || target < 0) {
            return false;
        }

        boolean take = dfs_TLE(i + 1, target - nums[i]);
        boolean skip = dfs_TLE(i + 1, target);

        return take || skip;
    }


    /*
    OPTIMIZE WITH MEMORIZATION

    Time -> O(n * target)
    Space -> O(n * target)
    
    
    */
    Boolean[][] memo;

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new Boolean[n][sum / 2 + 1];

        // TẠI SAO memo = new Boolean[n][sum / 2 + 1];
        // Xem https://www.youtube.com/watch?v=s6FhG--P7z0&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=4

        return dfs(0, sum / 2);
    }

    public boolean dfs(int i, int target) {
        if (target == 0) {
            return true;
        }

        if (i == nums.length || target < 0) {
            return false;
        }

        if (memo[i][target] != null) {
            return memo[i][target];
        }

        boolean take = dfs(i + 1, target - nums[i]);
        boolean skip = dfs(i + 1, target);

        memo[i][target] = take || skip;

        return memo[i][target];
    }



    public static void main(String[] args) {
        
    }
}
