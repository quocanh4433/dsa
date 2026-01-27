public class MaxConsecutiveOnes {
    /*
        time O(n)
        space O(1)
    */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        if (count > 0) {
            max = Math.max(max, count);
        }

        return max;
    }
    public static void main(String[] args) {
        
    }
}
