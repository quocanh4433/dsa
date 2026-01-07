
public class RangeSumQueryImmutable_BestPractice {

    /*
        Time:   O(q * n)  - q: là số lần gọi sumRange
        Space:  O(1)
     */

    class NumArray {

        int[] nums;
        int[] prefix;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.prefix = new int[nums.length];
            prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = prefix[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

    public static void main(String[] args) {

    }
}
