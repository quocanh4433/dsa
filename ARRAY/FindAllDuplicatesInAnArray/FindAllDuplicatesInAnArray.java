import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInAnArray {

    /**
     * SOLUTION 1:
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(n)
     *
     */
    public static List<Integer> findDuplicates(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> seen = new HashMap<>(); // key: num - value: freq

        for (int num : nums) {
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int key : seen.keySet()) {
            if (seen.get(key) > 1) {
                result.add(key);
            }
        }
        return result;
    }

    /**
     * SOLUTION 2:
     *
     * Time complexity: O(n)
     *
     * Space complexity: O(1)
     *
     */
    public static List<Integer> findDuplicates_2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int idx = num - 1;

            if (nums[idx] < 0) {
                result.add(num);
            }

            nums[idx] *= -1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
        System.out.println(findDuplicates_2(nums));
    }
}
