
class ArrayPartition {

    /*
        ý tưởng 

        sort để các cặp liền kề có min tối ưu nhất -> sum tối ưu

        vd: [4, 10, 5, 20] 
        min(4, 10) + min(5, 20) = 4 + 5 = 9

        lúc này min luôn à số nhỏ không tối ưu cho sum nên sort lại

        [4, 5, 10, 20]
        min(4, 5) + min(10, 20) = 4 + 10 = 14


        time O(nlogn)
        space O(1)
    
     */

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
