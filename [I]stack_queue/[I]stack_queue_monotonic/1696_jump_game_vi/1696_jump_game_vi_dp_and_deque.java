import java.util.ArrayDeque;
import java.util.Deque;

class JumpGameVI_DP_and_Deque {

    /*
        time O(n)
        space O(n)
     */

    public int maxResult(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        // deque chỉ lưu index
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);

        for(int i = 1; i < n; i++) {
            // 1. remove nếu vượt quá số bước
            // tại i ta nhin lại k bước trước đó
            // tại sao pollFirst() ?
            // do deque lưu index theo thư tự tăng dần index nên index đâu tiên hết hạn trước
            while(deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
                        
            // 2. tính dp[i]
            dp[i] = nums[i] + dp[deque.peekFirst()];

            // 3. giữ deque giảm dần 
            while(!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return dp[n- 1];
    }
}
