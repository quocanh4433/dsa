
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInAnArray {

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

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }
}
