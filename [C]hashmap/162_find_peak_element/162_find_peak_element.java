
class FindPeakElement {

    /*
        yêu câu return any of peak không cần đỉnh cao nhất

        time O(logn)
        space O(1)
     */
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
