
class SortColor_TwoPass {

    /*
        2 pass
        
        time O(n)
        space O(3) ~ O(1)
    
     */
    public void sortColors(int[] nums) {
        int[] count = new int[3];

        for (int num : nums) {
            count[num]++;
        }

        int i = 0;
        int num = 0;

        while (i < nums.length) {
            while (i < nums.length && count[num] > 0) {
                nums[i] = num;
                i++;
                count[num]--;
            }
            num++;
        }
    }
}
