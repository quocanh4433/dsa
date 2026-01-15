
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence_DPBinarySearch {
    /*
        Time: O(nlogn)
        Space: O(n)

        Prop
            - Tăng hiệu năng
        Cons    
            - Chỉ có độ dài - không biết được phần tử trong subsequeces 
    */

    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        // dp[i]: ở độ dài i + 1, số nhỏ nhất kết thúc là value của dp[i]
        dp.add(nums[0]);
        // mặc định ở độ dài 1 có nums[0] trong trường hợp nums.length = 1

        int LIS = 1;

        for(int i = 1; i < nums.length; i++) {
            int prev = dp.get(dp.size() - 1);
            if(prev < nums[i]) {
                // Thảo điều kiên tăng dần
                dp.add(nums[i]);
                // Tăng đồ dài subsequnce lên và next
                LIS++;
                continue;
            }

            // Nếu không thỏa điều kiện tăng dần
            // Tìm index đầu tiên của núm[i] trong dp
            int idx = Collections.binarySearch(dp, nums[i]);
            if(idx < 0) idx = -idx -1;
            dp.set(idx, nums[i]);
        }
        return LIS;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence_DPBinarySearch LIS = new LongestIncreasingSubsequence_DPBinarySearch();
        int[] nums = {1, 2, 4, 3};
        LIS.lengthOfLIS(nums);
    }
}
