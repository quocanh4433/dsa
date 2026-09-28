import java.util.Arrays;

class MinimumMovesToEqualArrayElementsII_Sort {

    /*
        time O(nlogn)
        space O(1)

        số bước thực hiện là chênh lệch với num ở giữa mảng
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int mid = nums.length / 2;
        int median = nums[mid];
        int res = 0;

        for (int num : nums) {
            res += Math.abs(num - median);
        }

        return res;
    }
}
