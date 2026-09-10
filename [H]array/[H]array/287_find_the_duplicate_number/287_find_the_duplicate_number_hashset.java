import java.util.HashSet;
import java.util.Set;

class FindTheDuplicateNumber_HashSet {
    /*
        time O(n)
        space O(n)
    */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }
}
