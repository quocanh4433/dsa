
import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {

    /*
        time O(n)
        space O(n)
    
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            // lưu ý ở đây:
            // chỉ bắt đầu đểm khi num hiện tại là đầu consecutive sequence
            // mà num là điểm đầu của consecutive sequence khi
            // không có số kề trước nó
            if (!set.contains(num - 1)) {
                int count = 1;

                while (set.contains(num + count)) {
                    count++;
                }

                res = Math.max(count, res);
            }

        }

        return res;
    }
}
