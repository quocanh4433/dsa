
class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int n = nums.length;
        int timeModify = 1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                timeModify--;
                if (timeModify < 0) {
                    return false;
                }

                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    /*
                        TH1 i == 0 
                        [4, 2, 3] 
                        4 > 2 -> vi phạm
                        [2, 2*, 3]


                        TH2
                        [2,5,3,6]
                        tại i = 1 thì 5 > 3 -> vi phạm
                        
                        mà 2 <= 3 -> TRUE
                        
                        [2, 2*, 3, 6]

                     */
                    nums[i] = nums[i + 1];
                } else {
                    /*
                    
                        [3,5,2,6]
                        tại i = 1 thì 5 > 3 -> vi phạm

                        mà 3 <= 2 -> FALSE

                        [3, 5, 5*, 6]
                    
                     */
                    nums[i + 1] = nums[i];
                }

            }
        }

        return true;
    }
}
