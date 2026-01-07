
public class RangeSumQueryImmutable {
    /*
        Time:   O(q * n)  - q: là số lần gọi sumRange
        Space:  O(1)
    */


    class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int ans = 0;
            for (int i = left; i <= right; i++) {
                ans += nums[i];
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        
    }
}
