import java.util.Arrays;

class WiggleSortII {

    /*
        time O(nlogn)
        space O(n)

        **ý tưởng:

        chia mảng làm 2 phần small và large

        lấy xen kẽ phần từ lớn nhất của small và lớn nhất của large

        
        
        
        tại sao không lấy xe kẽ small nhỏ đến lớn và large lớn đến nhỏ?
        
        tránh dupplicate

        vd: [1,3,2,2,3,1] -> sort: [1,1,2,2,3,3]

        small: [1,1,2]
        large: [2,3,3]

        nếu lấy theo từ tự small nhỏ -> lớn và large lớn -> nhỏ

        [1,3,1,3,2,2] -> xuất hiện sô "2" bị duplicate ở cuối
    
    
     */
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int n = nums.length;
        int m = (n - 1) / 2;
        int r = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[m];
                m--;
            } else {
                nums[i] = sorted[r];
                r--;
            }
        }

    }
}
