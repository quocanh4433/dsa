public class MaximumProductSubarray_BottomUp {
    /*
        Vì sao không dùng top-down?
        -  không chia nhiều nhánh lựa chọn
        -  không có subproblem gọi nhiều lần

        Similar Leetcode 53. Maximun Subarray

        Ý tưởng
        Khi nhân số, số âm có thể đảo ngược kết quả → phải theo dõi đồng thời tích LỚN NHẤT và NHỎ NHẤT kết thúc tại mỗi vị trí.

        time O(n)
        space O(n)
    */
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int[] maxDP = new int[n];
        int[] minDP = new int[n];

        // tại i = 0 chỉ có tích của nums[0]
        maxDP[0] = nums[0];
        minDP[0] = nums[0];

        int res = nums[0];

        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            maxDP[i] = Math.max(cur, Math.max(cur * maxDP[i - 1], cur * minDP[i - 1]));
            minDP[i] = Math.min(cur, Math.min(cur * maxDP[i - 1], cur * minDP[i - 1]));
            res = Math.max(res, maxDP[i]);
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}
