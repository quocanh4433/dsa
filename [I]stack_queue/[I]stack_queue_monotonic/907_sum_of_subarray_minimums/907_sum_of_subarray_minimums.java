import java.util.ArrayDeque;
import java.util.Deque;

class SumOfSubarryMinimuns {
    /*
     * nếu tại nums[i] nhỏ hơn peek() của stack tức đã tìm được minimun khác nên kết
     * lại đóng góp trong stack
     * 
     * time O(n)
     * space O(n)
     */

    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long res = 0;
        int MOD = 1_000_000_007;

        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int idx = stack.pop();

                int leftBound = stack.peek(); // vị trị chặn bên trái
                int rightBound = i; // vị trí chặn bên phải

                int leftChoice = idx - leftBound;
                int rightChoice = rightBound - idx;

                long contriution = (long) leftChoice * rightChoice * nums[idx];
                res = (res + contriution) % MOD;
            }

            stack.push(i);

        }

        return (int) res;
    }
}