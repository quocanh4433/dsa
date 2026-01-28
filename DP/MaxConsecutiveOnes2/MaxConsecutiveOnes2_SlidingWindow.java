public class MaxConsecutiveOnes2_SlidingWindow {
    /*
        Neetcode
        
        time O(n)
        space O(1)
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) {
            /*
                tại sao nums = [0] return 1?
                👉 có thể lấy 0 flip thành 1
            */
            return 1;
        }

        boolean hasZero = false;
        int indexZero = -1;
        int l = 0, r = 0;
        int max = 0;
        int count = 0;

        while (l <= r && r < nums.length) {
            if (nums[r] == 1) {
                count++;
            } else if (nums[r] == 0 && hasZero == false) {
                hasZero = true;
                indexZero = r;
                count++;
            } else if (nums[r] == 0 && hasZero == true) {
                max = Math.max(max, count);
                l = indexZero + 1;
                count -= l;
            }
            r++;
        }

        return Math.max(max, count);
    }
    public static void main(String[] args) {
        
    }
}
