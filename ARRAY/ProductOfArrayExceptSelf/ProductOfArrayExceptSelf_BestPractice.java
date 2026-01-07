
import java.util.Arrays;


public class ProductOfArrayExceptSelf_BestPractice {

    /*
        Time: O(n)
        Space: O(n)
        
        suf     12

        pre     2

        nums    1   2   3   4
        
        res     1   1   8   6

        Idea tương tự nhưng code gọn hơn
    */

    static int[] productExceptSelf(int[] nums) {      
        int n = nums.length;
        int[] res = new int[n];

        // Chỉ cần 2 biết prefix và suffix. Thay vì tạo 2 mảng riêng biệt.
        int prefix = 1;
        int suffix = 1;
        res[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix *= nums[i - 1];
            res[i] = prefix;
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            if(i == 0) {
                res[i] = suffix;
            } else {
                res[i] *= suffix;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
