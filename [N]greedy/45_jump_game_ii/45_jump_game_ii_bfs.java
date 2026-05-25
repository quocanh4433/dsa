import java.util.LinkedList;
import java.util.Queue;

class JumpGameII_BFS {
    /*
        time O(n**2)
        space O(n)
    
    */
    public int jump(int[] nums) {
        int n = nums.length;
        int res = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int s = 0; s < size; s++) {
                int cur_idx = q.poll();

                if (cur_idx == n - 1) {
                    return res; // tại sao đây là kết quả tối ưu?
                }

                // thêm các node có thể tới
                for (int next = cur_idx + 1; next <= cur_idx + nums[cur_idx] && next < n; next++) {
                    if (!visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    }
                }

            }

            res++;

        }

        return -1;
    }
}
