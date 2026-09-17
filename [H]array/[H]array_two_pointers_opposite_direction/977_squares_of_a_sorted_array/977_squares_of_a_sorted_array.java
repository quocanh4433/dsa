
class SquaresOfASortedArray {

    /*
    
        ** insight:
        Extra sorting is not required. The nums array is already sorted in non decreasing order. Therefore, when squared, the largest numbers will be from the beginning or the end of the array.
    
    
        **lưu ý: 
        nếu mang chi có số âm


        time O(n)
        space O(n) if we count res, if not O(1)
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int i = n - 1;

        int[] res = new int[n];

        while (i >= 0) {
            if (Math.abs(nums[r]) >= Math.abs(nums[l])) {
                res[i] = nums[r] * nums[r];
                r--;
            } else {
                res[i] = nums[l] * nums[l];
                l++;
            }

            i--;
        }

        return res;
    }
}
