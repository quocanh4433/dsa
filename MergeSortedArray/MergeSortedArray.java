
import java.util.Arrays;

public class MergeSortedArray {

    /* SOLUITON đầu tiên nghĩ ra 

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // So sánh từ cuối mảng, điền vào nums1 từ phải sang trái
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }

            k--;
        }

        // lấy phần tử nums2 còn lại thêm vào trong mảng
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
    
     */
    /**
     * SOLUTION code gọn hơn
     *
     *
     * NHƯNG chưa hiểu lắm - cần nghiệm lại
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

        /**
         * FAIL at testcase why need while loop -> Nếu nums2 còn phần tử thì
         * copy nốt sang nums1
         */
        int[] nums1_2 = {2, 0, 0, 0};
        int m_2 = 1;
        int[] nums2_2 = {1, 3, 4};
        int n_2 = 3;
        merge(nums1_2, m_2, nums2_2, n_2);
        System.out.println(Arrays.toString(nums1_2));
    }
}

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }

            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
