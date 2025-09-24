
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0); // First element

        for (int i = 1; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[1];
    }

    public static void main(String[] args) {

    }
}
