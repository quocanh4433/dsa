public class MissingNumber {
    // SOLUTION 1: HASHSET tự code


    // SOLUTION 2: MATH
    // IDEA: Tính sum từ 0 -> n, sau đó sum trừ dần cho nums[0] -> nums[n] 
    // Time complexity: O(n) - Space complexity: O(1)
    public int missingNumber_2(int[] nums) {
        int res = 0;
        for (int i = 0; i <= nums.length; i++) {
            res += i;
        }

        for (int num : nums) {
            res -= num;
        }

        return res;
    }


    // SOLUTION 3: MATH
    // Chuyên đổi từ solution 2 để chỉ sử dụng 1 vòng for
    // Chi tiết xem file explain.png
    public int missingNumber_3(int[] nums) {
        int n = nums.length;
        int res = n;

        for(int i = 0; i < n; i++) {
            res += i - nums[i];
        }

        return res;
    }
    public static void main(String[] args) {
        
    }
}
