
public class RangeSumQueryImmutable_BestPractice {

    /*
        Time:   O(n) 
        Space:  O(1)
     */
    class NumArray {

        int[] nums;
        int[] prefix;

        public NumArray(int[] nums) {
            /*
                nums:   1 4 6
                pre:    0 1 5 11     
             */
            this.nums = nums;
            this.prefix = new int[nums.length + 1];
            /*
                Tại sao cộng thêm 1 ?
                👉 Vì cần thêm prefix đầu tiên bằng 0;
             */
            prefix[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

    public static void main(String[] args) {

    }
}
