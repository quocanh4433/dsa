
public class LastStoneWeight2_BottomUp_Optimize {

    /*
        thực chất là chia làm 2 nhóm đá A và B

        result = |sum(A) - sum(B)|

        time O(n * sum)
        space O(n * sum)
     */
    private int[] stones;
    private Integer[][] memo;

    public int lastStoneWeightII(int[] stones) {
        this.stones = stones;

        int maxSum = 0;
        for (int stone : stones) {
            maxSum += stone;
        }

        // diff nhận giá trị từ 0,... sum -> sum + 1
        this.memo = new Integer[stones.length][maxSum + 1];

        // bắt đầu với stone đầu tiên i = 0 - chưa mash nên diff = 0
        return dfs(0, 0);
    }

    /*
        i: đang đứng viên đá thứ i
        diff: kết quả của |sumA - sumB| xử lí từ 0 đến i - 1 viên đá

        dfs(i, diff): xét stone thứ i và kết quả diff từ 0 đến i - 1
     */
    public int dfs(int i, int diff) {
        // base case: dùng hết stone
        if (i == stones.length) {
            return diff;
        }

        if (memo[i][diff] != null) {
            return memo[i][diff];
        }

        int weight = stones[i];

        /*
            có 2 lựa chọn put vào A hoặc B

            khi put vào thì xử lí xong viên thứ i, nên đi đến viên tiếp theo i + 1
        */
        int putA = dfs(i + 1, diff + weight);
        int putB = dfs(i + 1, Math.abs(diff - weight));

        memo[i][diff] = Math.min(putA, putB);
        return memo[i][diff];
    }

    public static void main(String[] args) {

    }
}
