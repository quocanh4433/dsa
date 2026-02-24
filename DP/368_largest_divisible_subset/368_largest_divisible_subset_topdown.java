
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
        time: O(n**2)
        space: O(n)
    */

    int[] nums;
    int[] memo;
    int[] next;
    int n;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        /*
            Tại sao cần sort?

            yêu cầu bài toán a % b HOẶC b % a. "HOẶC" nên chỉ cần thỏa 1 trong 2 điều kiện

            MÀ quan hệ 2 chiều khó kiểm soát

            NÊN sort, để chỉ xét điều kiện b % a == 0, quan hê 1 chiều dễ kiểm soát 
         */

        Arrays.sort(this.nums);

        this.next = new int[n];
        this.memo = new int[n];
        Arrays.fill(next, -1);
        Arrays.fill(memo, -1);

        int maxLen = 0;
        int start = 0; // là điểm bắt đầu của chuỗi chia hết dài nhất.

        for (int i = 0; i < n; i++) {
            // tại mọi nums[i] tìm xem có bao nhiêu số kết nối với nums[i]
            int len = dfs(i);

            if (len > maxLen) {
                maxLen = len;
                start = i; // cập nhật điểm bắt đầu mới
            }
        }

        List<Integer> res = new ArrayList<>();
        while (start != -1) {
            res.add(nums[start]); // thêm nums tại điểm bắt đầu
            start = next[start]; // cập nhật index tiếp theo
        }

        return res;
    }

    public int dfs(int i) { // dfs(i): bắt đầu ở nums[i] thì lấy được bao nhiêu số tiếp theo
        if (memo[i] != -1) {
            return memo[i];
        }

        int best = 1; // chính nums[i]

        for (int j = i + 1; j < n; j++) {
            if (nums[j] % nums[i] == 0) {
                int candidate = 1 + dfs(j);
                if (candidate > best) {
                    best = candidate;
                    /*
                        next[i] = indexValue i: index trong nums indexValue:
                        index tiếp theo thỏa điều kiện
                     */
                    next[i] = j;
                }
            }
        }

        memo[i] = best;
        return best;
    }
}
