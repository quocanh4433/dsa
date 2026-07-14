import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    /*
        time O(n)
        space O(n)
    */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
