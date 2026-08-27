
class SortColor_OnePass {

    /*
        1 pass
        
        time O(n)
        space O(3) ~ O(1)
    
     */
    public void sortColors(int[] nums) {
        int low = 0; // điểm giới hạn của vùng số 0
        int mid = 0; // đoạn mid đến high là vung cần kiểm tra
        int high = nums.length - 1; // điểm giới hạn của vùng số 2

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
                // Lưu ý: Không tăng mid ở đây vì số mới swap từ high về mid chưa được kiểm tra!
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
