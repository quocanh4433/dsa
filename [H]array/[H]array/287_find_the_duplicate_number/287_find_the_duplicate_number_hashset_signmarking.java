
class FindTheDuplicateNumber_SignMarking {

    /*
        time O(n)
        space O(1)

        *** lưu ý 
        - mảng nums là mảng số nguyên dương và chiều dài là n
        - các phẩn từ bên trong chỉ có giá trị trong đoạn [1, n - 1];

     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        for (int num : nums) {
            int i = Math.abs(num);

            if (nums[i] < 0) {
                return i;
            }

            nums[i] *= -1;
        }

        return -1;
    }
}
