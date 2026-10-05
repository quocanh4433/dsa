import java.util.ArrayDeque;
import java.util.Deque;

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    /*
        tại sao cần absolute do không quan tâm a lơn hơn hay b lớn hơn chỉ quan tâm khoang cách giưa a và b
    
        chỉ cần min và max của 1 subarray <= limit thi chắc chắn absolute của bất kì phần từ bên trong luôn luôn <= limit 

        time O(n)
        space O(n)
     */

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>(); // lưu index không phải lưu value
        Deque<Integer> minDeque = new ArrayDeque<>(); // lưu index không phải lưu value

        int left = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            // 1. Update maxDeque
            // maxDeque lưu phần từ lớn nhất ở đầu
            // nếu phần từ hiện tại lớn hơn phân từ lớn nhất trong maxDeque thi pollL
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // 2. Update minDeque
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // 3. Nếu window invalid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            // 4. Window hiện tại valid
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
