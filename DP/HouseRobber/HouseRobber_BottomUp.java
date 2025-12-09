
public class HouseRobber_BottomUp {

    /*
    Time -> O(n)
    Space -> O(n)
    */
   
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for(int i = nums.length; i >= 0; i--) {
            int skip = dp[i + 1];
            int rob = nums[i] + dp[i + 2];
            dp[i] = Math.max(skip, rob);
        }
        return dp[0];
    }


    /*
    OPTIMIZE SPACE

    Time -> O(n)
    Space -> O(1)
    */

    public int rob_2(int[] nums) {
        int rob1 = 0; 
        int rob2 = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int skip = rob1;
            int rob = nums[i] + rob2;

            rob2 = rob1; // rob2 luôn nhận giá trị của rob1 trước khi thay đổi
            rob1 = Math.max(skip, rob);
        }

        return rob1;

        // ✅ Vì sao return rob1, không phải rob2?
        // Sau vòng lặp cuối cùng (i = n-1) cần dp[n-1] chính là temp -> temp được vập nhật vào rob1
    }


    /*
    OPTIMIZE SPACE

    TƯƠNG TỰ NHƯ TRÊN NHƯNG DUYỆT TỪ XUÔI

    Time -> O(n)
    Space -> O(1)

    rob1   rob2   [2 , 3 , 2]
     0       0

     */

    public int rob_3(int[] nums) {
        int rob1 = 0; // rob1 = d[i-2]
        int rob2 = 0; // rob2 = dp[i-1]

        for(int num : nums) {
            int temp = Math.max(rob1 + num, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;


        // ✅ Vì sao return rob2, không phải rob1?
        // Sau vòng lặp cuối cùng (i = n-1) cần dp[n-1] chính là temp -> temp được vập nhật vào rob2 
    }

    public static void main(String[] args) {
        
    }
}
