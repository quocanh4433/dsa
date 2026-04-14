
import java.util.HashMap;
import java.util.Map;

class SubarraySumEqualsK {
    /*
        time O(n)
        space O(n)
    */
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        Map<Integer, Integer> prefixMap = new HashMap<>(); // key: prefix - value: freq
        prefixMap.put(0, 1); // xuất hiện 1 lần prefix 0 trước phần tử đầu tiên

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (prefixMap.containsKey(currentSum - k)) { // trươc đó có prefixSum nào = currentSum - k không?
                count += prefixMap.getOrDefault(currentSum - k, 0);
            }
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
