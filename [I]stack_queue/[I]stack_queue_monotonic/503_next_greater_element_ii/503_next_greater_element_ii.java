import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class NextGreaterElementII {
    /*
        Mỗi phần tử đang chờ tìm một số lớn hơn nó ở phía bên phải. 
        Nếu chưa tìm thấy thì giữ nó trong Deque. 
        Khi gặp một số lớn hơn, nó giải quyết được tất cả phần tử nhỏ hơn đang nằm cuối Deque.

        time O(n)
        space O(n)
     */
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        if(nums.length == 1) return new int[]{-1};

        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Deque<Integer> deque = new ArrayDeque<>(); // deque lưu index

        for(int i = 0; i < 2*n; i++) {

            int current = nums[i % n];

            while(!deque.isEmpty() && current > nums[deque.peekLast()]) {
                res[deque.pollLast()] = current;
            }

            if(i < n) {
                deque.offerLast(i);
            }
        }

        return res;
    }
}
