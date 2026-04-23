
class MaximumLengthOfSubarrayWithPositiveProduct {

    /*
        gần với problem 152
        
        time O(n)
        space O(1)
     */
    public int getMaxLen(int[] nums) {
        int positiveLen = 0;
        int negetiveLen = 0;
        int res = 0;

        for (int num : nums) {
            if (num > 0) {
                // nhân với dương
                // dương -> dương
                // âm -> âm
                positiveLen += 1;
                negetiveLen = negetiveLen > 0 ? negetiveLen + 1 : 0;
            } else if (num < 0) {
                // nhân với âm dôi vi jtris cho nhau [1 2 -5]
                // dương -> âm
                // âm -> dương
                int temp = positiveLen;
                positiveLen = negetiveLen > 0 ? negetiveLen + 1 : 0;
                negetiveLen = temp + 1;
            } else { // num == 0
                positiveLen = 0;
                negetiveLen = 0;
            }

            res = Math.max(res, positiveLen);
        }

        return res;
    }
}
