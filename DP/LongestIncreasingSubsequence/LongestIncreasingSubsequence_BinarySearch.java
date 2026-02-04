

public class LongestIncreasingSubsequence_BinarySearch {
    /*
        tim O(nlogn)
        space: O(n)

        prop
            - tăng hiệu năng
        cons    
            - chỉ có độ dài - không biết được phần tử trong subsequeces 
    */

    public int lengthOfLIS(int[] nums) {
        /*
            dp[i] = value
                i: cho biết độ dài 
                value: giá trị nhỏ nhất trong nums 

            example:
            
            nums = [3, 7, 9]

            dp[0] = 3
            dp[1] = 7 // xét tưng cặp 2 số
            dp[2] = 9

        */
        int[] dp = new int[nums.length];
        
        // mặc định ở độ dài 1 có nums[0] trong trường hợp nums.length = 1
        dp[0] = nums[0];

        int size = 1;

        // duyệt qua tưng số để phân bô số đo vào mảng dp
        for(int num : nums) {
            int l = 0, r = size;

            while(l < r) {
                int mid = (l + r) / 2;
                if(dp[mid] < num) {
                    dp
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence_BinarySearch LIS = new LongestIncreasingSubsequence_BinarySearch();
        int[] nums = {1, 2, 4, 3};
        LIS.lengthOfLIS(nums);
    }
}
