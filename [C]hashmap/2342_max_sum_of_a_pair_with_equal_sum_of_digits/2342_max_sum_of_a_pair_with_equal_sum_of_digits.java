import java.util.HashMap;
import java.util.Map;

class MaxSumOfAPairWithEqualSumOfDigits {

    /*
        time O(n * d)
        space O(n)

        n: số lượng phần tử trong nums.
        d: số chữ số của mỗi số (mỗi lần phải tính tổng các chữ số).
    
     */
    public int maximumSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int num : nums) {
            int sum = 0;
            int temp = num;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, num);
            } else {
                ans = Math.max(ans, num + map.get(sum));
                map.put(sum, Math.max(num, map.get(sum)));
            }
        }

        return ans;
    }
}
