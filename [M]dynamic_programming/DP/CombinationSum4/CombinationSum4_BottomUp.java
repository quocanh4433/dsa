

public class CombinationSum4_BottomUp {
    /*
        time O(n * target)
        sppace O(target)

        n: len(nums)
    */
    public int combinationSum4(int[] nums, int target) {
        // combination sum 1: không quan tâm thứ tự
        // combination sum 4: theo thứ tự
        // dp(i): số cách tạo ra tổng i
        int[] dp = new int[target + 1];
        
        /*
            🎯 Quan trọng: Vì sao “không chọn gì” vẫn là 1 cách?
            Quá trình chọn có thể:
                - chọn 1 số 
                - chọn nhiều số
                - hoặc không chọn số nào
        */
        dp[0] = 1;

        for (int remain = 1; remain <= target; remain++) { // điều kiện đúng là <= target
            for (int num : nums) {
                if (remain - num >= 0) { // 
                    /*
                        dp[remain]: số cách tạo reamin
                        dp[remain - num]: số cách tạo remain - num

                        có thể tạo thêm cách từ remain với num

                        dp[remain] = dp[remain] + số cách dp của remain trước khi có num

                        dp[remain] += dp[reman - num]

                    */
                    dp[remain] += dp[remain - num];
                }
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {

    }
}
