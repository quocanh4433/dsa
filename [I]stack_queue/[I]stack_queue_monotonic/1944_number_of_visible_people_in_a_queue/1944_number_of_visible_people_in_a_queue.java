import java.util.ArrayDeque;
import java.util.Deque;

class NumberOfVisiblePeopleInAQueue {
    /*
        time O(n)
        space O(n)
     */
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                ans[stack.pop()]++;
            }

            if (!stack.isEmpty()) {
                ans[stack.peek()]++;
            }

            stack.push(i);
        }

        return ans;

    }
}
